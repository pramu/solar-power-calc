package com.agile.inb372android;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class mapOverlay extends ItemizedOverlay<OverlayItem> {

	private ArrayList<OverlayItem> tmpOverlays = new ArrayList<OverlayItem>();
	public Context mContext;

	public mapOverlay(Drawable defaultMarker) {
		super(boundCenterBottom(defaultMarker));
		tmpOverlays = new ArrayList<OverlayItem>();

	}


	public mapOverlay(Drawable defaultMarker, Context context) {
		super(defaultMarker);
		mContext = context;
	}

	public void addOverlay(OverlayItem overlay) {
		tmpOverlays.add(overlay);
		populate();
	}

	@Override
	protected OverlayItem createItem(int i) {
		return tmpOverlays.get(i);
	}

	@Override
	public int size() {
		return tmpOverlays.size();
	}

	@Override
	protected boolean onTap(int index) {
		 OverlayItem item = tmpOverlays.get(index);
		 AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
		 dialog.setTitle(item.getTitle());
		 dialog.setMessage(item.getSnippet());
		 dialog.show();
		return true;
	}

	public void mPopulate() {
		populate();
	}

}
