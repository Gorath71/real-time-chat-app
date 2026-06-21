package com.example.demo.message;

import org.springframework.stereotype.Service;

import com.example.demo.app_user.AppUser;
import com.example.demo.app_user.AppUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessageService {

	private final MessageRepository messageRepository;
	private final AppUserRepository appUserRepository;
	
	public MessageResponseDto sendMessage(SendMessageRequestDto request) {
		AppUser sender = appUserRepository.findById(request.senderId()).orElseThrow();
		AppUser receiver = appUserRepository.findById(request.receiverId()).orElseThrow();
		
		Message newMessage = Message.builder()
								.content(request.content())
								.sender(sender)
								.receiver(receiver)
								.build();
		
		Message sentMessage = messageRepository.save(newMessage);
		
		return new MessageResponseDto(
				sentMessage.getId(),
				sentMessage.getContent(),
				sentMessage.getSender().getId(),
				sentMessage.getReceiver().getId(),
				sentMessage.getCreatedAt()
				);
	}	
}
