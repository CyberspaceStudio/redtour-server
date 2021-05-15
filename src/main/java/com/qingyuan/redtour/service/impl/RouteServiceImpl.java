package com.qingyuan.redtour.service.impl;

import com.qingyuan.redtour.mapper.RouteMapper;
import com.qingyuan.redtour.pojo.Route;
import com.qingyuan.redtour.service.RouteService;
import com.qingyuan.redtour.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lmx
 * @Date 2021/5/15 22:33
 * @Version 1.0
 */
@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteMapper routeMapper;

    @Override
    public ResponseResult<List<Route>> getRouteByCategory(Integer category) {
        List<Route> routeByCategory = routeMapper.getRouteByCategory(category);
        return ResponseResult.ok(routeByCategory);
    }
}