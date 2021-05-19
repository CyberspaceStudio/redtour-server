package com.qingyuan.redtour.service.impl;

import com.qingyuan.redtour.mapper.UserMapper;
import com.qingyuan.redtour.pojo.BO.TokenBO;
import com.qingyuan.redtour.pojo.BO.WxResponseInfo;
import com.qingyuan.redtour.pojo.Route;
import com.qingyuan.redtour.pojo.User;
import com.qingyuan.redtour.service.UserService;
import com.qingyuan.redtour.utils.ResponseEnum;
import com.qingyuan.redtour.utils.ResponseResult;
import com.qingyuan.redtour.utils.component.TokenUtil;
import com.qingyuan.redtour.utils.component.WeChatUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: qyl
 * @Date: 2021/4/29 22:03
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private WeChatUtil weChatUtil;
    @Resource
    private UserMapper userMapper;

    @Override
    public ResponseResult<TokenBO<User>> userWxLogin(String code) {
        WxResponseInfo wxResponseInfo = weChatUtil.getWeChatResponseBody(code);
        // code 无效
        if (wxResponseInfo.getErrcode() != null) {
            log.error("微信登录出错" + code + wxResponseInfo.getErrcode() + "\t" + wxResponseInfo.getErrmsg());
            return ResponseResult.fail(ResponseEnum.CODE_IS_INVALID.getCode(), ResponseEnum.CODE_IS_INVALID.getMsg());
        }

        User user = userMapper.getUserByOpenid(wxResponseInfo.getOpenid());
        String token;
        TokenBO<User> tokenBO;
        // user 如果已经存在
        if (user != null) {
            token = TokenUtil.TokenByUserId(user.getUserId());
            tokenBO = new TokenBO<>(user, token);
            // 返回用户不是首次登录
            return ResponseResult.ok(tokenBO);
        } else {
            user = new User(wxResponseInfo.getOpenid());
            int i = userMapper.insertUser(user);
            if (i > 0) {
                token = TokenUtil.TokenByUserId(user.getUserId());
                tokenBO = new TokenBO<>(user, token);
                return ResponseResult.ok(tokenBO);
            } else {
                return ResponseResult.fail();
            }
        }
    }

    @Override
    public ResponseResult<List<Route>> getUserPlan(Integer userId) {
        List<Route> planList = userMapper.getUserPlanList(userId);
        if(null != planList){
            return ResponseResult.ok(planList);
        }
        return null;
    }

    @Override
    public ResponseResult<List<Route>> getUserStar(Integer userId) {
        List<Route> userStar = userMapper.getUserStar(userId);
        if(null != userStar){
            return ResponseResult.ok(userStar);
        }
        return null;
    }
}
