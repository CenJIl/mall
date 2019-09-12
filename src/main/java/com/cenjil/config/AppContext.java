package com.cenjil.config;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

/**
 * @author CenJIl
 * @date 2019/9/4 10:25
 */
@Component
@SuppressWarnings("all")
public class AppContext implements ApplicationContextAware {
    private static UserContext userContext = new UserContext();

    @Data
    @ApiModel("用户上下文")
    public static class UserContext {
        private String userId;
        private String userName;
        private String password;
        private WebSocketSession  webSocketSession;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    }


    public static UserContext getUserContext() {
        return userContext;
    }

    public static void cleanWebSocketSession() {
        userContext.setWebSocketSession(null);
    }
}
