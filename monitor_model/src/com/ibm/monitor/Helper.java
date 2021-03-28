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
	
	public static double getFiveMinAverage(Reading[] readings) {
		
		int len;
		int start;
		
		len = readings.length;
		start = len -5;
		
		if(start < 0) {
			start = 0;
		}
		
		ArrayList<Double> readingList = new ArrayList<Double>();
		
		//extract the last 5 readings into an array
		//each reading will have three readings, one for each phase
		for(; start < len ; start++) {
			Reading aReading = readings[start];
			
			readingList.add(new Double(aReading.getCur1()));
			readingList.add(new Double(aReading.getCur2()));
			readingList.add(new Double(aReading.getCur3()));
		}
		
		int i = 0;
		
		//Turn the arraylist back to an array
		double[] ar = new double[readingList.size()];
		for(i = 0; i < readingList.size(); i++) {
			ar[i] = readingList.get(i).doubleValue();
		}
		
		
		double mean = StatUtils.mean(ar);
		mean = (double)Math.round(mean * 100d) / 100d;
		return mean;
	}
	
	
}
