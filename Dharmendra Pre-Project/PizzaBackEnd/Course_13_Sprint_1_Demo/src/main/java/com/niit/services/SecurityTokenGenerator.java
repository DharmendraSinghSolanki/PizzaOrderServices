package com.niit.services;

import com.niit.domain.User;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenGenerator implements ISecurityTokenGenerator {
    @Override
    public Map<String, String> tokenGenerator(User user) {
        String jswToken=null;
        jswToken=Jwts.builder().setSubject(user.getFirstName())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"securityKey").compact();
        Map<String,String> map=new HashMap<>();
        map.put("token",jswToken);
        map.put("message","user logged in successfully");
        return  map;
    }
}
