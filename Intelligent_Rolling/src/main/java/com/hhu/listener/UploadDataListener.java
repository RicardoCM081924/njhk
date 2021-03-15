package com.hhu.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hhu.dao.WarningDao;
import com.hhu.model.GradingTem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：jin
 * @description: 解析Excel的监听器
 * @date ：Created in 2021/3/10 10:29
 */
public class UploadDataListener extends AnalysisEventListener<GradingTem> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadDataListener.class);

    private final WarningDao warningDao;

    private List<Long> xList = new ArrayList<>();
    private List<Long> yMinList = new ArrayList<>();
    private List<Long> yMaxList = new ArrayList<>();

    public UploadDataListener(WarningDao warningDao) {
        this.warningDao = warningDao;
    }

    /**
     * 每一条数据都会触发这个方法
     * @param gradingTem
     * @param analysisContext
     */
    @Override
    public void invoke(GradingTem gradingTem, AnalysisContext analysisContext) {
        LOGGER.info("解析到一条数据:{}", JSON.toJSONString(gradingTem));
        xList.add(gradingTem.getX());
        yMinList.add(gradingTem.getY_min());
        yMaxList.add(gradingTem.getY_max());
    }

    /**
     * 全部解析完后调用
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
        LOGGER.info("所有数据解析完成！");
    }

    private void saveData() {
        String xString = JSONObject.toJSONString(xList);
        String yMinString = JSONObject.toJSONString(yMinList);
        String yMaxString = JSONObject.toJSONString(yMaxList);
        warningDao.saveGradingTemExcel(xString,yMinString,yMaxString);
    }
}
