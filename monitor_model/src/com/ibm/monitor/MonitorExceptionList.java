package com.ibm.monitor;

import java.util.ArrayList;

public class MonitorExceptionList {

	private ArrayList<MonitorException> monitorExceptions;
	
	public MonitorExceptionList() {
		monitorExceptions = new ArrayList<MonitorException>();
	}
	
	public void addMonitorException(MonitorException e){
		monitorExceptions.add(e);
	}
	
	public MonitorException[] getMonitorExceptions(){
		
		MonitorException[] exceptionArray = new MonitorException[monitorExceptions.size()];
		exceptionArray = monitorExceptions.toArray(exceptionArray);
				
		return exceptionArray;
	}
}
