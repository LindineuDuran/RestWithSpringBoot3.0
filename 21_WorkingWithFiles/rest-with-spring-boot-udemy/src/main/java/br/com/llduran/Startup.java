package br.com.llduran;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//===================================
//Imports para cadastrar novo usuário
//===================================
/*
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import java.util.HashMap;
import java.util.Map;*/
@SpringBootApplication public class Startup
{
	public static void main(final String[] args)
	{
		SpringApplication.run(Startup.class, args);

		   //=================================
		  //Rotina para cadastrar novo usuário
		 //=================================
		  /*Map<String, PasswordEncoder> encoders = new HashMap<>();
		 encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
		 DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("pbkdf2", encoders);
		 passwordEncoder.setDefaultPasswordEncoderForMatches(new Pbkdf2PasswordEncoder());

		 String result = passwordEncoder.encode("admin234");
		 System.out.println("My hash " + result);*/
	}
}