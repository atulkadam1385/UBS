package com.ubs.opsit.interviews;

import static org.apache.commons.lang.math.NumberUtils.toInt;

public class Time {

	final int hr;
	final int min;
	final int sec;

	public Time(int hour, int minutes, int seconds){
		this.hr = hour;
		this.min = minutes;
		this.sec = seconds;
	}
	public static Time parse(String aTime){
    	String[] parts = aTime.split(":");
    	int hour = toInt(parts[0]);
    	int minutes = toInt(parts[1]);
    	int seconds = toInt(parts[2]);
    	return new Time(hour, minutes, seconds);
	}

}