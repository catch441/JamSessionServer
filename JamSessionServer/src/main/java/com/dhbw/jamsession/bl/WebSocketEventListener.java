package com.dhbw.jamsession.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@CrossOrigin
@Component
public class WebSocketEventListener {

  private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

  @Autowired
  private SimpMessageSendingOperations messagingTemplate;

  @EventListener
  public void handleWebSocketConnectListener(SessionConnectedEvent event) {
    logger.info("Received a new web socket connection.");
  }

  @EventListener
  public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
	  
    StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
    String username = (String) headerAccessor.getSessionAttributes().get("username");
    String sessionId = (String) headerAccessor.getSessionAttributes().get("sessionId");
    if (username != null) {
      logger.info("User Disconnected: " + username);
      JamSession session = JamSession.getJamSessionByName(sessionId);
      session.removePlayer(username);
      if(session.getSessionPlayerSize() == 0) {
    	  JamSession.deleteJamSession(session);;
      } else {
    	  ChatMessage chatMessage = new ChatMessage();
          chatMessage.setType(EnumMessageType.LEAVE);
          chatMessage.setSender(username);
          messagingTemplate.convertAndSend("/jamsession/" + sessionId, chatMessage);
      }
    }
  }
}
