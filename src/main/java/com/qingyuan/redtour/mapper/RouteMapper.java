package com.qingyuan.redtour.mapper;

import com.qingyuan.redtour.pojo.Route;

import java.util.List;

/**
 * @Author lmx
 * @Date 2021/5/15 22:32
 * @Version 1.0
 */
public interface RouteMapper {
    List<Route> getRouteByCategory(Integer category);
}
