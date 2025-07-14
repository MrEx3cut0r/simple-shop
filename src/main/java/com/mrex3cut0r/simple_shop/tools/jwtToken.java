package com.mrex3cut0r.simple_shop.tools;

import com.mrex3cut0r.simple_shop.Models.User;
import com.mrex3cut0r.simple_shop.Services.UserService;

import io.jsonwebtoken.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

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

    public static Map<String, Object> extract_cookie(Cookie[] cookie) {
        return jwtToken.getClaims(Arrays.stream(cookie).map(c -> c.getValue()).collect(Collectors.joining(", ")));
    }

    public static Object get_user(HttpServletRequest request, UserService service) throws IOException {
        try {
            Cookie[] cookie = request.getCookies();
            Map<String, Object> clean_data = extract_cookie(cookie);
            return service.findByUsername((String)clean_data.get("sub"));
        } catch (io.jsonwebtoken.ExpiredJwtException e) {
            return null;
        }
    }

    public static Object get_username(HttpServletRequest request) {
        try {
            Cookie[] cookie = request.getCookies();
            Map<String, Object> clean_data = extract_cookie(cookie);
            return (String) clean_data.get("sub");
        } catch (io.jsonwebtoken.ExpiredJwtException e) { return null; }
    }



}
