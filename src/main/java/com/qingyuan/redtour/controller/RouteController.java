package com.qingyuan.redtour.controller;

import com.qingyuan.redtour.pojo.BO.RouteBO;
import com.qingyuan.redtour.pojo.Route;
import com.qingyuan.redtour.service.RouteService;
import com.qingyuan.redtour.utils.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 路线（攻略）相关接口
 * @Author: qyl
 * @Date: 2021/5/11 15:26
 */
@RestController
@RequestMapping("/route")
public class RouteController {

    @Resource
    private RouteService routeService;

    /**
     * 根据分类查询路线
     * 结果按热度降序排序
     * @param category 1 代表红色中国；2 代表小康中国；3 代表复兴中国；4 代表游览本地
     * @return
     */
    @GetMapping("/category")
    public ResponseResult<List<Route>> getRouteByCategory(Integer category) {
        return routeService.getRouteByCategory(category);
    }

    /**
     * 获取路线详情
     * @param routeId
     * @return
     */
    @GetMapping("/id")
    public ResponseResult<RouteBO> getRouteById(Integer routeId) {
        return null;
    }

    /**
     * 将该路线加入到用户计划
     * @param userId
     * @param routeId
     * @return
     */
    @PostMapping("/plan/add")
    public ResponseResult<Void> addToUserPlan(Integer userId, Integer routeId) {
        return null;
    }

    /**
     * 将该路线加入到用户收藏
     * @param userId
     * @param routeId
     * @return
     */
    @PostMapping("/star/add")
    public ResponseResult<Void> addToUserStar(Integer userId, Integer routeId) {
        return null;
    }

    /**
     * 添加路线
     * 仅供内部人员使用
     * @param routeBO
     * @return
     */
    @PostMapping("/add")
    public ResponseResult<Void> addRoute(RouteBO routeBO) {
        return null;
    }
}
