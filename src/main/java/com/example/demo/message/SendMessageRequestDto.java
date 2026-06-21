package com.example.demo.message;

public record SendMessageRequestDto(
		String content,
		Long senderId,
		Long receiverId
		) {

}
