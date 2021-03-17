package com.hhu.service;

import com.alibaba.excel.EasyExcel;
import com.hhu.dao.WarningDao;
import com.hhu.listener.UploadDataListener;
import com.hhu.model.GradingTem;
import com.hhu.model.GradingTemJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author ：jin
 * @description:
 * @date ：Created in 2021/2/4 20:15
 */
@Service
public class WarningServiceImpl implements WarningService {

    @Autowired
    private WarningDao warningDao;

    @Override
    public Long getDensityWarning() {
        return warningDao.getDensityWarning();
    }

    @Override
    public int updateDensityWarning(Long newVal) {
        return warningDao.updateDensityWarning(newVal);
    }

    @Override
    public GradingTemJson getGranularWarning() {
        return warningDao.getGranularWarning();
    }

    @Override
    public int updateGranularWarning(Long newVal_x,Long newVal_y_min,Long newVal_y_max) {
        return warningDao.updateGranularWarning(newVal_x,newVal_y_min,newVal_y_max);
    }

    @Override
    public void downloadExcelTem() {
//        String filename = "/Users/jin/Downloads/级配预警条件设置.xlsx";
        String filename = "C:\\Users\\Administrator\\Desktop\\级配预警条件设置.xlsx";
        EasyExcel.write(filename, GradingTem.class).sheet("sheet1").doWrite(Arrays.asList(10L, 6L, 7L));
    }

    @Override
    public void readExcelTem(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), GradingTem.class, new UploadDataListener(warningDao)).sheet().doRead();
    }
}
