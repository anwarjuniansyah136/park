package com.barcode.barcodeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barcode.barcodeapi.entity.Users;

public interface UsersRespository extends JpaRepository<Users,String>{
    
}
