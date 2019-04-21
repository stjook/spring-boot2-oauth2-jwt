package com.marcosbarbero.lab.sec.oauth.jwt.repository;


import com.marcosbarbero.lab.sec.oauth.jwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
}
