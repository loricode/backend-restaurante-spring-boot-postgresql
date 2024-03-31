package com.restaurante.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.models.login.*; 

@RestController
@CrossOrigin
@RequestMapping("/api/login")
public class LoginController {

    
	@PostMapping("autenticar")
	public ResponseEntity<Login> addUser(@RequestBody Login login){
        
		System.out.println(login.user + login.password);
		return ResponseEntity.ok(login); 
		
	}
	
	
}
