package com.example.timetolondon;

import java.util.Calendar;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;

public class CountTime extends ActionBarActivity {

	protected MainActivity context;
	private Calendar endDay, today;
	private long days = 0, hours = 0, minutes = 0, seconds = 0;
	
	public CountTime(Calendar endDay) {
		this.endDay = endDay;
	}
	
	public void calculateTime() {
		 this.today = Calendar.getInstance();  

		  long different = this.endDay.getTimeInMillis() - today.getTimeInMillis(); //result in millis
		  
		  long secondsInMillis = 1000;
		  long minutesInMillis = secondsInMillis * 60;
		  long hoursInMillis = minutesInMillis * 60;
		  long daysInMillis = hoursInMillis * 24;
		  		  
		  long elapsedDays = different / daysInMillis;
		  different = different % daysInMillis;
		  
		  long elapsedHours = different / hoursInMillis;
		  different = different % hoursInMillis;
		  
		  long elapsedMinutes = different / minutesInMillis;
		  different = different % minutesInMillis;
		  
		  long elapsedSeconds = different / secondsInMillis;
		  
		this.days = elapsedDays; 
		this.hours = elapsedHours; 
		this.minutes = elapsedMinutes; 
		this.seconds = elapsedSeconds;
	}
	
	public void setEndDay(Calendar endDay) {
		this.endDay = endDay;
	}
	
	public long getDays() {
		return this.days;		
	}
	
	public long getHours() {
		return this.hours;		
	}
	
	public long getMinutes() {
		return this.minutes;		
	}
	
	public long getSeconds() {
		return this.seconds;		
	}
}
