package com.qingyuan.redtour.mapper;

import com.qingyuan.redtour.pojo.BO.ClockinBO;
import com.qingyuan.redtour.pojo.Clockin;
import com.qingyuan.redtour.pojo.ClockinPicture;

import java.util.List;

/**
 * @Author lmx
 * @Date 2021/5/18 0:06
 * @Version 1.0
 */
public interface ClockinMapper {

    /**
     * 根据 practiceId 查询打卡列表
     * @param practiceId
     * @return
     */
    List<Clockin> getClockinByPracticeId(Integer practiceId);

    /**
     * 根据 clockinId 查询每日打卡的 clockin 详细数据
     * @param clockinId
     * @return
     */
    Clockin getClockinByClockinId(Integer clockinId);

    /**
     * 根据 clockin 查询每日打卡的 picture list
     * @param clockinId
     * @return
     */
    List<String> getClockinPictureByClockinId(Integer clockinId);

    /**
     * 插入 clockin 信息
     * @param clockin
     * @return
     */
    int insertClockin(Clockin clockin);

    /**
     * 根据 clockinId 插入 picture url
     * @param clockinId
     * @param pictureUrl
     * @return
     */
    int insertClockinPicture(Integer clockinId,String pictureUrl);
}
