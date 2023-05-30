package com.wallace.dto.services;

import com.wallace.dto.models.User;
import com.wallace.dto.models.UserDTO;
import com.wallace.dto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserDTO findById(int id){
        User entity = repository.findById(id).get();
        return new UserDTO(entity);
    }

    public List<UserDTO> findAll(){
        List<User> entities = repository.findAll();
        List<UserDTO> entitiesDTO = new ArrayList<>();
        for (User u: entities){
            entitiesDTO.add(new UserDTO(u));
        }
        return entitiesDTO;
    }

}
