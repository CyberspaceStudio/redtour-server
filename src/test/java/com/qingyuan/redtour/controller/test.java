package com.qingyuan.redtour.controller;

import com.qingyuan.redtour.pojo.HotWord;
import com.qingyuan.redtour.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hly
 * @Description: 测试代码
 * @create 2021-05-24 23:17
 */
@RestController
public class test {

    @Autowired
    RedisUtil redisUtil;

    @PostMapping ("/add")
    public void addHotWord(String hotWord){
        redisUtil.addHotWord(hotWord);
    }

    @GetMapping("/get")
    public List<HotWord> getHotWord(){
        return redisUtil.getHotWord();
    }
}
