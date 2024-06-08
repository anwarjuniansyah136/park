package com.barcode.barcodeapi.service;

import java.io.IOException;
import java.sql.Blob;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barcode.barcodeapi.dto.UsersRequestDto;
import com.barcode.barcodeapi.dto.UsersResponseDto;
import com.barcode.barcodeapi.entity.Users;
import com.barcode.barcodeapi.repository.UsersRespository;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Base64;

@Service
public class UsersServiceImpl implements UsersService{
    @Autowired
    UsersRespository usersRespository;

    @Override
    public String createBarcode(UsersRequestDto dto) {
        Users users = new Users();
        users.setName(dto.getName());
        users.setNim(dto.getNim());
        users.setPassword(dto.getPassword());
        users.setJurusan(dto.getPlat());
        users.setPlat(dto.getPlat());
        String userData = users.toString();
        try {
            byte[] barcodeImage = generateBarcodeImage(userData);
            Blob imageBlob = new SerialBlob(barcodeImage);
            users.setImage(imageBlob);
            usersRespository.save(users);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Unimplemented method 'responseDto'");
        }
        return "success";
    }
    private static byte[] generateBarcodeImage(String data) throws WriterException, IOException {
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = barcodeWriter.encode(data, BarcodeFormat.QR_CODE, 200, 200);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        return pngOutputStream.toByteArray();
    }

    @Override
    public UsersResponseDto responseDto(String userId) {
        Users users = usersRespository.getReferenceById(userId);
        UsersResponseDto response = new UsersResponseDto();
        response.setId(users.getId());
        response.setName(users.getName());
        response.setPlat(users.getPlat());
        response.setJurusan(users.getJurusan());
        response.setImage(blobToBase64String(users.getImage()));
        return response;
    }
    
    private String blobToBase64String(Blob blob) {
        if (blob == null) {
            return null;
        }

        try (InputStream inputStream = blob.getBinaryStream();
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            return Base64.getEncoder().encodeToString(outputStream.toByteArray());
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert Blob to Base64 String", e);
        }
    }
}
