package com.ding.diary.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: JwtTokenUtils
 * @author: ding
 * @date: 2019/10/15 21:38
 * @version: 1.0
 */


public class JwtTokenUtils {
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", "ding");
        String s = generatorToken(map);
        phaseToken(s);
    }

    private static final String secret = "zheshimiyao";
    public static String generatorToken(Map<String, Object> payload) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JwtBuilder jwtBuilder = Jwts.builder().setPayload(objectMapper.writeValueAsString(payload));
            return jwtBuilder.signWith(SignatureAlgorithm.HS256, generatorSecret()).compact();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Key generatorSecret(){
        SignatureAlgorithm algorithm = SignatureAlgorithm.HS256;
        byte[] bytes = DatatypeConverter.parseBase64Binary(secret);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, algorithm.getJcaName());
        return secretKeySpec;
    }
    public static Claims phaseToken(String token) {
        return Jwts.parser().setSigningKey(generatorSecret()).parseClaimsJws(token).getBody();
//        return Jwts.parser().parseClaimsJws(token).getBody();

    }
}
