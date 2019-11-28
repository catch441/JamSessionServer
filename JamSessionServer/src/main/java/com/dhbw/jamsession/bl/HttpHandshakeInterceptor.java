package com.dhbw.jamsession.bl;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.util.WebUtils;

@CrossOrigin
public class HttpHandshakeInterceptor implements HandshakeInterceptor{

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception e) {
		ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
		HttpServletRequest servletRequest2 = servletRequest.getServletRequest();
		Cookie token1 = WebUtils.getCookie(servletRequest2, "sessionId");
		Cookie token2 = WebUtils.getCookie(servletRequest2, "name");
		Cookie token3 = WebUtils.getCookie(servletRequest2, "sessionPasswordHash");
		if(!JamSession.sessionExists(token1.getValue())) {
			JamSession.createNewJamSession(token1.getValue(), token3.getValue(), token2.getValue());
		} else {
			JamSession session = JamSession.getJamSessionByName(token1.getValue());
			if(session.getPasswordhash().equals(token3.getValue())) {
				session.addPlayer(token2.getValue());
			}
		}
	}

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) {
		if (request instanceof ServletServerHttpRequest) {
			
			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
			HttpServletRequest servletRequest2 = servletRequest.getServletRequest();
			System.out.println(servletRequest2.toString());
			Cookie token1 = WebUtils.getCookie(servletRequest2, "sessionId");
			Cookie token2 = WebUtils.getCookie(servletRequest2, "name");
			Cookie token3 = WebUtils.getCookie(servletRequest2, "sessionPasswordHash");
			attributes.put("sessionId", token1.getValue());
			attributes.put("username", token2.getValue());
			if(JamSession.sessionExists(token1.getValue())) {
				JamSession jamSession = JamSession.getJamSessionByName(token1.getValue());
				if(!jamSession.getPasswordhash().equals(token3.getValue()) || jamSession.hasPlayer(token2.getValue())) {
					response.setStatusCode(HttpStatus.FORBIDDEN);
					return false;
				}
			}
		}
		return true;
	}

}
