package com.fourth.fourthproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.fourth.fourthproject", exclude = {JpaRepositoriesAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class FourthprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FourthprojectApplication.class, args);
	}

}
