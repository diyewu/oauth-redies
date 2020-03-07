package com.aicc.bpf;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MainTest {
    public static void main(String[] args) {
        test1();
    }

    public static void test1(){
        System.out.println(System.currentTimeMillis());
    }
    public static void test(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("123456"));
    }
}
