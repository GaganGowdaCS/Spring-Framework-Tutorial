package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// released in JDK 16
record Person (String name, int age, Address address) {};
record Address (String firstLine, String city) {};

@Configuration
public class HelloWorldConfiguration {

	@Bean
	public String name() {
		return "Ranga";
	}
	
	@Bean
	public int age() {
		return 18;
	}
	
	@Bean
	public Person person() {
		return new Person("Ravi", 20, new Address("Main Street", "Dallas"));
	}
	
	@Bean
	public Person person2MethodCall() {
		return new Person(name(), age(), address()); //name, age
	}
	
	@Bean
	public Person person3Parameters(String name, int age, Address address3) {
		return new Person(name, age, address3); //name, age, address 2
	}
	
	@Bean
	@Primary
	public Person person4Parameters(String name, int age, Address address) {
		return new Person(name, age, address); //name, age, address 2
	}
	
	@Bean
	public Person person5Qualifier(String name, int age, @Qualifier("address2qualifier")
Address address) {
		return new Person(name, age, address); //name, age, address 2
	}
	
	@Bean(name = "address2")
	@Primary 
	public Address address() {
		return new Address("Baker Street", "Frisco");
	}
	
	@Bean(name = "address3")
	@Qualifier("address2qualifier")
	public Address address3() {
		return new Address("Stargazing Rd", "Chicago");
	}
	
	
}
