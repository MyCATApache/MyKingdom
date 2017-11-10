package io.imking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Desc: MyKingdom App
 *
 * @date: 09/11/2017
 * @author: gaul
 */
@SpringBootApplication
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 5 * 60)
public class MyKingdonApp {
    public static void main(String[] args) {
        SpringApplication.run(MyKingdonApp.class, args);
    }
}
