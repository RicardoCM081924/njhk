package com.hhu.model;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * @author ：jin
 * @description:
 * @date ：Created in 2021/3/9 10:36
 */
public class GradingTem {

    @ExcelProperty(value = "x", index = 0)
    private Long x;
    @ExcelProperty(value = "y_min", index = 1)
    private Long y_min;
    @ExcelProperty(value = "y_max", index = 2)
    private Long y_max;

    public Long getX() {
        return x;
    }

    public void setX(Long x) {
        this.x = x;
    }

    public Long getY_min() {
        return y_min;
    }

    public void setY_min(Long y_min) {
        this.y_min = y_min;
    }

    public Long getY_max() {
        return y_max;
    }

    public void setY_max(Long y_max) {
        this.y_max = y_max;
    }

    public GradingTem() {
    }

    public GradingTem(Long x, Long y_min, Long y_max) {
        this.x = x;
        this.y_min = y_min;
        this.y_max = y_max;
    }
}
