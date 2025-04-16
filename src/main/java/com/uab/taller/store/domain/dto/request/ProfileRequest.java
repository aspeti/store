package com.uab.taller.store.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProfileRequest {
    String name;
    String lastName;
    char gender;
    Date birthday;
}
