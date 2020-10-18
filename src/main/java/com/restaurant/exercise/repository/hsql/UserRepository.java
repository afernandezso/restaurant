package com.restaurant.exercise.repository.hsql;

import com.restaurant.exercise.repository.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
