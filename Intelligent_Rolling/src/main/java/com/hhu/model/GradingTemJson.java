package com.hhu.model;

/**
 * @author ：jin
 * @description:
 * @date ：Created in 2021/3/9 10:36
 */
public class GradingTemJson {
    private String x;
    private String y_min;
    private String y_max;

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY_min() {
        return y_min;
    }

    public void setY_min(String y_min) {
        this.y_min = y_min;
    }

    public String getY_max() {
        return y_max;
    }

    public void setY_max(String y_max) {
        this.y_max = y_max;
    }

    public GradingTemJson() {
    }

    public GradingTemJson(String x, String y_min, String y_max) {
        this.x = x;
        this.y_min = y_min;
        this.y_max = y_max;
    }
}
