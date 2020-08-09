package com.uxsino.delenceproject.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Yinpengfei
 * @Description 加密工具类
 * @Date 2020/8/9 0009
 **/
public class PasswordEncoderUtil {
    public final static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    public static String encode(String password){
        return encoder.encode(password);
    }
    public static Boolean isTure(String newPassword, String encodePassword){
        return encoder.matches(newPassword,encodePassword);
    }

    public static void main(String[] args) {
        String encode = encoder.encode("123");
        System.out.println(encode);//$2a$10$fdPaBD2jMF/6PeNUX6HEDuutQLl3YrN69XYV6cHmf13kBoumZLVDa
        boolean b = encoder.matches("123", "$2a$10$fdPaBD2jMF/6PeNUX6HEDuutQLl3YrN69XYV6cHmf13kBoumZLVDa");
        System.out.println(b);
    }
}
