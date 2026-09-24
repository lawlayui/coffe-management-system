package com.lawlayui.coffe_shop.account.infrastructure.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="account")
public class AccountJpaEntity {
    @Id 
    private String id; 

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, unique = true, length = 255)
    private String email; 

    @Column(nullable = false, length = 50)
    private String role; 

    @Column(nullable = false, length = 50)
    private String status;

    @Column(length = 300)
    private String reason;
}
