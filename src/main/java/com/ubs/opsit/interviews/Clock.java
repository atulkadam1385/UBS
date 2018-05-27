package com.ubs.opsit.interviews;



public class Clock implements TimeConverter {

	@Override
	public String convertTime(String aTime) {
		// TODO Auto-generated method stub
		Time time = Time.parse(aTime);
		//System.out.println(""+time);
    	ClockState clockState = new ClockState(time);
    	return clockState.toString();
	}
	
	public static void main(String[] args) {
		 Clock c= new Clock();
		 System.out.println("============== Scenario: Midnight =======================================");
		 System.out.println(c.convertTime("00:00:00"));
		 System.out.println("============== Scenario: Middle of the afternoon =========================");
		 System.out.println(c.convertTime("13:17:01"));
		 System.out.println("============== Scenario: Just before midnight ============================");
		 System.out.println(c.convertTime("23:59:59"));
		 System.out.println("============== Scenario: Midnight ========================================");
		 System.out.println(c.convertTime("24:00:00"));
	}

}
