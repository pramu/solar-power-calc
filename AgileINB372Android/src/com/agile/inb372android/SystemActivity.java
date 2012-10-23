package com.agile.inb372android;

import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class SystemActivity extends Activity {

	private ListView listView;
	//private LayoutInflater inflater;
	private ItemAdapter itemAdapter;
	private Activity act =this;
	HashMap<String, String> hashMap;

	//ArrayList<String> systemItems = new ArrayList<String>();
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.listview);

		 
	    listView = (ListView) findViewById(R.id.allListView);
        //inflater = (LayoutInflater) getSystemService(this.LAYOUT_INFLATER_SERVICE);
        hashMap = cmsHTTP.GETHM;
        itemAdapter = new ItemAdapter(this, act, hashMap,  R.layout.listfactor);
		listView.setDivider(new ColorDrawable(Color.DKGRAY));
		listView.setDividerHeight(2);
		listView.setAdapter(itemAdapter);
		
		

	
	}

}
