package com.ibm.monitor;

import java.util.List;

public class ExponentialMovingAverage {
    private double alpha;
    private Double oldValue;
    
    public ExponentialMovingAverage(double alpha) {
        this.alpha = alpha;
    }

    public List<Double> getEMA(List<Double> data){

        for(int i=0;i<data.size();++i) {
            data.set(i,average(data.get(i)));
        }
        return data;
    }

    private double average(double value) {
        if (oldValue == null) {
            oldValue = value;
            return value;
        }
        double newValue = oldValue + alpha * (value - oldValue);
        oldValue = newValue;
        return newValue;
    }
}
