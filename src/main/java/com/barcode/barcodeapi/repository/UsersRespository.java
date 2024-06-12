package com.barcode.barcodeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barcode.barcodeapi.entity.User;

public interface UsersRespository extends JpaRepository<User,Integer>{
    
}
