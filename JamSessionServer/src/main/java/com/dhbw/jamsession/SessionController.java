package com.dhbw.jamsession;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
public class SessionController {
	
	@Autowired
    private SimpMessageSendingOperations messagingTemplate;
	
	
	public String createSession() {
		String sessionKey = UUID.randomUUID().toString();
		return sessionKey;
	}

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
    	ChatMessage chatMessage1 = new ChatMessage();
    	for(int i=0;i<1000;i++) {
    		
            chatMessage1.setType(ChatMessage.MessageType.CHAT);
            chatMessage1.setContent("Tick");
            chatMessage1.setSender("Server");
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	messagingTemplate.convertAndSend("/topic/public", chatMessage);
    	}
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, 
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

}
