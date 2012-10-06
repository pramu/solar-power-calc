package com.agile.inb372android;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class ItemAdapter extends BaseAdapter{

	LayoutInflater inflater;
	Context context;
	int listLayout;
	public int listCount = 0;
	HashMap<String,String> hm;
	private Activity act;
	
	
	public ItemAdapter(Context context, Activity act,  HashMap<String,String> hm, int listLayout){
		this.context = context;
		this.listLayout = listLayout;
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.hm = hm;
		this.act = act;
		
		listCount = Integer.parseInt(hm.get("count").toString());
			
	}
	
	public int getCount() {
		// TODO Auto-generated method stub
		return listCount;
	}
	
	
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	
	ArrayList<Integer> askedCompareNumberList = new ArrayList<Integer>();
	ArrayList<CheckBox> checkBoxList = new ArrayList<CheckBox>();

	
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		if(convertView == null){
			convertView = inflater.inflate(listLayout, parent, false);
		}
		((TextView) convertView.findViewById(R.id.itemNumber))
		.setText("Cost: "+"$"+hm.get("systemTotal["+position+"]")+"  ");
		((TextView) convertView.findViewById(R.id.itemTitle))
		.setText("Size: "+hm.get("systemSize["+position+"]")+"KW");
		
		final int positionInt = position;
		((LinearLayout) convertView.findViewById(R.id.listfactorLinearLayout)).
		setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ItemDialog itemDialog = new ItemDialog(context, hm, positionInt);
				itemDialog.GetDetailDialog().show();
				
			}
		});
		
		final CheckBox compareCheckBox = new CheckBox(context);
		compareCheckBox.setId(position);
		
		LinearLayout ll = (LinearLayout) convertView.findViewById(R.id.listfactorLinearLayout);
		ll.addView(compareCheckBox);
		
		checkBoxList.add(compareCheckBox);
		Button compareSystem = (Button) act.findViewById(R.id.compareBtn);
		compareSystem.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				for(int i = 0; i < checkBoxList.size(); i++){
					if(checkBoxList.get(i).isChecked()){
						askedCompareNumberList.add(checkBoxList.get(i).getId());
					}
				}
				
				if(askedCompareNumberList.size() == 2){
					Intent intent = new Intent(context, CompareActivity.class);
					intent.putExtra("compareList", askedCompareNumberList);
					context.startActivity(intent); 
				}
				else{
						Toast.makeText(context, "please check two systems to compare", Toast.LENGTH_LONG).show();
					}
				
			}
		});
		
		

		return convertView;
	}
	
}
