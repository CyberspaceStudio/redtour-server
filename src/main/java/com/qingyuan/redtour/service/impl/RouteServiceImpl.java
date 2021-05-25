package com.qingyuan.redtour.service.impl;

import com.qingyuan.redtour.mapper.RouteMapper;
import com.qingyuan.redtour.pojo.Attraction;
import com.qingyuan.redtour.pojo.BO.RouteBO;
import com.qingyuan.redtour.pojo.BO.RouteRankBO;
import com.qingyuan.redtour.pojo.Route;
import com.qingyuan.redtour.service.RouteService;
import com.qingyuan.redtour.utils.ResponseEnum;
import com.qingyuan.redtour.utils.ResponseResult;
import com.qingyuan.redtour.utils.component.RedisRankUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author lmx
 * @Date 2021/5/15 22:33
 * @Version 1.0
 */
@Service
@Slf4j
public class RouteServiceImpl implements RouteService {

    @Resource
    private RouteMapper routeMapper;

    @Resource
    private RedisRankUtil redisRankUtil;

    @Override
    public ResponseResult<List<RouteRankBO>> getRouteByCategory(Integer category) {
        List<RouteRankBO> heatRouteList = redisRankUtil.getHeatRoute(category);
        return ResponseResult.ok(heatRouteList);
    }

    @Override
    public ResponseResult<RouteBO> getRouteById(Integer routeId) {
        Route route = routeMapper.getRouteById(routeId);
        List<Attraction> attractionList = routeMapper.getAttractionListByRouteId(routeId);
        // 点击一次，增加一次热度
        redisRankUtil.addHeatRoute(routeId,route.getCategory());

        // 封装 route 和 attraction
        RouteBO routeBO = wrapRouteBO(route);
        routeBO.setAttractionList(attractionList);
        return ResponseResult.ok(routeBO);
    }

    @Override
    public ResponseResult<Void> addToUserPlan(Integer userId, Integer routeId) {
        if (routeMapper.getUserPlanByRouteId(userId, routeId) != null) {
            return ResponseResult.fail(ResponseEnum.PLAN_HAS_EXIST.getCode(), ResponseEnum.PLAN_HAS_EXIST.getMsg());
        }
        int i = routeMapper.insertUserPlan(userId, routeId);
        if (i > 0) {
            return ResponseResult.ok();
        }
        return ResponseResult.fail();
    }

    @Override
    public ResponseResult<Void> addToUserStar(Integer userId, Integer routeId) {
        // 不需要判断用户是否收藏，因为新增了取消收藏 api
        int i = routeMapper.insertUserStar(userId, routeId);
        if (i > 0) {
            return ResponseResult.ok();
        }
        return ResponseResult.fail();
    }

    @Override
    public ResponseResult<Void> addRoute(RouteBO routeBO) {
        Route route = unwrapRoute(routeBO);
        routeMapper.insertRoute(route);

        List<Attraction> attractionList = routeBO.getAttractionList();
        for (Attraction attraction : attractionList) {
            routeMapper.insertAttraction(attraction);
        }
        return ResponseResult.ok();
    }

    /**
     * 将 route 包装为 routeBO
     */
    private RouteBO wrapRouteBO(Route route) {
        RouteBO routeBO = new RouteBO();

        routeBO.setRouteId(route.getRouteId());
        routeBO.setCategory(route.getCategory());
        routeBO.setRouteName(route.getRouteName());
        routeBO.setLocation(route.getLocation());
        routeBO.setScenicPictureUrl(route.getScenicPictureUrl());
        routeBO.setIntro(route.getIntro());
        routeBO.setSuggestedDay(route.getSuggestedDay());
        routeBO.setTravelMode(route.getTravelMode());

        return routeBO;
    }

    /**
     * 将 routeBO 分解为 route
     */
    private Route unwrapRoute(RouteBO routeBO) {
        Route route = new Route();

        route.setRouteId(routeBO.getRouteId());
        route.setCategory(routeBO.getCategory());
        route.setRouteName(routeBO.getRouteName());
        route.setLocation(routeBO.getLocation());
        route.setScenicPictureUrl(routeBO.getScenicPictureUrl());
        route.setIntro(routeBO.getIntro());
        route.setSuggestedDay(routeBO.getSuggestedDay());
        route.setTravelMode(routeBO.getTravelMode());

        return route;
    }
}
