package io.imking;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Desc: MyKingdom App
 *
 * @date: 09/11/2017
 * @author: gaul
 */
@SpringBootApplication
// @EnableRedisHttpSession(maxInactiveIntervalInSeconds = 5 * 60)
@MapperScan({"io.imking.biz.mapping"})
public class MyKingdomApp {
	public static void main(String[] args) {
		SpringApplication.run(MyKingdomApp.class, args);
	}
}
