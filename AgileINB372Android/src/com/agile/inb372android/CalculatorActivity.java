package com.agile.inb372android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends Activity {

	private String result ="";
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.calculatorview);
	    final EditText savings = (EditText) findViewById(R.id.savingsEditText);
	    final EditText avgDailyHoursSun = (EditText) findViewById(R.id.avgDailyHoursSunEditText);
	    final EditText dayTimeHourlyUsage = (EditText) findViewById(R.id.dayTimeHourlyUsageEditText);
	    final EditText tariff = (EditText) findViewById(R.id.tariffEditText);
	    final EditText feedInFee = (EditText) findViewById(R.id.feedInFeeEditText);
	    final TextView resultTextView = (TextView) findViewById(R.id.calculatorReulstTextView);
	    
	    Button checkBtn = (Button) findViewById(R.id.calculatorCheckBtn);
	    checkBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				double systemKw = CalculateMinKw(Double.parseDouble(savings.getText().toString()), Double.parseDouble(avgDailyHoursSun.getText().toString()), 
			    		Double.parseDouble(dayTimeHourlyUsage.getText().toString()), 
			    		Double.parseDouble(tariff.getText().toString()), Double.parseDouble(feedInFee.getText().toString()));
			    result = "You require a system of a minimum size" + systemKw +"kw.";
				resultTextView.setText(result);
				
			}
		});
	    
	}
	public static double CalculateMinKw(double savings, double avgDailyHoursSun, double dayTimeHourlyUsage, double tariff, double feedInFee){
		double systemSizeKw;
		double replacementGeneration = avgDailyHoursSun * dayTimeHourlyUsage;
		double exportedGenKw;
		exportedGenKw = (((savings / 365) - (replacementGeneration * tariff)) / feedInFee);
	
		systemSizeKw = ((replacementGeneration + exportedGenKw) / replacementGeneration);
		if (systemSizeKw < 0){
			systemSizeKw = 0.01;
		}
		return systemSizeKw;
	}

}
