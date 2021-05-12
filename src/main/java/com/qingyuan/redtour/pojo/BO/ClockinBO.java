package com.qingyuan.redtour.pojo.BO;

import com.qingyuan.redtour.pojo.Clockin;
import java.util.List;

/**
 * 封装 Clockin 与 ClockinPicture 业务对象类（BO）
 * @Author: qyl
 * @Date: 2021/5/12 20:05
 */
public class ClockinBO extends Clockin {

    /**
     * 每日打卡图片列表
     */
    private List<String> clockinPictureUrlList;

    public void setClockinPictureUrlList(List<String> clockinPictureUrlList) {
        this.clockinPictureUrlList = clockinPictureUrlList;
    }

    public List<String> getClockinPictureUrlList() {
        return clockinPictureUrlList;
    }
}
