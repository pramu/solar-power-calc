package com.agile.inb372android;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ItemAdapter extends BaseAdapter{

	LayoutInflater inflater;
	Context context;
	int listLayout;
	public int listCount = 0;
	
	HashMap<String,String> hm;
	
	public ItemAdapter(Context context,  HashMap<String,String> hm, int listLayout){
		this.context = context;
		this.listLayout = listLayout;
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.hm = hm;
		
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

		return convertView;
	}
	
}
