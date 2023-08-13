package com.in28minutes.learnspringframework.examples.a0;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;

@Configuration
@ComponentScan("com.in28minutes.learnspringframework.examples.a1")
public class SimpleSpringContextLauncherApplication {
	
	public static void main(String[] args) {
		
		try (var context 
				= new AnnotationConfigApplicationContext
					(SimpleSpringContextLauncherApplication.class);){
			
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
		}
		
	}

}