package com.barcode.barcodeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barcode.barcodeapi.dto.GenericResponse;
import com.barcode.barcodeapi.service.UsersService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/users")
@Tag(name = "USERS")
public class UsersController {
    @Autowired
    UsersService usersService;

    @GetMapping("/get")
    public ResponseEntity<Object> getBarcode(@RequestParam Integer userId){
        try {
            return ResponseEntity.ok().body(GenericResponse.success(usersService.responseDto(userId), "Success"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(GenericResponse.error("Please,Try Again"));
        }
    }

    @GetMapping("/get-all")
    public ResponseEntity<Object> findAll(){
        try {
            return ResponseEntity.ok().body(GenericResponse.success(usersService.findAll(), "Success"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(GenericResponse.error("Please,Try Again"));
        }
    }
}
