package com.ding.diary.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private static Logger log= LoggerFactory.getLogger(JwtTokenUtils.class);

    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", "ding");
        String s = generatorToken(map);
        phaseToken(s);
    }

    private static final String SECRET = "zheshimiyao";


    /**
     * 生成token
     * @param payload
     * @return
     */
    public static String generatorToken(Map<String, Object> payload) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JwtBuilder jwtBuilder = Jwts.builder().setPayload(objectMapper.writeValueAsString(payload));
            return jwtBuilder.signWith( generatorSecret(),SignatureAlgorithm.HS256).compact();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 生成密钥
     * @return
     */
    private static Key generatorSecret() {
        SignatureAlgorithm algorithm = SignatureAlgorithm.HS256;
        byte[] bytes = DatatypeConverter.parseBase64Binary(SECRET);
        return new SecretKeySpec(bytes, algorithm.getJcaName());
    }


    /**
     * 解析token
     * @param token
     * @return
     */
    public static Claims phaseToken(String token) {
        try {
            return Jwts.parser().setSigningKey(generatorSecret()).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
        } catch (UnsupportedJwtException | SignatureException | IllegalArgumentException | MalformedJwtException e) {
            log.warn(e.getMessage());
            e.printStackTrace();
        } catch (Exception e){
            log.warn(e.getMessage());
        }
        return null;
    }
}
