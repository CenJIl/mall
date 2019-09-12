package com.cenjil.controller.websocket;

import com.cenjil.config.AppContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * @author CenJIl
 * @date 2019/9/4 9:38
 */
public class WebSocketHandler extends AbstractWebSocketHandler {
    private Log logger = LogFactory.getLog(this.getClass());

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        AppContext.getUserContext().setWebSocketSession(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.debug("String: " + message.getPayload());
    }

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("1.txt"));

        logger.debug("Byte[]: " + message.getPayload().toString());
    }

    @Override
    protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        session.sendMessage(new TextMessage(exception.getMessage()));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        AppContext.cleanWebSocketSession();
    }
}
