package com.barcode.barcodeapi.service;

import com.barcode.barcodeapi.dto.UsersRequestDto;
import com.barcode.barcodeapi.dto.UsersResponseDto;

public interface UsersService {
    public String createBarcode(UsersRequestDto dto);
    public UsersResponseDto responseDto(String userId);
}
