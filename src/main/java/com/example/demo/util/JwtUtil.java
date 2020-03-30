package com.example.demo.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.pojo.User;

import java.util.Date;
import java.util.HashMap;

/**
 * @author: Milogenius
 * @create: 2019-07-08 10:24
 * @description:
 **/
public class JwtUtil {
    /**
     * 过期时间为一天
     * TODO 正式上线更换为15分钟
     */
    private static final long EXPIRE_TIME = 10 * 60 * 1000;

    /**
     * token私钥
     */
    private static final String TOKEN_SECRET = "joijsdfjlsjfljfljl5135313135";

/**
 * 生成签名,15分钟后过期
 * 用用户登陆信息经过加密的算法生成一个token、只有登陆时使用
 * @param user
 * @return
 */
public static String sign(User user) {
//过期时间
    Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
//私钥及加密算法
    Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
//设置头信息
    HashMap<String, Object> header = new HashMap<>(2);
    header.put("typ", "JWT");
    header.put("alg", "HS256");
//附带username和userID生成签名
    return JWT.create().withHeader(header).withClaim("loginName", user.getLoginName())
            .withClaim("userId",user.getId()).withExpiresAt(date).sign(algorithm);
}
    /**
     * 验证每一次的请求都要先验证身份，如果身份和服务器上保留的
     身份一致返回true
     *
     * @param token
     * @return
     */
    public static boolean verity(String token) {
        try {
            //解密
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        } catch (JWTVerificationException e) {
            return false;
        }
    }

}
