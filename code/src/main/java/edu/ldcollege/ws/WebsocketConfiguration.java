package edu.ldcollege.ws;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.HandshakeInterceptor;

@Configuration
public class WebsocketConfiguration implements WebSocketConfigurer {
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(new RobotWsSocketHandler(), "/web/robot")
				.addInterceptors(new WebSocketHandshakeInterceptor());
	}
}

class WebSocketHandshakeInterceptor implements HandshakeInterceptor {

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		HttpSession session = null;
		if (request instanceof ServletServerHttpRequest) {
			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
			session = servletRequest.getServletRequest().getSession();
		} else if (request instanceof HttpServletRequest) {
			session = ((HttpServletRequest) request).getSession();
		}

		if (session != null) {
			// 使用userName区分WebSocketHandler，以便定向发送消息
			String userName = (String) session.getAttribute("ws_username");
			if (userName == null) {
				userName = session.getId();
			}
			attributes.put("ws_username", userName);
			System.out.println("bind user name to websocket session attr " + userName);
		}

		return true;
	}

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {

	}
}