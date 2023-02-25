package com.example.springBoot;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;

public class TestJwt {
    private final String secret = "sjsjsj";


    @Test
    public void testJwt(){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 3600);
        System.out.println(instance.getTime());

        HashMap<String, Object> map = new HashMap<>();
        String token = JWT.create()
                .withHeader(map) // header 可以不写
                .withClaim("id", 21) // payload
                .withClaim("name", "zhansan")
                .withExpiresAt(instance.getTime()) // 指定过期时间
                .sign(Algorithm.HMAC256(secret));// 签名
        System.out.println(token);
    }

    @Test
    public void verifyJWT(){
        // 生成验证对象
        JWTVerifier build = JWT.require(Algorithm.HMAC256(secret)).build();
        DecodedJWT verify = build.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiemhhbnNhbiIsImlkIjoyMSwiZXhwIjoxNjY5NjE3Njc5fQ.tzfCUcz9Mwu68E6xSz6Ijo9ygbEigOHVVgBBpbQkbyI");
        System.out.println(verify.getClaims().get("name").asString());
        System.out.println(verify.getExpiresAt());
//        // 很迷
//        DecodedJWT decode = JWT.decode("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiemhhbnNhbiIsImlkIjoyMSwiZXhwIjoxNjY5NjEyNjYyfQ.4svaJ6VzCqLEhQXoysjujiB8B06AkR2fo_EDxvWbBDA");
//        System.out.println(decode.getClaims().get("id").asInt());
    }


    @Test
    public void testSign(){

    }
}
