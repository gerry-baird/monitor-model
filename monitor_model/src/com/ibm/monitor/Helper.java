package com.ibm.monitor;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.util.FastMath;

import com.ibm.monitor.Reading;



public class Helper {
	
	
	
	public static double getMean(Reading[] readings) {
		
		//extract all the readings into an array
		//each reading will have three readings, one for each phase
		
		ArrayList<Double> readingList = new ArrayList<Double>();
		int i;
		
		for(i = 0; i < readings.length; i++ ) {
			Reading aReading = readings[i];
			
			readingList.add(new Double(aReading.getCur1()));
			readingList.add(new Double(aReading.getCur2()));
			readingList.add(new Double(aReading.getCur3()));
		}
		
		//Turn the arraylist back to an array
		double[] ar = new double[readingList.size()];
		for(i = 0; i < readingList.size(); i++) {
			ar[i] = readingList.get(i).doubleValue();
		}
		
		
		double mean = StatUtils.mean(ar);
		mean = (double)Math.round(mean * 100d) / 100d;
		return mean;
	}
	
	public static double getSTD(double[] readings) {
		double std = FastMath.sqrt(StatUtils.variance(readings));
		std = (double)Math.round(std * 100d) / 100d;
		return std;
	}
	
	public static double getLatestReading(double[] readings) {
		
		int i = readings.length;
		double latestReading = readings[i-1];
		return latestReading;
	}
	
	public static double get12hAverage(double[] readings) {
		
		double result = 0;
		int len;
		int start;
		
		//get the last 12 readings and return an average
		len = readings.length;
		start = len -12;
		
		if(start < 0) {
			start = 0;
		}
		
		int sampleCount = len-start;
		double acc = 0;
		
		for(; start < len ; start++) {
			acc = acc + readings[start];
		}
		
		result = acc/sampleCount;
		result = (double)Math.round(result * 100d) / 100d;
		return result;
	}
	
	
	public static double get24hAverage(double[] readings) {
		
		double result = 0;
		int len;
		int start;
		
		//get the last 24 readings and return an average
		len = readings.length;
		start = len -24;
		
		if(start < 0) {
			start = 0;
		}
		
		int sampleCount = len-start;
		double acc = 0;
		
		for(; start < len ; start++) {
			acc = acc + readings[start];
		}
		
		result = acc/sampleCount;
		result = (double)Math.round(result * 100d) / 100d;
		return result;
	}

	public static double get48hAverage(double[] readings) {
		
		double result = 0;
		int len;
		int start;
		
		//get the last 48 readings and return an average
		len = readings.length;
		start = len -48;
		
		if(start < 0) {
			start = 0;
		}
		
		int sampleCount = len-start;
		double acc = 0;
		
		for(; start < len ; start++) {
			acc = acc + readings[start];
		}
		
		result = acc/sampleCount;
		result = (double)Math.round(result * 100d) / 100d;
		return result;
	}

	
	public static double get96hAverage(double[] readings) {
		
		double result = 0;
		int len;
		int start;
		
		//get the last 96 readings and return an average
		len = readings.length;
		start = len -96;
		
		if(start < 0) {
			start = 0;
		}
		
		int sampleCount = len-start;
		double acc = 0;
		
		for(; start < len ; start++) {
			acc = acc + readings[start];
		}
		
		result = acc/sampleCount;
		result = (double)Math.round(result * 100d) / 100d;
		return result;
	}
	
	public static void addException(int score, String ruleType, String description, MonitorExceptionList mel) {
		
		MonitorException me = new MonitorException();
		me.setScore(score);
		me.setRuleType(ruleType);
		me.setDescription(description);
		
		mel.addMonitorException(me);
	}
	
	public static boolean isPercentageGreater(double a, double b, double percent) {
		boolean result = false;
		
		double limit = b * (1 + percent /100);
		if(a > limit) {
			result = true;
		}
		
		return result;
	}
	
	public static double getEWA(double[] readings) {
		ExponentialMovingAverage exp = new ExponentialMovingAverage(0.15);
		
		List<Double> dList = new ArrayList<Double>(readings.length);
		for(double d : readings) {
		    dList.add(d);
		}
		
		List<Double> ema = exp.getEMA(dList);
		
		int size = ema.size();
		System.out.println("EMA Size " + size);
		
		double lastValue = ema.get(size-1);
		
		System.out.println("EMA " + lastValue);
		
		lastValue = (double)Math.round(lastValue * 100d) / 100d;
		return lastValue;
	}
	
	
	
	public static double[] getLast12Readings(double[] readings) {
		
		int start = readings.length -12;
		int len = readings.length;
		
		if(start < 0) {
			start = 0;
		}
		int i = 0;
		
		double[] result = new double[len-start];
		for(; start < len ; start++) {
			result[i] = readings[start];
			i++;
		}
		
		return result;
	}
	
	public static double[] getLast48Readings(double[] readings) {
		
		int start = readings.length -48;
		int len = readings.length;
		
		if(start < 0) {
			start = 0;
		}
		int i = 0;
		
		double[] result = new double[len-start];
		for(; start < len ; start++) {
			result[i] = readings[start];
			i++;
		}
		
		return result;
	}
	
	public static double[] getLast24Readings(double[] readings) {
		
		int start = readings.length -48;
		int len = readings.length;
		
		if(start < 0) {
			start = 0;
		}
		int i = 0;
		
		double[] result = new double[len-start];
		for(; start < len ; start++) {
			result[i] = readings[start];
			i++;
		}
		
		return result;
	}
	
}
