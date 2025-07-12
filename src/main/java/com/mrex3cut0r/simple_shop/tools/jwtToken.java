package com.mrex3cut0r.simple_shop.tools;


import io.jsonwebtoken.*;
import io.jsonwebtoken.Claims.*;
import org.springframework.lang.NonNull;

import java.util.Date;

public class jwtToken {

    protected static String SecretKey = "secretkey12341243123example";
    protected static JwtBuilder builder;
    protected static JwtParser parser;
    public static String generate(String username) {
        Date expires = new Date(new Date().getTime() + 3600000);
        return Jwts.builder().setSubject(username).setExpiration(expires).compact();
    }
    public static Claims getClaims(@NonNull String token) {
        return Jwts.parserBuilder().setSigningKey(SecretKey).build().parseClaimsJwt(token).getBody();
    }
    /*
    boolean validate(String jwt) {
        Claims claims = Jwts.parser().setSigningKey(SecretKey).getBody();
        return true;
    }
    */





}
