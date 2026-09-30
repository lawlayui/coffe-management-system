package com.lawlayui.coffe_shop.menu.infrastructure.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lawlayui.coffe_shop.menu.application.in.ChangeMenuItemPriceCommand;
import com.lawlayui.coffe_shop.menu.application.in.GetAllMenuItemQuery;
import com.lawlayui.coffe_shop.menu.application.services.ChangeMenuItemPriceUseCase;
import com.lawlayui.coffe_shop.menu.application.services.GetAllMenuItemUseCase;
import com.lawlayui.coffe_shop.menu.application.services.GetMenuItemByIdUseCase;
import com.lawlayui.coffe_shop.menu.domain.MenuItem;

@RestController 
@RequestMapping("/api/v1/menu/item")
public class MenuController {
    private GetAllMenuItemUseCase getAllMenuItemUseCase;
    private GetMenuItemByIdUseCase getMenuItemByIdUseCase;
    private ChangeMenuItemPriceUseCase changeMenuItemPriceUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<MenuItem> getById(@PathVariable String id) {
        return ResponseEntity.ok(getMenuItemByIdUseCase.GetById(id));
    }

    @GetMapping
    public ResponseEntity<List<MenuItem>> getAll(@RequestParam int page, @RequestParam  int pageSize) {
        return ResponseEntity.ok(getAllMenuItemUseCase.getAll(new GetAllMenuItemQuery(page, pageSize, null)));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> changeMenuItemPrice(@PathVariable String id, @RequestBody ChangeMenuItemPriceCommand command) {
        changeMenuItemPriceUseCase.changePrice(new ChangeMenuItemPriceCommand(id, command.price()));
        return ResponseEntity.noContent().build();
    }
}
