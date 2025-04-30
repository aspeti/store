package com.uab.taller.store.usecase.user;

import com.uab.taller.store.domain.User;
import com.uab.taller.store.domain.dto.request.GetUserByEmailRequest;
import com.uab.taller.store.service.IUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@Log4j2
public class GetUserByEmailUseCase {

    @Autowired
    IUserService userService;

    public User execute(String email) {

        log.error(email);

        Optional<User> optionalUser =  userService.getByEmail(email);

        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }else {
            return null;
        }
    }
}
