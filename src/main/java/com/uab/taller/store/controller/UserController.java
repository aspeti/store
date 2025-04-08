package com.uab.taller.store.controller;


import com.uab.taller.store.domain.User;
import com.uab.taller.store.domain.dto.request.UserRequest;
import com.uab.taller.store.service.IUserService;
import com.uab.taller.store.usecase.CreateUserUseCase;
import com.uab.taller.store.usecase.DeleteUserUseCase;
import com.uab.taller.store.usecase.GetAllUsersUseCase;
import com.uab.taller.store.usecase.GetUserByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class  UserController {

    @Autowired
    IUserService userService;

    @Autowired
    GetAllUsersUseCase getAllUsersUseCase;

    @Autowired
    GetUserByIdUseCase getUserByIdUseCase;
    @Autowired
    CreateUserUseCase createUserUseCase;
    @Autowired
    DeleteUserUseCase deleteUserUseCase;

    @GetMapping()
    public List<User> getAll() {
        return getAllUsersUseCase.execute();
    }

    @GetMapping(value = "/{userId}")
    public User getById(@PathVariable Long userId) {
        return getUserByIdUseCase.execute(userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteById(@PathVariable Long userId) {
        deleteUserUseCase.execute(userId);
    }
    @PostMapping("")
    public User save(@RequestBody UserRequest userRequest) {

        User user = new User();
        user.setName(userRequest.getName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        return createUserUseCase.execute(user);
    }


}
