package com.barcode.barcodeapi.service;

import java.util.List;

import com.barcode.barcodeapi.dto.UsersResponseDto;
import com.barcode.barcodeapi.entity.User;

public interface UsersService {
    public UsersResponseDto responseDto(Integer userId);
    public List<User> findAll();
}
