package com.qingyuan.redtour.mapper;

import com.qingyuan.redtour.pojo.Attraction;
import com.qingyuan.redtour.pojo.BO.RouteBO;
import com.qingyuan.redtour.pojo.Route;
import com.qingyuan.redtour.pojo.UserPlan;

import java.util.List;

/**
 * @Author lmx
 * @Date 2021/5/15 22:32
 * @Version 1.0
 */
public interface RouteMapper {
    /**
     * 根据路线类型查找
     * @param category
     * @return
     */
    List<Route> getRouteByCategory(Integer category);

    /**
     * 将对应routeId的旅游路线放进RouteBo里面
     * @param routeId
     * @return
     */
    RouteBO getRouteToRouteBo(Integer routeId);

    /**
     * 将对应routeId的景点信息放进getRouteToRouteBo所获得的RouteBo里面
     * @param routeId
     * @return
     */
    List<Attraction> getAttractionToRouteBo(Integer routeId);

    /**
     * 通过routeId判断路线是否存在
     * @param routeId
     * @return
     */
    int findRouteById(Integer routeId);

    /**
     * 判断用户是否存在
     * @param userId
     * @return
     */
    String findUserById(Integer userId);

    /**
     * 将路线加入用户计划
     * @param userId
     * @param routeId
     * @return
     */
    int addRouteToUserPlan(Integer userId,Integer routeId);

    /**
     * 将路线加入用户喜欢
     * @param userId
     * @param routeId
     * @return
     */
    int addRouteToUserStar(Integer userId,Integer routeId);

    /**
     * 判断用户计划是否存在
     * @param userId
     * @param routeId
     * @return
     */
    UserPlan judgeUserPlan(Integer userId, Integer routeId);

    /**
     * 判断用户收藏是否存在
     * @param userId
     * @param routeId
     * @return
     */
    UserPlan judgeUserStar(Integer userId, Integer routeId);

    /**
     * 将route信息存入数据库
     * @param route
     * @return
     */
    int addRouteToBo(Route route);

}
