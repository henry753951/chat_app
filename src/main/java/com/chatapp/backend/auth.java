package com.chatapp.backend;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.chatapp.backend.entity.BaseResponse;
import com.chatapp.backend.entity.User;
import com.chatapp.backend.model.UserRepository;
import com.chatapp.backend.model.user;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import com.chatapp.backend.utils;


@RestController
@RequestMapping("/auth")
public class auth {
    @RequestMapping(value= "/register",method = RequestMethod.PUT)
    public BaseResponse<User> register(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password) {
        BaseResponse<User> response = new BaseResponse<User>("成功!");
        // ...
        
        User user = new User();
        user.username = username;
        user.Name = "test";
        user.email = username+"@mail.nuk.edu.tw";
        user.department = "test department";
        user.token = utils.sha256(username);
        
        

        response.data = user;
        return response;
    }
}