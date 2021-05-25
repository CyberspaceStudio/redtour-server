package com.qingyuan.redtour.service;

import com.qingyuan.redtour.pojo.BO.RouteBO;
import com.qingyuan.redtour.pojo.BO.RouteRankBO;
import com.qingyuan.redtour.pojo.Route;
import com.qingyuan.redtour.utils.ResponseResult;

import java.util.List;

/**
 * @Author lmx
 * @Date 2021/5/15 22:34
 * @Version 1.0
 */
public interface RouteService {
    /**
     * 根据分类查询路线
     * @param category  1 代表红色中国；2 代表小康中国；3 代表复兴中国；4 代表游览本地
     * @return
     */
    ResponseResult<List<RouteRankBO>> getRouteByCategory(Integer category);

    /**
     * 根据 routeId 获得分类中的路线详情
     * @param routeId
     * @return
     */
    ResponseResult<RouteBO> getRouteById(Integer routeId);

    /**
     * 将旅游路线加入用户计划
     * @param userId
     * @param routeId
     * @return
     */
    ResponseResult<Void> addToUserPlan(Integer userId, Integer routeId);

    /**
     * 将路线加入用户喜欢
     * @param userId
     * @param routeId
     * @return
     */
    ResponseResult<Void> addToUserStar(Integer userId, Integer routeId);

    /**
     * 添加路线
     * @param routeBO
     * @return
     */
    ResponseResult<Void> addRoute(RouteBO routeBO);
}
