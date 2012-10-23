package com.agile.inb372android;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;

public class CompareActivity extends Activity {

	private Context con = this;
	private HashMap<String, String> hm;
	private Activity act = this;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.compareview);
	    
	    hm = cmsHTTP.GETHM;
	    
	    //system display
	    TableRow tr1 = (TableRow) findViewById(R.id.tableRow1);
	    TableRow tr2 = (TableRow) findViewById(R.id.tableRow2);
	    TableRow tr3 = (TableRow) findViewById(R.id.tableRow3);
	    
	    //panel display
	    TableRow tr4 = (TableRow) findViewById(R.id.tableRow4);
	    TableRow tr5 = (TableRow) findViewById(R.id.tableRow5);
	    TableRow tr6 = (TableRow) findViewById(R.id.tableRow6);
	    TableRow tr7 = (TableRow) findViewById(R.id.tableRow7);
	    
	    Intent intent =getIntent();
	    ArrayList<Integer> receivList = intent.getExtras().getIntegerArrayList("compareList");
	    
	    Button backBtn = (Button) findViewById(R.id.backBtn);
	    backBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent myIntent = new Intent(CompareActivity.this,SystemActivity.class);
				act.finish();
				act.startActivity(myIntent);
				
			}
		});
	    
	    for(int i = 0; i< receivList.size(); i++){
	    	
	    	TextView systemIDTv = new TextView(con);
	    	systemIDTv.setBackgroundColor(Color.BLACK);
	    	systemIDTv.setTextColor(Color.WHITE);
	    	//systemIDTv.setId(i);
	    	systemIDTv.setText((receivList.get(i)).toString());
	    	tr1.addView(systemIDTv);
	    	
	    	TextView systemTotalTv = new TextView(con);
	    	systemTotalTv.setBackgroundColor(Color.BLACK);
	    	systemTotalTv.setTextColor(Color.WHITE);
	    	//systemTotalTv.setId(i);
	    	systemTotalTv.setText(hm.get("systemTotal["+receivList.get(i)+"]"));
	    	tr2.addView(systemTotalTv);
	    	
	    	TextView systemSizeTv = new TextView(con);
	    	systemSizeTv.setBackgroundColor(Color.BLACK);
	    	systemSizeTv.setTextColor(Color.WHITE);
	    	//systemSizeTv.setId(i);
	    	systemSizeTv.setText(hm.get("systemSize["+receivList.get(i)+"]"));
	    	tr3.addView(systemSizeTv);
	    	
	    	TextView panelPriceTv = new TextView(con);
	    	panelPriceTv.setBackgroundColor(Color.BLACK);
	    	panelPriceTv.setTextColor(Color.WHITE);
	    	//panelPriceTv.setId(i);
	    	panelPriceTv.setText(hm.get("panelPrice["+receivList.get(i)+"]"));
	    	tr4.addView(panelPriceTv);
	    	
	    	TextView panelEfficencyTv = new TextView(con);
	    	panelEfficencyTv.setBackgroundColor(Color.BLACK);
	    	panelEfficencyTv.setTextColor(Color.WHITE);
	    	//panelEfficencyTv.setId(i);
	    	panelEfficencyTv.setText(hm.get("panelEfficency["+receivList.get(i)+"]"));
	    	tr5.addView(panelEfficencyTv);
	    	
	    	TextView panelSizeTv = new TextView(con);
	    	panelSizeTv.setBackgroundColor(Color.BLACK);
	    	panelSizeTv.setTextColor(Color.WHITE);
	    	//panelSizeTv.setId(i);
	    	panelSizeTv.setText(hm.get("panelSize["+receivList.get(i)+"]"));
	    	tr6.addView(panelSizeTv);
	    	
	    	TextView panelQuentityTv = new TextView(con);
	    	panelQuentityTv.setBackgroundColor(Color.BLACK);
	    	panelQuentityTv.setTextColor(Color.WHITE);
	    	//panelQuentityTv.setId(i);
	    	panelQuentityTv.setText(hm.get("panelQuentity["+receivList.get(i)+"]"));
	    	tr7.addView(panelQuentityTv);
	    }
	}

}
