package edu.ldcollege.ws;

import java.util.Map.Entry;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class RobotWsSocketHandler extends TextWebSocketHandler {  
	  
	public RobotWsSocketHandler()
	{
		System.out.println("created RobotWsSocketHandler "+this);
	}
    private static long count = 0;  
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {  
    	for(Entry<String, Object> attr:session.getAttributes().entrySet())
    	{
    		System.out.println("websocket  "+attr.getKey()+":"+attr.getValue());
    	}
        session.sendMessage(new TextMessage("你的意思是:" + (++count) +message.getPayload()+"?"));  
        
    }  
}  