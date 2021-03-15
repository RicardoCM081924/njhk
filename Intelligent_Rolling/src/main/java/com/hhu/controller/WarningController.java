package com.hhu.controller;

import com.alibaba.fastjson.JSONObject;
import com.hhu.model.GradingTemJson;
import com.hhu.model.Tablemap;
import com.hhu.service.WarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author ：jin
 * @description:
 * @date ：Created in 2021/2/4 20:10
 */
@Controller
@RequestMapping("/")
public class WarningController {

    @Autowired
    private WarningService warningService;

    GradingTemJson jsonString ;


    /**
     * 返回级配预警条件
     * @return
     */
    @ResponseBody
    @RequestMapping("/getGranularWarningxList")
    public ArrayList<Integer> getGranularWarningxList(){
        jsonString = warningService.getGranularWarning();
        ArrayList<Integer> xList = JSONObject.parseObject(jsonString.getX(), ArrayList.class);
//        ArrayList<Integer> yMinList = JSONObject.parseObject(jsonString.getY_min(), ArrayList.class);
//        ArrayList<Integer> yMaxList = JSONObject.parseObject(jsonString.getY_max(), ArrayList.class);
        return xList;

    }
    @ResponseBody
    @RequestMapping("/getGranularWarningyMinList")
    public ArrayList<Integer> getGranularWarningyMinList(){
        return JSONObject.parseObject(jsonString.getY_min(), ArrayList.class);

    }
    @ResponseBody
    @RequestMapping("/getGranularWarningyMaxList")
    public ArrayList<Integer> getGranularWarningyMaxList(){
        return JSONObject.parseObject(jsonString.getY_max(), ArrayList.class);

    }

    /**
     * 更新级配预警条件
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateGranularWarning")
    public int updateGranularWarning(Long newVal_x,Long newVal_y_min,Long newVal_y_max){
        return warningService.updateGranularWarning(newVal_x,newVal_y_min,newVal_y_max);
    }

    /**
     * 返回密度预警条件
     * @return
     */
    @ResponseBody
    @RequestMapping("/getDensityWarning")
    public Long getDensityWarning(){
        return warningService.getDensityWarning();
    }

    /**
     * 更新密度预警条件
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateDensityWarning")
    public int updateDensityWarning(Long newVal){
        return warningService.updateDensityWarning(newVal);
    }

    /**
     * 导出Excel模板
     * @return
     */
    @ResponseBody
    @RequestMapping("/downloadExcelTem")
    public int downloadExcelTem(){
        warningService.downloadExcelTem();
        return 1;
    }

    /**
     * 级配预警条件导入
     * @return
     */
    @ResponseBody
    @RequestMapping("/uploadExcel")
    public Tablemap<Object> uploadExcel(MultipartFile file) throws IOException {
        warningService.readExcelTem(file);
        return new Tablemap<Object>(0,"数据导入成功！",0,null);
    }


}
