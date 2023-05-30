package com.wallace.dto.controller;

import com.wallace.dto.models.User;
import com.wallace.dto.models.UserDTO;
import com.wallace.dto.repository.UserRepository;
import com.wallace.dto.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<UserDTO> getAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable int id){
        return service.findById(id);
    }

    @PostMapping
    public User insertUser(@RequestBody User user){
        return repository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User newUser){
        return repository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setPassword(newUser.getPassword());
                    user.setEmail(newUser.getEmail());
                    return insertUser(user);
                })
                .orElseGet(() -> insertUser(newUser));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        repository.deleteById(id);
    }

}
