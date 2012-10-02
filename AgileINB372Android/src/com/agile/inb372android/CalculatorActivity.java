package com.agile.inb372android;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class CalculatorActivity extends Activity {

	private String result ="";
	private String intervalString = "";
	private Activity act = this;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.calculatorview);
	    
	    //need to be typed more with detail
	    String instructionString = "Instruction: ";
	    
	    final EditText savingsText = (EditText) findViewById(R.id.savingsEditText);
	    final EditText avgDailyHoursSunText = (EditText) findViewById(R.id.avgDailyHoursSunEditText);
	    final EditText dayTimeHourlyUsageText = (EditText) findViewById(R.id.dayTimeHourlyUsageEditText);
	    final EditText tariffText = (EditText) findViewById(R.id.tariffEditText);
	    final EditText feedInFeeText = (EditText) findViewById(R.id.feedInFeeEditText);
	    final TextView resultTextView = (TextView) findViewById(R.id.calculatorReulstTextView);
	    TextView instructionTextView = (TextView) findViewById(R.id.instructionTextView);
	    instructionTextView.setText(instructionString);
	    
	    String[] list = getResources().getStringArray(R.array.intervalArray);
		final Spinner intervalSpinner = (Spinner) act.findViewById(R.id.intervalSpin);
    	final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
    	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	intervalSpinner.setAdapter(dataAdapter);
    	
	    Button checkBtn = (Button) findViewById(R.id.calculatorCheckBtn);
	    checkBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				double savings = Double.parseDouble(savingsText.getText().toString());
				double avgDailyHoursSun = Double.parseDouble(avgDailyHoursSunText.getText().toString());
				double dayTimeHourlyUsage = Double.parseDouble(dayTimeHourlyUsageText.getText().toString());
				double tariff = Double.parseDouble(tariffText.getText().toString());
				double feedInFee = Double.parseDouble(feedInFeeText.getText().toString());
				
				double systemKw = CalculateMinKw(savings, avgDailyHoursSun, dayTimeHourlyUsage, 
						tariff, feedInFee);
			    
				String interval =  GetIntervalSpinner(intervalSpinner, dataAdapter);
				double systemSizeByInterval = CalculateMinKwForSavingInterval(savings, interval, avgDailyHoursSun, dayTimeHourlyUsage, tariff, feedInFee);
				
				result = "You require a system of a minimum size" + systemKw +"kw.\n" +"Interval:" +systemSizeByInterval;
				resultTextView.setText(result);
			}
		});
	    
	 
	}
	
	public String GetIntervalSpinner(Spinner intervalSpinner, ArrayAdapter<String> dataAdapter){
		final int YEARLY = 0;
		final int WEEKLY = 1;
		final int FORTNIGHTLY = 2;
		final int MONTHLY = 3;
		final int SIXMONTHS = 4;
		
		
    	intervalSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				switch(arg2){
				case YEARLY:
					intervalString = "YEARLY";
					break;
				case WEEKLY:
					intervalString = "WEEK";
					break;				
				case FORTNIGHTLY:
					intervalString = "FORTNIGHT";
					break;
				case MONTHLY:
					intervalString = "MONTH";
					break;
				case SIXMONTHS:
					intervalString = "SIXMONTHS";
					break;
				}
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				intervalString = "YEARLY";
				
			}
		});
    	
    	return intervalString;
		
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
	
	
	public static double CalculateMinKwForSavingInterval(double savings, String interval, double avgDailyHoursSun, double dayTimeHourlyUsage, double tariff, double feedInFee){
		double systemSizeKw;

		double replacementGeneration = avgDailyHoursSun * dayTimeHourlyUsage;
		double exportedGenKw;


		if (interval.toUpperCase() == "WEEK") {
			savings = savings * 52;
        } else if (interval.toUpperCase() == "FORTNIGHT") {
        	savings = savings * 26;
        } else if (interval.toUpperCase() == "MONTH") {
        	savings = savings * 12;
        } else if (interval.toUpperCase() == "SIXMONTHS") {
        	savings = savings * 2;
        }

		
		exportedGenKw = (((savings / 365) - (replacementGeneration * tariff)) / feedInFee);
		
		systemSizeKw = ((replacementGeneration + exportedGenKw) / replacementGeneration);
		if (systemSizeKw < 0){
			systemSizeKw = 0.01;
		}
		return systemSizeKw;
	}

}
