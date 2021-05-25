package com.qingyuan.redtour.utils;

import com.qingyuan.redtour.pojo.HotWord;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author hly
 * @Description: TODO
 * @create 2021-05-24 22:48
 */
@Component
public class RedisUtil {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 设置缓存失效时间，15日凌晨后过期
     * @param hotWord
     */
    public void addHotWord(String hotWord) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,15);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.MILLISECOND,0);
        //15日后十二点与当前的毫秒差
        Long timeOut = (calendar.getTimeInMillis() - System.currentTimeMillis()) / 1000;
        redisTemplate.expire("hotWord",timeOut, TimeUnit.MILLISECONDS);

        if(redisTemplate.opsForZSet().range("hotWord",0,-1).toString().contains(hotWord)){
            //缓存已存在，当前分数+1
            Double score = redisTemplate.opsForZSet().score("hotWord",hotWord);
            redisTemplate.opsForZSet().add("hotWord",hotWord,score + 1.0);
        }
        else{
            redisTemplate.opsForZSet().add("hotWord",hotWord,1);
        }
    }

    /**
     * 返回热搜前十位
     * @return
     */
    public List<HotWord> getHotWord(){
        // 使用 LinkedList 数据结构便于插入，效率更高
        List<HotWord> hotWordList = new LinkedList<>();
        Set<ZSetOperations.TypedTuple<Object>> typedTupleSet = redisTemplate.opsForZSet().reverseRangeByScoreWithScores("hotWord", 1, 100);
        Iterator<ZSetOperations.TypedTuple<Object>> iterator = typedTupleSet.iterator();
        int flag = 0;
        while (iterator.hasNext()){
            flag++;
            ZSetOperations.TypedTuple<Object> typedTuple = iterator.next();
            String value = (String) typedTuple.getValue();
            double score = Math.ceil(typedTuple.getScore());
            HotWord hotWord = new HotWord(score, value);
            hotWordList.add(hotWord);
            if(flag >= 10) break;
        }
        return hotWordList;
    }
}
