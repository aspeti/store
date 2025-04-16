package com.uab.taller.store.usecase;

import com.uab.taller.store.domain.User;
import com.uab.taller.store.domain.dto.request.UserRequest;
import com.uab.taller.store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {

    @Autowired
    IUserService userService;

    public User execute(UserRequest userRequest) {

        User user = new User();
        user.setName(userRequest.getName());
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
        return  userService.save(user);
    }
}
