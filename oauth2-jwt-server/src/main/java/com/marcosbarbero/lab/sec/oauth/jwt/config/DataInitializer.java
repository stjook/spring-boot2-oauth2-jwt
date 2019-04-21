package com.marcosbarbero.lab.sec.oauth.jwt.config;


import com.marcosbarbero.lab.sec.oauth.jwt.model.User;
import com.marcosbarbero.lab.sec.oauth.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {
	@Autowired
	UserRepository users;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {

		this.users.save(new User("user", this.passwordEncoder.encode("123"), Arrays.asList( "ROLE_USER")));

		this.users.save(new User("admin", this.passwordEncoder.encode("123"), Arrays.asList( "ROLE_USER", "ROLE_ADMIN")));
	}
}

