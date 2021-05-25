package com.qingyuan.redtour.pojo.BO;

import com.qingyuan.redtour.pojo.Route;

import java.io.Serializable;

/**
 * @author hly
 * @Description: Route 与 score 包装类，存入 redis
 * @create 2021-05-25 22:01
 */
public class RouteRankBO extends Route implements Serializable {

    /**
     * 热度
     */
    private Integer score;

    public void setScore(Integer score){
        this.score = score;
    }

    public Integer getScore(){
        return score;
    }
}
