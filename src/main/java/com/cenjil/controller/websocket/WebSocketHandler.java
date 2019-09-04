package com.cenjil.controller.websocket;

import com.cenjil.config.AppContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

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
        String get = message.getPayload();
        String post = "返回" + get;
        session.sendMessage(new TextMessage(post));
        logger.debug(message.getPayload());
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
