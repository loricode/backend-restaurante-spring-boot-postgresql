package com.restaurante.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.models.menu.Menu;
import com.restaurante.models.menu.MenuRequest;
import com.restaurante.repositories.menu.MenuRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/menu")
public class MenuController {
	    
    @Autowired
    private MenuRepository menu;
    
    @PostMapping("listar")
	public ResponseEntity<List<Menu>> listarMenus(){
		return ResponseEntity.ok( menu.findAll() ); 
	}
    
    @PostMapping("agregar")
	public ResponseEntity<String> addMenu(@RequestBody MenuRequest mr){
		System.out.println(mr.getMenuName());
    	return ResponseEntity.ok( menu.addOne(mr) ); 
	}
	
}
