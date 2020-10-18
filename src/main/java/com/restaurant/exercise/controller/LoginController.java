package com.restaurant.exercise.controller;

import com.restaurant.exercise.domain.request.UserRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @ApiOperation(value = "Login",
            notes = "create new token")
    @PostMapping(value = "/login", consumes = "application/json")
    public void fakeLogin(@RequestBody UserRequest userRequest) {
        throw new IllegalStateException("This method shouldn't be called. It's implemented by Spring Security filters.");
    }


}
