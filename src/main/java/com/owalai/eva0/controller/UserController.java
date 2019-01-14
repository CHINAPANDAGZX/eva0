package com.owalai.eva0.controller;

import com.owalai.eva0.jpa.User;
import com.owalai.eva0.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/add")
    public Object add(@RequestParam(name = "name", required = true) String name) {
        User user = new User();
        user.setName(name);
        userRepository.save(user);
        return user;
    }

    @RequestMapping("/list")
    public Object list() {
        Iterable<User> users = userRepository.findAll();
        return users;
    }

    @RequestMapping("/search")
    public Object search(@RequestParam(name = "name", required = true) String name) {
        List<User> users = userRepository.queryUserByName(name);
        return users;
    }
}
