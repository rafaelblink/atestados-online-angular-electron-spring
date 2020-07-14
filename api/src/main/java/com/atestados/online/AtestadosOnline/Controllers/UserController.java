package com.atestados.online.AtestadosOnline.Controllers;


import java.net.URI;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.atestados.online.AtestadosOnline.Models.User;
import com.atestados.online.AtestadosOnline.Service.UserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/admin/users")
@Api(tags = {"Usuários"})
public class UserController {

    private UserService userService;

    public UserController(UserService us) {
        this.userService = us;
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody User user) {
        User u = userService.create(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}").buildAndExpand(u.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    
    @GetMapping("")
    public ArrayList<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    public User findById(@PathVariable long userId) {
        return userService.findById(userId);
    }

    @PutMapping("/{userId}")
    public User update(@PathVariable long userId, @Valid @RequestBody User user) {
        return userService.update(userId, user);
    }

    @DeleteMapping("/{userId}")
    public void deleteById(@PathVariable long userId) {
        userService.deleteById(userId);
    }

}
