package com.example.springBoot.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

import java.util.Calendar;
import java.util.Collections;
import java.util.Map;

public class JwtUtil {

    private static final String sign = "!@#$ASDsx";

    /**
     * 生成token
     * header.payload.signature
     */
    public static String getToken(Map<String, Object> map){
        Calendar calendar = Calendar.getInstance();
        //  7天过期
        calendar.add(Calendar.DATE, 7);

        JWTCreator.Builder builder = JWT.create();
        map.forEach((k, v)->{
            builder.withClaim(k, Collections.singletonList(v));
        });

        return builder.withExpiresAt(calendar.toInstant())
                .sign(Algorithm.HMAC256(sign));
    }

    /**
     * 验证token合法性
     */

    public static Boolean verifyToken(String token){
        try{
            JWT.require(Algorithm.HMAC256(sign)).build().verify(token);
        }
        catch (JWTVerificationException e){
            return false;
        }
        return true;
    }
}
