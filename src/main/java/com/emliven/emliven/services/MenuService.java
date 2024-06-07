package com.emliven.emliven.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emliven.emliven.entities.Menu;
import com.emliven.emliven.repos.MenuRepository;


@Service
public class MenuService {

	
	private MenuRepository menuRepository;
	
	public MenuService(MenuRepository menuRepository) {
		this.menuRepository = menuRepository;
	}

	public List<Menu> getAllMenu() {
		return menuRepository.findAll();
	}

	public Menu saveOneMenu(Menu newMenu) {
		return menuRepository.save(newMenu);
	}

	public void deleteById(Long menuID) {
		menuRepository.deleteById(menuID);
		
	}
}
