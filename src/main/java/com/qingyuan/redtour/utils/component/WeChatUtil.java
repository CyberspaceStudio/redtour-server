package com.qingyuan.redtour.utils.component;

import com.alibaba.fastjson.JSON;
import com.qingyuan.redtour.pojo.BO.WxResponseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: qyl
 * @Date: 2021/4/30 10:38
 */
@Component
@Slf4j
public class WeChatUtil {

    @Value("${wx.url}")
    private String WECHAT_OPENID_URL;

    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * 获取微信响应
     * @param code
     * @return
     */
    public WxResponseInfo getWeChatResponseBody(String code) {
        String url = WECHAT_OPENID_URL + code;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        if (responseEntity.getStatusCodeValue() != 200) {
            log.error("Connect wechat failed");
        }
        WxResponseInfo wxResponseInfo = JSON.parseObject(responseEntity.getBody(), WxResponseInfo.class);
        return wxResponseInfo;
    }
}
