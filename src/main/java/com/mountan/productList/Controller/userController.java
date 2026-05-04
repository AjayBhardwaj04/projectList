package com.mountan.productList.Controller;

import com.mountan.productList.Entity.User;
import com.mountan.productList.Service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    private MyUserDetailsService service;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
       return service.createUser(user);
    }
}
