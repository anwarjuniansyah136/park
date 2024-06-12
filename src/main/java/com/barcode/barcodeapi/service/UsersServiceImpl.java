package com.barcode.barcodeapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barcode.barcodeapi.dto.UsersResponseDto;
import com.barcode.barcodeapi.entity.User;
import com.barcode.barcodeapi.repository.UsersRespository;
@Service
public class UsersServiceImpl implements UsersService{
    @Autowired
    UsersRespository usersRespository;
    @Override
    public UsersResponseDto responseDto(Integer userId) {
        User users = usersRespository.getReferenceById(userId);
        UsersResponseDto response = new UsersResponseDto();
        response.setId(users.getId());
        response.setName(users.getName());
        response.setPlat(users.getPlat());
        response.setJurusan(users.getJurusan());
        response.setImage(users.getImage());
        return response;
    }
    @Override
    public List<User> findAll() {
        return usersRespository.findAll();
    }
}
