package com.qingyuan.redtour.utils.component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.util.Calendar;

/**
 * @author hly
 * @Description: 根据 userId 生成 token
 * @create 2021-05-08 21:08
 */
public class TokenUtil {

    private static final String signature = "Q!w2XS%^63p*";

    private static final String PAYLOAD_NAME = "user_id";

    /**
     * 通过用户 ID 生成 token
     * @param userId
     * @return
     */
    public static String TokenByUserId(Integer userId) {
        String token = "";

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 7);  // 默认7天过期

        // 生成 token
        try {
            token = JWT.create()
                    .withClaim(PAYLOAD_NAME, userId)
                    .withExpiresAt(instance.getTime())  // 指定 token 过期时间
                    .sign(Algorithm.HMAC256(signature));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    /**
     * 验证 token
     * 若验证出错将会抛出异常
     * @param token
     * @return 用户信息 (userId)
     */
    public static String verifyToken(String token) {
        return JWT.require(Algorithm.HMAC256(signature))
                .build()
                .verify(token)
                .getClaim(PAYLOAD_NAME)
                .asString();
    }
}
