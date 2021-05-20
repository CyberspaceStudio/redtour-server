package com.qingyuan.redtour.service.impl;

import com.qingyuan.redtour.mapper.ClockinMapper;
import com.qingyuan.redtour.pojo.BO.ClockinBO;
import com.qingyuan.redtour.pojo.Clockin;
import com.qingyuan.redtour.pojo.ClockinPicture;
import com.qingyuan.redtour.service.ClockinService;
import com.qingyuan.redtour.utils.ResponseEnum;
import com.qingyuan.redtour.utils.ResponseResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author lmx
 * @Date 2021/5/17 23:56
 * @Version 1.0
 */
@Service
public class ClockinServiceImpl implements ClockinService {

    @Resource
    private ClockinMapper clockinMapper;

    @Override
    public ResponseResult<List<Clockin>> getDailyClockinList(Integer practiceId) {
        List<Clockin> clockin = clockinMapper.getClockinByPracticeId(practiceId);
        return ResponseResult.ok(clockin);
    }

    @Override
    public ResponseResult<ClockinBO> getClockinById(Integer clockinId) {
        // 将 Clockin 包装成 ClockinBo
        Clockin clockin = clockinMapper.getClockinByClockinId(clockinId);
        ClockinBO clockinBO = wrapClockin(clockin);

        // 获取 picture list
        List<String> clockinPicture = clockinMapper.getClockinPictureByClockinId(clockinId);
        clockinBO.setClockinPictureUrlList(clockinPicture);

        return ResponseResult.ok(clockinBO);
    }

    @Override
    public ResponseResult<Void> addClockin(ClockinBO clockinBO) {
        clockinBO.setDate(new Date());
        Clockin clockin = unwrapClockinBo(clockinBO);
        int i = clockinMapper.insertClockin(clockin);
        if (i > 0) {
            List<String> clockinPictureUrlList = clockinBO.getClockinPictureUrlList();
            for (String pictureUrl : clockinPictureUrlList) {
                int j = clockinMapper.insertClockinPicture(clockin.getClockinId(), pictureUrl);
                if (j <= 0) {
                    return ResponseResult.fail(ResponseEnum.PICTURE_INSERT_ERROR.getCode(), ResponseEnum.PICTURE_INSERT_ERROR.getMsg());
                }
            }
            return ResponseResult.ok();
        } else {
            return ResponseResult.fail(ResponseEnum.CLOCKIN_ADD_ERROR.getCode(), ResponseEnum.CLOCKIN_ADD_ERROR.getMsg());
        }
    }

    private ClockinBO wrapClockin(Clockin clockin) {
        ClockinBO clockinBO = new ClockinBO();
        clockinBO.setClockinId(clockin.getClockinId());
        clockinBO.setPracticeId(clockin.getPracticeId());
        clockinBO.setDate(clockin.getDate());
        clockinBO.setPracticeName(clockin.getPracticeName());
        clockinBO.setLocation(clockin.getLocation());
        clockinBO.setTeammate(clockin.getTeammate());
        clockinBO.setPracticeIntro(clockin.getPracticeIntro());
        return clockinBO;
    }

    private Clockin unwrapClockinBo(ClockinBO clockinBO) {
        Clockin clockin = new Clockin();
        clockin.setClockinId(clockinBO.getClockinId());
        clockin.setLocation(clockinBO.getLocation());
        clockin.setPracticeId(clockinBO.getPracticeId());
        clockin.setDate(clockinBO.getDate());
        clockin.setTeammate(clockinBO.getTeammate());
        clockin.setPracticeName(clockinBO.getPracticeName());
        clockin.setPracticeIntro(clockinBO.getPracticeIntro());
        return clockin;
    }
}
