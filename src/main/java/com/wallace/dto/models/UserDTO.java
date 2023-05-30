package com.wallace.dto.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private int id;
    private String name;
    private String email;

    public UserDTO(){}
    public UserDTO(User user){
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
    }
}
