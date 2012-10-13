package com.agile.inb372android;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private  Activity act = this;
	private Context _context = this;
	private cmsHTTP cmshttp;
	
	String theUrl = "http://1.newagileteamone.appspot.com/systemdataxml.jsp";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    protected void onResume(){
  	  ImageView startImage = (ImageView) findViewById(R.id.startImageView) ;
     // new DataLoadtask().execute(0);
      startImage.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,MenuActivity.class);
				startActivity(intent);
							
			}
		});

		super.onResume();
	}
    
    private class DataLoadtask extends AsyncTask<Integer, Integer,Void>{
		private ProgressDialog progressDialog;
		@Override
		protected void  onPreExecute(){
			progressDialog = ProgressDialog.show(_context, "Preparing Data", "Now Loading.... \nRecommend WIFI Network");
				
			
		}
		@Override
		protected Void doInBackground(Integer... params) {
			
			cmshttp = new cmsHTTP(act);
			cmshttp.sendGet(theUrl);
			return null;
		}
		@Override
		protected void onPostExecute(Void abc) {
			progressDialog.dismiss();			
		}
		
	}
}
