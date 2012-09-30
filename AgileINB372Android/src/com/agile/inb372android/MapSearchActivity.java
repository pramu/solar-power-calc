package com.agile.inb372android;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class MapSearchActivity extends MapActivity {
	
	MapView owlMap;
	public String TAG = "MapActivity";
	private Activity act = this;
	private cmsHTTP cmshttpForMap;
	String tmpKeyWord;
	Context _context = this;
	
	private LocationManager locManager;
	private LocationListener locListener = new MyLocationListener();
	private boolean gps_enabled = false;
	private boolean network_enabled = false;
	
	private double currentLonditude;
	private double currentLatitude; 
	
	private final int ADDCURRENTLOCATIONNUM = 1;
	private ArrayList<mapOverlay> mapOverlayList = new ArrayList<mapOverlay>();
	private ArrayList<OverlayItem> markerList = new ArrayList<OverlayItem>();
	private ArrayList<String> testLocationList = new ArrayList<String>();
	private ArrayList<String> testInfoList = new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.googlemapview);
        //for test multiple locations
        testLocationList.add("nundah");
        testInfoList.add("save: 100KW p/w");
        testLocationList.add("qut");
        testInfoList.add("save: 200KW p/w");
        testLocationList.add("kelvin grove");
        testInfoList.add("save: 232KW p/w");
        testLocationList.add("woolloogabba");
        testInfoList.add("save: 420KW p/w");
        
        locManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        GetCurrentLocation();
        
		Button mapSearchBtn = (Button) findViewById(R.id.mapSearchBtn);
		mapSearchBtn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				new MapLoadtask().execute();
			}
		});
	    
	    
    }
    
    public void GetCurrentLocation(){
    	
    	// exceptions will be thrown if provider is not permitted.
    	
    	try {
    		gps_enabled = locManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    		network_enabled = locManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        	
    	} catch (Exception ex) {
    	
    	}
    	// don't start listeners if no provider is enabled
    	
    	if (!gps_enabled) {
    
//    	AlertDialog.Builder builder = new Builder(this);
//    	
//    	builder.setTitle("Attention!");
//    	
//    	builder.setMessage("Sorry, location is not determined. Please enable location providers");
//    
//    	builder.create().show();
    
    	}
    
    	if (gps_enabled) {
    		locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locListener);
    	}
    	if (network_enabled) {
    		locManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locListener);
    	}
    }
    public void doSearchMap(String query, int markerNum) {
    	
		int latitude = 0;
		int longitude = 0;
		String encoding = "UTF-8";
		String queryEnc = "";
		
		try {
			queryEnc = URLEncoder.encode(query, encoding);
		} catch (UnsupportedEncodingException e) {
			Log.e(TAG, e.getMessage());
		}
		String theUrl = "http://maps.google.co.kr/maps/api/geocode/json?sensor=true&address="+queryEnc;
//		String theUrl = "http://maps.google.co.kr/maps/api/geocode/xml?sensor=true&address="+queryEnc;
		Log.i(TAG, theUrl);

		cmshttpForMap = new cmsHTTP(act);
		String tmpData = cmshttpForMap.sendGet(theUrl);
		
		if (tmpData==null) return;
		
		Log.i(TAG, tmpData);
		
		try {
			JSONObject jObj = new JSONObject(tmpData);
			Log.i(TAG, jObj.toString());
			if (jObj!=null) {
				Log.i(TAG, "===========================");
				Log.i(TAG, jObj.getJSONArray("results").toString());
				Log.i(TAG, jObj.getJSONArray("results").getJSONObject(0).toString());
				Log.i(TAG, jObj.getJSONArray("results").getJSONObject(0).getString("geometry"));
				Log.i(TAG, jObj.getJSONArray("results").getJSONObject(0).getJSONObject("geometry")
						.getString("location"));
				Log.i(TAG, jObj.getJSONArray("results").getJSONObject(0).getJSONObject("geometry")
						.getJSONObject("location").getString("lat"));

				double tmpX = jObj.getJSONArray("results").getJSONObject(0).getJSONObject("geometry")
				.getJSONObject("location").getDouble("lat");
				double tmpY = jObj.getJSONArray("results").getJSONObject(0).getJSONObject("geometry")
				.getJSONObject("location").getDouble("lng");
				
				latitude = Double.valueOf(tmpX*1E6).intValue();
				longitude = Double.valueOf(tmpY*1E6).intValue();
				
				Log.i(TAG, "tmpX : "+Double.toString(tmpX));
				Log.i(TAG, "tmpY : "+Double.toString(tmpY));
				Log.i(TAG, "latitude : "+Integer.toString(latitude));
				Log.i(TAG, "longitude : "+Integer.toString(longitude));
			}
		} catch (JSONException e) {
			Log.e(TAG, e.getMessage());
		}
		viewMap(latitude, longitude, query, markerNum);

		
	}
	
	
	public void viewMap(int latitude, int longitude, String query, int markerNum) {
		
		owlMap = (MapView)findViewById(R.id.maps);
	    owlMap.setSatellite(false);
	    owlMap.setBuiltInZoomControls(true);
	    
        GeoPoint p = new GeoPoint(latitude , longitude);
        List<Overlay> mapOverlays = owlMap.getOverlays();

        if (mapOverlays.size() > 0) {
        	mapOverlays.clear(); 
    		Log.d(TAG, "clear overlays : " + mapOverlays.size());
    	} else {
    		Log.d(TAG, "empty overlays");
    	}
        
        Drawable marker = this.getResources().getDrawable(R.drawable.map_mark);
        
    	marker.setBounds(0, 0, marker.getIntrinsicWidth(), marker.getIntrinsicHeight());       
        mapOverlay mapOverlay = new mapOverlay(marker);
        mapOverlay.mContext = this;
        mapOverlay.mPopulate();
        
        String info = testInfoList.get(markerNum-1);
        OverlayItem overlayitem = new OverlayItem(p, "Destination: " + query, info);
        markerList.add(overlayitem);
        
        mapOverlay.addOverlay(markerList.get(markerNum));
        //mapOverlay.addOverlay(markerList.get(1));
        
        mapOverlayList.add(mapOverlay);
   
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
	
	 private class MapLoadtask extends AsyncTask<Integer, Integer,Void>{
			private ProgressDialog progressDialog;
			@Override
			protected void  onPreExecute(){
				progressDialog = ProgressDialog.show(_context, "Preparing MapData", "Now Loading.... \nRecommend WIFI Network");
					
				
			}
			@Override
			protected Void doInBackground(Integer... params) {
				for(int i = 0; i < testLocationList.size(); i ++){
					doSearchMap(testLocationList.get(i), i+ADDCURRENTLOCATIONNUM);
				}
				return null;
			}
			@Override
			protected void onPostExecute(Void abc) {
				progressDialog.dismiss();
				int temp = mapOverlayList.size();
				for(int i =0; i< temp; i++){
					owlMap.getOverlays().add(mapOverlayList.get(i));
					owlMap.postInvalidate();
				}
			}
			
		}
	 
	 class MyLocationListener implements LocationListener {

		@Override
		public void onLocationChanged(Location location) {
			if (location != null) {
				// This needs to stop getting the location data and save the battery power.
				locManager.removeUpdates(locListener);		
				currentLonditude = location.getLongitude();
				currentLatitude = location.getLatitude();	
				double altitiude = location.getAltitude();
				double accuracy = location.getAccuracy();
				String time = "Time: " + location.getTime();
				String text ="Londitude:"+currentLonditude + "\n" + 
							"Latitude:"+currentLatitude + "\n" + 
							"Altitiude: " + altitiude + "\n" + 
							"Accuracy: " + accuracy + "\n" + time;
				Toast.makeText(_context, text, Toast.LENGTH_LONG).show();
				
				owlMap = (MapView)findViewById(R.id.maps);
			    owlMap.setSatellite(true);
			    owlMap.setBuiltInZoomControls(true);
			    
			    int fixLon = Double.valueOf(currentLonditude*1E6).intValue();
		        int fixLan = Double.valueOf(currentLatitude*1E6).intValue();
			    GeoPoint p = new GeoPoint(fixLan,fixLon);

		   	    //need to be change to avoid repitation    
		        List<Overlay> mapOverlays = owlMap.getOverlays();

		        if (mapOverlays.size() > 0) {
		        	mapOverlays.clear(); 
		    		Log.d(TAG, "clear overlays : " + mapOverlays.size());
		    	} else {
		    		Log.d(TAG, "empty overlays");
		    	}
		        
		        Drawable marker = act.getResources().getDrawable(R.drawable.currentpushpin);
		        
		    	marker.setBounds(0, 0, marker.getIntrinsicWidth(), marker.getIntrinsicHeight());       
		        mapOverlay mapOverlay = new mapOverlay(marker);
		        mapOverlay.mContext = _context;
		        mapOverlay.mPopulate();
		        
		        OverlayItem overlayitem = new OverlayItem(p, "Location", "your location!");
		        markerList.add(overlayitem);
		        mapOverlay.addOverlay(markerList.get(0));
		        mapOverlayList.add(mapOverlay);
		        owlMap.getOverlays().add(mapOverlay);
		        owlMap.getController().animateTo(p);
		        owlMap.getController().setZoom(12);
		        owlMap.postInvalidate();
		        
			}
			
		}

		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			
		}
		 
	 }
	 
	
}