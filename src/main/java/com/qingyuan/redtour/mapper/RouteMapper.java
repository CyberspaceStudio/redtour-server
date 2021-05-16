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
     * 将路线加入用户计划
     * @param userId
     * @param routeId
     * @return
     */
    int insertUserPlan(Integer userId, Integer routeId);

    /**
     * 将路线加入用户收藏
     * @param userId
     * @param routeId
     * @return
     */
    int insertUserStar(Integer userId, Integer routeId);

    /**
     * 根据 routeId 获取路线
     * @param routeId
     * @return
     */
    Route getRouteById(Integer routeId);

    /**
     * 根据 routeId 获取景点列表
     * @param routeId
     * @return
     */
    List<Attraction> getAttractionListByRouteId(Integer routeId);

    /**
     * 插入路线
     * @param route
     * @return
     */
    int insertRoute(Route route);

    /**
     * 插入景点
     * @param attraction
     * @return
     */
    int insertAttraction(Attraction attraction);

    /**
     * 根据 routeId 获取用户收藏的具体路线
     * @param userId
     * @param routeId
     * @return
     */
    Route getUserPlanByRouteId(Integer userId, Integer routeId);
}
