package com.agile.inb372android;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MenuActivity extends Activity {
    /** Called when the activity is first created. */
	private Activity act = this;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
       
        Button homePageBtn = (Button) findViewById(R.id.homePageBtn);
        homePageBtn.setOnClickListener(MenuListener);
        Button systemBtn = (Button) findViewById(R.id.systemBtn);
        systemBtn.setOnClickListener(MenuListener);
        Button calculatorBtn = (Button) findViewById(R.id.calculatorBtn);
        calculatorBtn.setOnClickListener(MenuListener);
 
    }
    
    public void GotoWeb(String destinationAdd){
		Uri uri = Uri.parse("http://"+ destinationAdd);
		Intent intent = new Intent(Intent.ACTION_VIEW, uri);
		act.startActivity(intent);
	}       
 // Create an anonymous implementation of OnClickListener
 	private OnClickListener MenuListener = new OnClickListener() {
 		private Intent myIntent;
			
 		public void onClick(View v) {
 			switch (v.getId()) {
 			case R.id.homePageBtn:
 				GotoWeb("1.newagileteamone.appspot.com/index.jsp");
 				break;
 			case R.id.systemBtn:
 				myIntent = new Intent(MenuActivity.this,SystemActivity.class);
 				act.finish();
 				act.startActivity(myIntent);
 				break;
 			case R.id.calculatorBtn:
 				myIntent = new Intent(MenuActivity.this,CalculatorActivity.class);
 				act.finish();
 				act.startActivity(myIntent);
 				break;

 			}
 		}
 	};
}


