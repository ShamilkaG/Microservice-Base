package com.msconsult.user.controller;

import com.msconsult.user.entity.User;
import com.msconsult.user.service.UserService;
import com.msconsult.user.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside the saveUser method in UserController .");
        return userService.saveUser(user);
    }

//    @GetMapping("/{id}")
//    public User findUserById(@PathVariable ("id") Long userId){
//        log.info("Inside the findUserById method in UserController .");
//        return userService.findUserById(userId);
//    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("Inside the getUserWithDepartment method in UserController .");
        return userService.getUserWithDepartment(userId);
    }


}
