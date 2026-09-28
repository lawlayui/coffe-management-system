package com.lawlayui.coffe_shop.account.infrastructure.persistence;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(name="account")
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
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

    @Column(name = "created_at")
    @CreationTimestamp 
    private LocalDateTime createdAt; 

    @Column(name = "updated_at")
    @UpdateTimestamp 
    private LocalDateTime updatedAt;

    @Column(name = "google_sub")
    private String googleSub;
}
