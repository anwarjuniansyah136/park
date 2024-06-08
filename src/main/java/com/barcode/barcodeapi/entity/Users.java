package com.barcode.barcodeapi.entity;

import java.sql.Blob;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @UuidGenerator
    @Column(name = "id",length = 36,nullable = false)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "nim")
    private String nim;

    @Column(name = "password")
    private String password;

    @Column(name = "plat")
    private String plat;

    @Column(name = "jurusan")
    private String jurusan;

    @Lob
    @Column(name = "image")
    private Blob image;
}
