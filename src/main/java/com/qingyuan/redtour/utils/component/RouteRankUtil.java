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
 * @Description: 路线热度工具类
 * @create 2021-05-25 16:15
 */
@Component
public class RouteRankUtil {

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 增加热门路线热度，15 日后过期
     * @param routeId
     * @param category
     */
    public void addHeatRoute(Integer routeId, Integer category) {
        // route:rank:${category} 不同分类的路线存入不同的 key 中
        String key = RedisKey.HEAT_KEY_PREFIX + category;
        String value = String.valueOf(routeId);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 15);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        // 15日后十二点与当前的毫秒差
        long timeOut = (calendar.getTimeInMillis() - System.currentTimeMillis()) / 1000;

        // 如果已经存在热门路线，则将 score + 1.0
        if (Objects.requireNonNull(redisTemplate.opsForZSet().range(key, 0, -1)).contains(value)) {
            double score = redisTemplate.opsForZSet().score(key, value);
            redisTemplate.opsForZSet().add(key, value, score + 1.0);
        } else {
            // 设置 TTL
            redisTemplate.opsForZSet().add(key, value, 1.0);
            redisTemplate.expire(key, timeOut, TimeUnit.MILLISECONDS);
        }
    }

    /**
     * 处理路线热度
     * @param category
     * @param routeList
     * @return
     */
    public List<RouteRankBO> getHeatRoute(Integer category, List<Route> routeList) {
        int routeSize = routeList.size();

        // 使用 LinkedList 数据结构使得添加操作更高效
        List<RouteRankBO> heatRouteList = new LinkedList<>();
        // 用于标记路线是否被加入到热门路线
        // 0 未加入，1 已加入
        BitSet bitSet = new BitSet(routeSize);

        String key = RedisKey.HEAT_KEY_PREFIX + category;
        Set<ZSetOperations.TypedTuple<String>> typedTupleSet = redisTemplate.opsForZSet().reverseRangeWithScores(key, 0, -1);
        if (typedTupleSet != null) {
            for (ZSetOperations.TypedTuple<String> typedTuple : typedTupleSet) {
                String value = typedTuple.getValue();
                if (value != null) {
                    Integer routeId = Integer.valueOf(value);
                    int index = binarySearchRouteIndex(routeList, routeId);
                    RouteRankBO routeRankBO = wrapRouteRankBO(routeList.get(index));

                    Integer score = typedTuple.getScore() == null ? 1 : (int) Math.ceil(typedTuple.getScore());
                    routeRankBO.setScore(score);
                    heatRouteList.add(routeRankBO);
                    bitSet.set(index, true);
                }
            }
        }

        for (int i = 0; i < routeSize; i++) {
            if (!bitSet.get(i)) {
                heatRouteList.add(wrapRouteRankBO(routeList.get(i)));
            }
        }
        return heatRouteList;
    }

    private RouteRankBO wrapRouteRankBO(Route route) {
        RouteRankBO routeRankBO = new RouteRankBO();

        routeRankBO.setRouteId(route.getRouteId());
        routeRankBO.setCategory(route.getCategory());
        routeRankBO.setRouteName(route.getRouteName());
        routeRankBO.setLocation(route.getLocation());
        routeRankBO.setScenicPictureUrl(route.getScenicPictureUrl());
        routeRankBO.setIntro(route.getIntro());
        routeRankBO.setSuggestedDay(route.getSuggestedDay());
        routeRankBO.setTravelMode(route.getTravelMode());

        // default score
        routeRankBO.setScore(0);

        return routeRankBO;
    }

    /**
     * 通过二分查找路线 ID 得到在 routeList 中的 index
     */
    private int binarySearchRouteIndex(List<Route> routeList, Integer routeId) {
        int low = 0;
        int high = routeList.size();

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (routeId < routeList.get(mid).getRouteId()) {
                high = mid - 1;
            } else if (routeId > routeList.get(mid).getRouteId()) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }
}
