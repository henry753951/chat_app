package com.chatapp.backend.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chatapp.backend.entity.BaseResponse;
import com.chatapp.backend.entity.Msg;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/msg")
@SecurityRequirement(name = "Bearer Authentication")
public class msg {
    @RequestMapping(value= "/{id}",method = RequestMethod.POST)
    public BaseResponse<Msg> msg(
            @PathVariable(value = "id") Integer id,
            @RequestParam(value = "roomId", required = false) String roomId,
            @RequestParam(value = "message", required = false) String message,
            @RequestParam(value = "sender", required = false) String sender
            ) {
        BaseResponse<Msg> response = new BaseResponse<Msg>("成功!");
        Msg msg = new Msg();
        msg.roomId = roomId;
        msg.message = message;
        msg.sender = sender;
        msg.time = System.currentTimeMillis()/ 1000L;
        response.data = msg;
        return response;
    }
}
