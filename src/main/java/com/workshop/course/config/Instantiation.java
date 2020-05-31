package com.workshop.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.workshop.course.domain.User;
import com.workshop.course.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		// instanciar os objetos e salvar no banco de dados
		userRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		// injetar user repository
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
	}

}
