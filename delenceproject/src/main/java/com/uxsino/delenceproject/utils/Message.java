package com.uxsino.delenceproject.utils;

import lombok.Data;

import java.util.List;

/**
 * @author Yinpengfei
 * @Description 消息实体类
 * @Date 2020/8/9 0009
 **/
@Data
public class Message {
    private String msg;
    private int code;
    private List<Object> data;
    public static Message OK=new Message("OK",200);
    public static Message ServerException=new Message("Server Exception",500);

    public Message(String msg, int code, List<Object> data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }
    public Message(String msg, int code) {
        this(msg,code,null);
    }

}
