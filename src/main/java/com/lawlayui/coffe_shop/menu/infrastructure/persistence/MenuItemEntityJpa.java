package com.lawlayui.coffe_shop.menu.infrastructure.persistence;

import java.math.BigDecimal;

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
@Table(name = "menu_item")
@AllArgsConstructor 
@NoArgsConstructor 
@Builder 
@Getter 
@Setter 
public class MenuItemEntityJpa {
    @Id 
    private String menuItemId; 

    @Column(name = "branch_id")
    private String branchId; 

    @Column(name = "recipe_id")
    private String recipe_id; 

    @Column(name = "menu_status")
    private String menuStatus;

    private BigDecimal price;
}
