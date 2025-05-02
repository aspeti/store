package com.uab.taller.store.controller;


import com.uab.taller.store.domain.User;
import com.uab.taller.store.domain.dto.request.CreateUserRequest;
import com.uab.taller.store.domain.dto.request.GetUserByEmailRequest;
import com.uab.taller.store.domain.dto.request.UserRequest;
import com.uab.taller.store.service.IUserService;
import com.uab.taller.store.usecase.user.*;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(
            summary = "Get all user in the data base"
    )
    @GetMapping()
    public List<User> getAll() {
        return getAllUsersUseCase.execute();
    }


    @Operation(
            summary = "Get a user by userID"
    )
    @GetMapping(value = "/{userId}")
    public User getById(@PathVariable Long userId) {
        return getUserByIdUseCase.execute(userId);
    }

    @Operation(
            summary = "Delete a user by userId"
    )
    @DeleteMapping("/{userId}")
    public void deleteById(@PathVariable Long userId) {
        deleteUserUseCase.execute(userId);
    }
    @PostMapping("")
    public User save(@RequestBody CreateUserRequest createUserRequest) {
        return createUserUseCase.execute(createUserRequest);
    }

    @Operation(
            summary = "Update a user"
    )
    @PutMapping("/{id}")
    public User update(@PathVariable long id, @RequestBody UserRequest userRequest) {
        return updateUserUseCase.execute(id,userRequest);
    }

    @Operation(
            summary = "get a user by email"
    )
    @GetMapping(value = "/email/{email}")
    public User getByEmail(@PathVariable String email) {
        log.info(email);
        return getUserByEmailUseCase.execute(email);
    }
}
