package edu.ldcollege;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

@SpringBootApplication(scanBasePackages = "edu.ldcollege.**")
@MapperScan("edu.ldcollege.mapping")
public class App extends SpringBootServletInitializer
{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		 
		return application.sources(App.class);
	}
	
    public static void main( String[] args ) throws Exception
    {
    	Enumeration<URL> resouces;
		try {
			resouces = Thread.currentThread().getContextClassLoader().getResources("leader");
			while(resouces.hasMoreElements())
			{
				System.out.println("$$$$$$$$$"+resouces.nextElement());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		ConfigurableApplicationContext ctx = SpringApplication.run(App.class, args);
    }
}
