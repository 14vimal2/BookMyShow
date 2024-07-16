package com.example.BookMyShow;

import com.example.BookMyShow.controllers.UserController;
import com.example.BookMyShow.dtos.SignUpRequestDTO;
import com.example.BookMyShow.dtos.SignUpResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyShowApplication implements CommandLineRunner {

	@Autowired
	UserController userController;


	public static void main(String[] args) {

		SpringApplication.run(BookMyShowApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		SignUpRequestDTO signUpRequestDTO = new SignUpRequestDTO();
		signUpRequestDTO.setEmail("vimal@ek-pahal.com");
		signUpRequestDTO.setPassword("password");

		SignUpResponseDTO signUpResponseDTO = userController.signUp(signUpRequestDTO);


	}
}
