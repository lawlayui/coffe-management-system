package com.lawlayui.coffe_shop.recipe.domain.entity;

import com.lawlayui.coffe_shop.recipe.domain.value_object.MaterialId;
import com.lawlayui.coffe_shop.recipe.domain.value_object.MaterialQuantity;
import com.lawlayui.coffe_shop.recipe.domain.value_object.UOM;

public class Material {
    private MaterialId materialId;
    private String SKU;
    private UOM uom;
    private MaterialQuantity quantity;

    private Material(MaterialId materialId, String sku, UOM uom, MaterialQuantity quantity) {
        this.materialId = materialId;
        this.SKU = sku;
        this.uom = uom;
        this.quantity = quantity;
    }

    public static Material create(String id, String sku, UOM uom, Float quantity){
        return new Material(new MaterialId(id), sku, uom, new MaterialQuantity(quantity));    
    }

    public void changeUOM(UOM uom) {
        this.uom = uom;
    }

    public void changeQuantity(Float newQuantity) {
        this.quantity = new MaterialQuantity(newQuantity);
    }

    public MaterialId getMaterialId() {
        return materialId;
    }
    public String getSKU() {
        return SKU;
    }
    public UOM getUom() {
        return uom;
    }
    public Float getQuantity() {
        return quantity.value();
    }
}
