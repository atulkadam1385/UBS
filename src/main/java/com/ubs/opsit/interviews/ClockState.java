package com.ubs.opsit.interviews;
import org.apache.commons.lang.text.StrBuilder;
import org.apache.commons.lang.StringUtils;

public class ClockState {
	final String second;
	final String minutes1;
	final String minutes2;
	final String hour1;
	final String hour2;

	ClockState(Time t) {
		this.second = formatSeconds(t.sec);
		this.minutes1 = formatMinutes1(t.min);
		this.minutes2 = formatMinutes2(t.min);
		this.hour1 = formatHours1(t.hr);
		this.hour2 = formatHours2(t.hr);
	}
	@Override
	public String toString(){
    	String str= new StrBuilder().appendWithSeparators(new String[]{ second,hour1,hour2,minutes1,minutes2},System.lineSeparator()).toString();
    	return str;
	}

    private String formatSeconds(int seconds){
    	if(seconds%2==0) return "Y"; else return "O";
    }

    private String formatHours1(int hour){
    	int numberOfRedCells = hour / 5;
    	return formatRow("R", numberOfRedCells, 4);
    }

    private String formatHours2(int hour){
    	int numberOfRedCells = hour % 5;
    	return formatRow("R", numberOfRedCells, 4);
    }

    private String formatMinutes1(int minutes){
    	char[] row = formatRow("Y", minutes / 5, 11).toCharArray();
    	changeToRedIfYellow(row, 2);
    	changeToRedIfYellow(row, 5);
    	changeToRedIfYellow(row, 8);
    	return new String(row);
    }

    private String formatMinutes2(int minutes){
    	int numberOfRedCells = minutes % 5;
    	return formatRow("Y", numberOfRedCells, 4);
    }

    private String formatRow(String light, int times, int length){
    	return StringUtils.repeat(light, times) + StringUtils.repeat("O", length - times);
    }

    private void changeToRedIfYellow(char[] row, int index){
    	if(row[index]=='Y') row[index] = 'R';
    }
}
