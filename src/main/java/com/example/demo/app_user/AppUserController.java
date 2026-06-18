package com.example.demo.app_user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class AppUserController {

	private final AppUserService appUserService;
	
	@GetMapping("/{id}")
	public AppUser findById(@PathVariable Long id) {
		return appUserService.findById(id);
	}
}
