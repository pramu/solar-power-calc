package com.agile.inb372android;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.app.Dialog;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class ItemDialog{

	private Context con;
	private Dialog dialog;
	private int itemNum;
	private HashMap<String,String> item;
	
	public ItemDialog(Context con, HashMap<String,String> item, int itemNum) {
		this.con = con;
		this.item = item;
		this.itemNum = itemNum;
	}

	
	public Dialog GetDetailDialog(){
		 	dialog = new Dialog(con);
			dialog.setContentView(R.layout.detailview);
			TextView panelPrice = (TextView) dialog.findViewById(R.id.panelPrice);
			TextView panelEfficency = (TextView) dialog.findViewById(R.id.panelEfficency);
			TextView panelSize = (TextView) dialog.findViewById(R.id.panelSize);
			TextView panelQuentity = (TextView) dialog.findViewById(R.id.panelQuentity);
			
			panelPrice.setText("$"+item.get("panelPrice["+itemNum+"]"));
			panelEfficency.setText(item.get("panelEfficency["+itemNum+"]")+"%");
			panelSize.setText(item.get("panelSize["+itemNum+"]"));
			panelQuentity.setText(item.get("panelQuentity["+itemNum+"]"));
			
			Button closeBtn = (Button) dialog.findViewById(R.id.detailCloseBtn);
			closeBtn.setOnClickListener(new OnClickListener() {	
				public void onClick(View v) {
					dialog.dismiss();
				}
			});
			
			return dialog;
	}

	


}
