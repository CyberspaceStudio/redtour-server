package com.qingyuan.redtour.pojo.BO;

import com.qingyuan.redtour.pojo.Attraction;
import com.qingyuan.redtour.pojo.Route;

import java.util.List;

/**
 * 封装 Route 与 Attraction 业务包装类
 * @Author: qyl
 * @Date: 2021/5/12 20:22
 */
public class RouteBO extends Route {
    /**
     * 景区列表
     */
    private List<Attraction> attractionList;

    public List<Attraction> getAttractionList() {
        return attractionList;
    }

    public void setAttractionList(List<Attraction> attractionList) {
        this.attractionList = attractionList;
    }
}
