package com.qingyuan.redtour.service.impl;

import com.qingyuan.redtour.mapper.RouteMapper;
import com.qingyuan.redtour.pojo.BO.RouteBO;
import com.qingyuan.redtour.pojo.Route;
import com.qingyuan.redtour.pojo.UserPlan;
import com.qingyuan.redtour.service.RouteService;
import com.qingyuan.redtour.utils.ResponseEnum;
import com.qingyuan.redtour.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author lmx
 * @Date 2021/5/15 22:33
 * @Version 1.0
 */
@Service
public class RouteServiceImpl implements RouteService {

    @Resource
    private RouteMapper routeMapper;

    @Override
    public ResponseResult<List<Route>> getRouteByCategory(Integer category) {
        // 判断category，防止系统错误传至莫名页面
        if (category <= 4) {
            List<Route> routeByCategory = routeMapper.getRouteByCategory(category);
            return ResponseResult.ok(routeByCategory);
        }else {
            return ResponseResult.fail(ResponseEnum.CATEGORY_NO_EXIST.getCode(),ResponseEnum.CATEGORY_NO_EXIST.getMsg());
        }
    }

    @Override
    public ResponseResult<RouteBO> getRouteBoByRouteId(Integer routeId) {
        // 判断路线是否存在，防止页面卡顿无刷新这种情况发生
        int routeExist = routeMapper.findRouteById(routeId);
        if (routeExist > 0) {
            RouteBO routeBO = routeMapper.getRouteToRouteBo(routeId);
            routeBO.setAttractionList(routeMapper.getAttractionToRouteBo(routeId));
            return ResponseResult.ok(routeBO);
        } else {
            return ResponseResult.fail(ResponseEnum.ROUTE_NO_EXIST.getCode(), ResponseEnum.ROUTE_NO_EXIST.getMsg());
        }
    }

    @Override
    public ResponseResult<Void> addRouteToUserPlan(Integer userId, Integer routeId) {
        // 用户可能因为各种原因而掉线，从而导致Id不存在
        String userExist = routeMapper.findUserById(userId);
        UserPlan userPlan = routeMapper.judgeUserPlan(userId, routeId);
        if (userExist != null){
            if (userPlan == null){
                int success = routeMapper.addRouteToUserPlan(userId, routeId);
                if (success > 0) {
                    return ResponseResult.ok();
                } else {
                    return ResponseResult.fail();
                }
            }else {
                if (userPlan.getRouteId() == routeId && userPlan.getUserId() == userId) {
                    return ResponseResult.fail(ResponseEnum.PLAN_HAS_EXIT.getCode(), ResponseEnum.PLAN_HAS_EXIT.getMsg());
                } else {
                    int success = routeMapper.addRouteToUserPlan(userId, routeId);
                    if (success > 0) {
                        return ResponseResult.ok();
                    } else {
                        return ResponseResult.fail();
                    }
                }
            }
        } else{
            return ResponseResult.fail(ResponseEnum.USER_NO_EXIST.getCode(), ResponseEnum.USER_NO_EXIST.getMsg());
        }
    }
}