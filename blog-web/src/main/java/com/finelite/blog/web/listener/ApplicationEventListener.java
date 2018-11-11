package com.finelite.blog.web.listener;


import com.finelite.blog.daoimp.redis.RedisDaoImp;
import com.finelite.blog.utils.jwt.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationEventListener implements ApplicationListener<ApplicationReadyEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationEventListener.class);
    @Value("user.name")
    private String username;
    @Value("user.pass")
    private String password;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        RedisDaoImp redis= BeanUtil.getBean("redisDaoImp");
        redis.set(username,password);

        LOGGER.info("------ onApplicationEvent : LoginBean ");
    }
}

