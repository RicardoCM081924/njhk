package com.hhu.service;

import com.hhu.dao.HomePageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：jin
 * @description:
 * @date ：Created in 2021/2/16 19:48
 */
@Service
public class HomePageServiceImpl implements HomePageService {

    @Autowired
    private HomePageDao homePageDao;

    @Override
    public int getTotalNum(int layNum) {
        return homePageDao.getTotalNum(layNum);
    }

    @Override
    public String getLatestDate(String stm, String etm) {
        return homePageDao.getLatestDate(stm, etm);
    }

    @Override
    public int getMaxGrading(String stm, String etm) {
        return homePageDao.getMaxGrading(stm, etm);
    }

    @Override
    public int getMaxDensity(String stm, String etm) {
        return homePageDao.getMaxDensity(stm, etm);
    }

    @Override
    public int getGradingProcessNum(String stm, String etm) {
        return homePageDao.getGradingProcessNum(stm,etm);
    }

    @Override
    public int getLithologyProcessNum(String stm, String etm) {
        return homePageDao.getLithologyProcessNum(stm,etm);
    }

    @Override
    public int getWeatheringProcessNum(String stm, String etm) {
        return homePageDao.getWeatheringProcessNum(stm,etm);
    }

    @Override
    public int getCurrentLay() {
        return homePageDao.getCurrentLay();
    }

    @Override
    public List<Integer> getLayList() {
        return homePageDao.getLayList();
    }

    @Override
    public String getFinishTime(Integer layNum) {
        return homePageDao.getFinishTime(layNum);
    }

    @Override
    public String getOneLayerMaxGrading(Integer layNum) {
        return homePageDao.getOneLayerMaxGrading(layNum);
    }

    @Override
    public String getUnqualifiedNum(Integer layNum,Long densityWarning) {
        return homePageDao.getUnqualifiedNum(layNum,densityWarning);
    }

    @Override
    public String getQualifiedNum(Integer layNum,Long densityWarning) {
        return homePageDao.getQualifiedNum(layNum,densityWarning);
    }

    @Override
    public String getOneLayerMinDensity(Integer layNum) {
        return homePageDao.getOneLayerMinDensity(layNum);
    }

    @Override
    public String getOneLayerMaxDensity(Integer layNum) {
        return homePageDao.getOneLayerMaxDensity(layNum);
    }
}
