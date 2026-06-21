package com.example.demo.message;

import java.time.LocalDateTime;

public record MessageResponseDto(
		Long id,
		String context,
		Long senderId,
		Long receiverId,
		LocalDateTime createdAt
		) {

}
