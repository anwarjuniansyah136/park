package com.barcode.barcodeapi.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersResponseDto {
    private Integer id;
    private String name;
    private String plat;
    private String jurusan;
    private byte[] image;
}
