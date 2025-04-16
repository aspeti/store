package com.uab.taller.store.service;

import com.uab.taller.store.domain.Profile;
import com.uab.taller.store.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImp implements  IProfileService{

    ProfileRepository profileRepository;

    public ProfileServiceImp(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public List<Profile> getAll() {
        return profileRepository.findAll();
    }

    @Override
    public Profile getById(Long id) {
        return profileRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        profileRepository.deleteById(id);
    }

    @Override
    public Profile save(Profile profile) {
        return profileRepository.save(profile);
    }
}
