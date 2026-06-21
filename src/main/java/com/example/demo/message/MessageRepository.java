package com.example.demo.message;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
	
	@Query("""
	    SELECT m
	    FROM Message m
	    WHERE (m.sender.id = :user1Id AND m.receiver.id = :user2Id)
	       OR (m.sender.id = :user2Id AND m.receiver.id = :user1Id)
	    ORDER BY m.createdAt
	""")
	List<Message> findConversation(Long user1Id, Long user2Id);
}
