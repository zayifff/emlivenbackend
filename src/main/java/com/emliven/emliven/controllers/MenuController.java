package com.emliven.emliven.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emliven.emliven.entities.Menu;
import com.emliven.emliven.services.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {
	
	private MenuService menuService;
	
	public MenuController(MenuService menuService) {
		this.menuService = menuService;
	}
	
    @GetMapping
    public List<Menu> getAllMenu() {
        return menuService.getAllMenu();
    }
    
    @PostMapping
    public Menu createMenu(@RequestBody Menu newMenu) {
        return menuService.saveOneMenu(newMenu);
    }
    
    @DeleteMapping("/{menuID}")
    public void deleteOneMenu(@PathVariable Long menuID) {
        menuService.deleteById(menuID);
    }

}
