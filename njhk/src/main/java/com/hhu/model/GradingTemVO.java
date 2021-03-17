package com.hhu.model;

import java.util.List;

/**
 * @author ：jin
 * @description:
 * @date ：Created in 2021/3/9 10:36
 */
public class GradingTemVO {
    private List<Long> x;
    private List<Long> y_min;
    private List<Long> y_max;

    public List<Long> getX() {
        return x;
    }

    public void setX(List<Long> x) {
        this.x = x;
    }

    public List<Long> getY_min() {
        return y_min;
    }

    public void setY_min(List<Long> y_min) {
        this.y_min = y_min;
    }

    public List<Long> getY_max() {
        return y_max;
    }

    public void setY_max(List<Long> y_max) {
        this.y_max = y_max;
    }

    public GradingTemVO() {
    }

    public GradingTemVO(List<Long> x, List<Long> y_min, List<Long> y_max) {
        this.x = x;
        this.y_min = y_min;
        this.y_max = y_max;
    }
}
