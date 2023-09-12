package com.pratico.transacaofinanceira;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.pratico.transacaofinanceira"})
@SpringBootApplication
public class TransacaofinanceiraApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TransacaofinanceiraApplication.class, args);
	}
}
