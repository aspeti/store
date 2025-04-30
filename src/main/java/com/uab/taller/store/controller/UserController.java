package com.uab.taller.store.controller;


import com.uab.taller.store.domain.User;
import com.uab.taller.store.domain.dto.request.CreateUserRequest;
import com.uab.taller.store.domain.dto.request.GetUserByEmailRequest;
import com.uab.taller.store.domain.dto.request.UserRequest;
import com.uab.taller.store.service.IUserService;
import com.uab.taller.store.usecase.user.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
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
    @Autowired
    UpdateUserUseCase updateUserUseCase;

    @Autowired
    GetUserByEmailUseCase getUserByEmailUseCase;

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
    public User save(@RequestBody CreateUserRequest createUserRequest) {
        return createUserUseCase.execute(createUserRequest);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable long id, @RequestBody UserRequest userRequest) {
        return updateUserUseCase.execute(id,userRequest);
    }

    @GetMapping(value = "/email/{email}")
    public User getByEmail(@PathVariable String email) {
        log.info(email);
        return getUserByEmailUseCase.execute(email);
    }
}
