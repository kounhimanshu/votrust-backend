package com.votrust.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String username;
    private String password;
    @Column(unique = true, nullable = false)
    private String email;
    private String name;
    @Lob
    private String publicKey; // Store Base64 encoded public key
}
