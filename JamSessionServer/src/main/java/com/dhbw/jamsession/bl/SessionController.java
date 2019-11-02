package com.dhbw.jamsession.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
public class SessionController {
	
	private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

	  @Autowired
	  private SimpMessageSendingOperations messagingTemplate;

	  @MessageMapping("/jamsession/{sessionId}/sendChatMessage")
	  public void sendChatMessage(@DestinationVariable String sessionId, @Payload ChatMessage chatMessage) {
	    messagingTemplate.convertAndSend("/jamsession/" + sessionId, chatMessage);
	  }
	  
	  @MessageMapping("/jamsession/{sessionId}/sendSoundMessage")
	  public void sendSoundMessage(@DestinationVariable String sessionId, @Payload SoundMessage soundMessage) {
	    messagingTemplate.convertAndSend("/jamsession/" + sessionId, soundMessage);
	  }
}
