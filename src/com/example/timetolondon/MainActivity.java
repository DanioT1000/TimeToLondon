package com.example.timetolondon;

import java.util.Calendar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	private TextView  tvDays;
	private TextView tvHours;
	private TextView tvMinutes;
	private TextView tvSeconds;
	private boolean mPause = false;  //false = run;   true = stop
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tvDays = (TextView) findViewById(R.id.tvDays);
		tvHours = (TextView) findViewById(R.id.tvHours);
		tvMinutes = (TextView) findViewById(R.id.tvMinutes);
		tvSeconds = (TextView) findViewById(R.id.tvSeconds);
		

		final Calendar thatDay = Calendar.getInstance();
		  thatDay.set(Calendar.DAY_OF_MONTH,17);
		  thatDay.set(Calendar.MONTH,2); // 0-11 so 1 less 0= January
		  thatDay.set(Calendar.YEAR, 2015);
		  thatDay.set(Calendar.HOUR_OF_DAY, 21);
		  thatDay.set(Calendar.MINUTE,40);
	 
		  Thread t = new Thread() {
			  @Override
			  public void run() {
				  
			    try {
			      while (!isInterrupted()) {
			        Thread.sleep(1000);
			        runOnUiThread(new Runnable() {
			          @Override
			          public void run() {
			        	  CountTime ctt = new CountTime(thatDay);
			        	  ctt.calculateTime();
			        	  tvDays.setText(String.valueOf(ctt.getDays()));
			        	  tvHours.setText(String.valueOf(ctt.getHours()));
			        	  tvMinutes.setText(String.valueOf(ctt.getMinutes()));
			        	  tvSeconds.setText(String.valueOf(ctt.getSeconds()));
			          }
			        });
			      }
			    } catch (InterruptedException e) {
			    }
			  }
			};
		
			t.start(); //start thread	
			
			
	}
	@Override
	public void onResume() {
		super.onResume();
	}
	
	@Override
	public void onPause() {
		super.onPause();
	}


}
