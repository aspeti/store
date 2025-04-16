package com.uab.taller.store.usecase;

import com.uab.taller.store.domain.Profile;
import com.uab.taller.store.domain.User;
import com.uab.taller.store.service.IProfileService;
import com.uab.taller.store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllProfileUseCase {
    @Autowired
    IProfileService profileService;

    public List<Profile> execute() {
        return profileService.getAll();
    }

}
