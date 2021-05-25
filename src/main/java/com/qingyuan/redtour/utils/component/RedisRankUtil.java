package com.qingyuan.redtour.utils.component;

import com.qingyuan.redtour.mapper.RouteMapper;
import com.qingyuan.redtour.pojo.BO.RouteRankBO;
import com.qingyuan.redtour.pojo.Route;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author hly
 * @Description: redis 热度工具类
 * @create 2021-05-25 16:15
 */
@Component
public class RedisRankUtil {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Resource
    private RouteMapper routeMapper;

    private static final String HEAT_KEY_PREFIX = "route:";

    private static final String HEAT_KEY_SUFFIX = ":rank";

    /**
     * 增加热门路线热度，redis 15日后过期
     * @param routeId
     * @param category
     */
    public void addHeatRoute(Integer routeId,Integer category){
        // route:x:rank 不同分类的路线存入不同的 key 中
        String key = HEAT_KEY_PREFIX + category.toString() + HEAT_KEY_SUFFIX;
        String value =routeId.toString();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,15);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.MILLISECOND,0);
        // 15日后十二点与当前的毫秒差
        Long timeOut = (calendar.getTimeInMillis() - System.currentTimeMillis()) / 1000;
        redisTemplate.expire(key,timeOut,TimeUnit.MILLISECONDS);
        // 如果已经存在热门路线，则将 score + 1.0
        if(Objects.requireNonNull(redisTemplate.opsForZSet().range(key, 0, -1)).contains(value)){
            double score = redisTemplate.opsForZSet().score(key,value);
            redisTemplate.opsForZSet().add(key,value,score + 1.0);
        }
        else {
            redisTemplate.opsForZSet().add(key,value,1.0);
        }
    }

    /**
     * 返回热度前十的热门路线
     * @param category
     * @return
     */
    public List<RouteRankBO> getHeatRoute(Integer category){
        // 使用 LinkedList 数据结构使得添加操作更高效
        String key = HEAT_KEY_PREFIX + category.toString() + HEAT_KEY_SUFFIX;
        LinkedList<RouteRankBO> hotRouteList = new LinkedList<>();
        Set<ZSetOperations.TypedTuple<String>> typedTupleSet = redisTemplate.opsForZSet().reverseRangeByScoreWithScores(key, 1, 100);
        Iterator<ZSetOperations.TypedTuple<String>> iterator = typedTupleSet.iterator();
        int flag = 0;
        while (iterator.hasNext()){
            flag++;
            ZSetOperations.TypedTuple<String> typedTuple = iterator.next();
            String value = typedTuple.getValue();
            Integer score = typedTuple.getScore () == null ? null : (int) Math.ceil(typedTuple.getScore());
            if( value != null){
                Integer routeId = Integer.valueOf(value);
                Route routeById = routeMapper.getRouteById(routeId);
                RouteRankBO routeRankBO = wrapRouteRankBO(routeById);
                routeRankBO.setScore(score);
                hotRouteList.add(routeRankBO);
            }
            if( flag >= 10 ) {
                break;
            }
        }
        return hotRouteList;
    }

    public RouteRankBO wrapRouteRankBO(Route route){
        RouteRankBO routeRankBO = new RouteRankBO();

        routeRankBO.setRouteId(route.getRouteId());
        routeRankBO.setCategory(route.getCategory());
        routeRankBO.setRouteName(route.getRouteName());
        routeRankBO.setLocation(route.getLocation());
        routeRankBO.setScenicPictureUrl(route.getScenicPictureUrl());
        routeRankBO.setIntro(route.getIntro());
        routeRankBO.setSuggestedDay(route.getSuggestedDay());
        routeRankBO.setTravelMode(route.getTravelMode());

        return routeRankBO;
    }

}
