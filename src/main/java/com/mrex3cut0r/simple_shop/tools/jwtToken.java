package com.mrex3cut0r.simple_shop.tools;


import io.jsonwebtoken.*;
import io.jsonwebtoken.Claims.*;
import java.util.Date;

public class jwtToken {

    protected String SecretKey = "secret_key12341243123example";
    protected JwtBuilder builder;
    protected JwtParser parser;
    public static String generate(Long id) {
        Date expires = new Date(new Date().getTime() + 3600000);
        return Jwts.builder().setSubject(String.valueOf(id)).setExpiration(expires).compact();
    }
    /*
    boolean validate(String jwt) {
        Claims claims = Jwts.parser().setSigningKey(SecretKey).getBody();
        return true;
    }
    */
}
