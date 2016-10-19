package me.nicolaferraro.config.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class HelloBean {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private HelloConfig config;


    @Scheduled(initialDelay = 2000, fixedDelay = 5000)
    public void timeout() {
        if(config.getMessages()!=null) {
            logger.info("Message is: {}", config.getMessages().stream().reduce((s1, s2) -> s1 + " " + s2).orElse("[]"));
        } else {
            logger.warn("No configuration for messages");
        }
    }

}
