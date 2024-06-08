package com.barcode.barcodeapi.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersRequestDto {
    private String name;
    private String nim;
    private String password;
    private String plat;
    private String jurusan;
}
