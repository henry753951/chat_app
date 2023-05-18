package com.chatapp.backend.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) // 若參數是 null 則不顯示
public class Msg {
    public String roomId;
    public String message;
    public String sender;
    public long time;
}
