package com.hhu.service;

import com.hhu.model.GradingTemJson;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author ：jin
 * @description:
 * @date ：Created in 2021/2/4 20:14
 */
public interface WarningService {
    Long getDensityWarning();

    int updateDensityWarning(Long newVal);

    GradingTemJson getGranularWarning();

    int updateGranularWarning(Long newVal_x,Long newVal_y_min,Long newVal_y_max);

    void downloadExcelTem();

    void readExcelTem(MultipartFile file) throws IOException;
}
