package com.qingyuan.redtour.service;

import com.qingyuan.redtour.pojo.Route;
import com.qingyuan.redtour.utils.ResponseResult;

import java.util.List;

/**
 * @Author lmx
 * @Date 2021/5/15 22:34
 * @Version 1.0
 */
public interface RouteService {
    ResponseResult<List<Route>> getRouteByCategory(Integer category);
}
