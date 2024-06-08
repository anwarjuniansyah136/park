package com.barcode.barcodeapi.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersResponseDto {
    private String id;
    private String name;
    private String plat;
    private String jurusan;
    private String image;
}
