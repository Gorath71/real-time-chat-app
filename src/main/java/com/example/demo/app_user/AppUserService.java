package com.example.demo.app_user;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppUserService {
	
	private final AppUserRepository appUserRepository;
	
	public AppUser findById(Long id) {
		return appUserRepository.findById(id).get();
	}
	
}
