package com.marcosbarbero.lab.sec.oauth.jwt.service;


import com.marcosbarbero.lab.sec.oauth.jwt.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class JWTUserDetailsService implements UserDetailsService {

	private UserRepository userRepository;

	public JWTUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return this.userRepository.findByUsername(username)
					   .orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found"));
	}
}
