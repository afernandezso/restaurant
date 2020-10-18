package com.restaurant.exercise.service.impl;

import com.restaurant.exercise.error.RestaurantException;
import com.restaurant.exercise.repository.hsql.UserRepository;
import com.restaurant.exercise.repository.model.User;
import org.junit.After;
import org.junit.Before;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@SpringBootTest
class UserDetailsServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;


   @Test
    void loadUserByUsernameNull() {
        when(userRepository.findByUsername(any(String.class))).thenReturn(null);
        assertThrows(UsernameNotFoundException.class, () -> userDetailsService.loadUserByUsername("afernandez"));
    }

    @Test
    void loadUserByUsernameErrorName() {
        User user = new User();
        user.setPassword("1234");
        user.setUsername("admin");
        doReturn(user).when(userRepository).findByUsername("afernandez");

        when(userRepository.findByUsername(any(String.class))).thenReturn(user);
        assertThrows(UsernameNotFoundException.class, () -> userDetailsService.loadUserByUsername("afernandez"));
    }

}
