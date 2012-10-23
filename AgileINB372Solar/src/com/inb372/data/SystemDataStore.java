package com.inb372.data;

import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;

public class SystemDataStore {

	//to access the data store service
	private DatastoreService dataSv = DatastoreServiceFactory.getDatastoreService();

	private final String SYSTEMID = "systemId";//to give a Entity identity for system
	private final String PANELID = "panelId";//to give a Entity identity for panel
	private final String INVERTERID = "inverterId";//to give a Entity identity for inverter

	private List<Entity> systems;
	private List<Entity> panels;
	private List<Entity> inverters;

	//System data from Datastore
	private long systemID; //datastore auto increase and assign
	private String systemTotal;
	private String systemSize;
	private int systemsListSize;
	
	//Panel data from Datastore
	private long panelID;
	private String panelSystemID="1";
	private String panelQuentity;
	private String panelSize;
	private String panelEfficency;
	private String panelPrice;
	private int panelListSize;

	private int systemNum=0; //to get the number of system so that can read line by for statement
	//private int panelNum;
	
	public SystemDataStore(){ 
		
	}
	//constructor for system info
	public SystemDataStore(int systemNum){
		this.systemNum = systemNum;
		GetSystemData();
		this.systemID = systems.get(systemNum).getKey().getId();
		this.systemTotal = systems.get(systemNum).getProperty("systemTotal").toString(); 
		this.systemSize =  systems.get(systemNum).getProperty("systemSize").toString();
		
		
		if(GetPanelData()!=null){
			GetPanelData();
			panelID = panels.get(systemNum).getKey().getId();
			//panelSystemID = Long.toString(systemID);
			panelQuentity = panels.get(systemNum).getProperty("panelQuentity").toString();
			panelSize = panels.get(systemNum).getProperty("panelSize").toString();
			panelEfficency = panels.get(systemNum).getProperty("panelEfficency").toString();
			panelPrice = panels.get(systemNum).getProperty("panelPrice").toString();
		}
		
	}
	
	//constructor override for panel info
//	public SystemDataStore(int panelNum ,String panelStore){
//		this.panelNum = panelNum;
//		GetPanelData(panelNum);
//		
//	}
	//------------------------------------will be once to use
	//to insert Data, which is system, panel and inverter info
	public void InsertSystemData(String systemTotal,String systemSize,
			String panelQuentity,String panelSize,
			String panelEfficency, String panelPrice){
		String dataID = SYSTEMID;
		DatastoreService dataSv = DatastoreServiceFactory.getDatastoreService();
		Key dataKey = KeyFactory.createKey(dataID+"kind", dataID);
		Entity systemEntity = new Entity(dataID+"entity", dataKey);
		systemEntity.setProperty("systemTotal", systemTotal);
		systemEntity.setProperty("systemSize", systemSize);	
		dataSv.put(systemEntity);
		
		dataID = PANELID;
		
		dataSv = DatastoreServiceFactory.getDatastoreService();
		dataKey = KeyFactory.createKey(dataID+"kind", dataID);
		Entity panelEntity = new Entity(dataID+"entity", dataKey);
		panelSystemID = Long.toString(systemEntity.getKey().getId());
		panelEntity.setProperty("panelSystemID", panelSystemID);
		panelEntity.setProperty("panelQuentity", panelQuentity);
		panelEntity.setProperty("panelSize", panelSize);
		panelEntity.setProperty("panelEfficency", panelEfficency);
		panelEntity.setProperty("panelPrice",panelPrice);
		dataSv.put(panelEntity);
		
	}
	
//	int i =0;
//	public void InsertPanelData(String panelQuentity,String panelSize,
//			String panelEfficency, String panelPrice){
//		String dataID = PANELID;
//		
//		DatastoreService dataSv = DatastoreServiceFactory.getDatastoreService();
//		Key dataKey = KeyFactory.createKey(dataID+"kind", dataID);
//		Entity panelEntity = new Entity(dataID+"entity", dataKey);
//		panelSystemID = Long.toString(GetSystemData().get(i).getKey().getId());
//		panelEntity.setProperty("panelSystemID", panelSystemID);
//		panelEntity.setProperty("panelQuentity", panelQuentity);
//		panelEntity.setProperty("panelSize", panelSize);
//		panelEntity.setProperty("panelEfficency", panelEfficency);
//		panelEntity.setProperty("panelPrice",panelPrice);
//		dataSv.put(panelEntity);
//		//i++;
//		
//	}

	//-------------------------------------------------------------
	//all about System data
	public List<Entity> GetSystemData(){
		Key systemKey = KeyFactory.createKey(SYSTEMID+"kind", SYSTEMID);
		Query query = new Query(SYSTEMID+"entity", systemKey);
			systems = dataSv.prepare(query).asList(FetchOptions.Builder.withLimit(5));
		return systems;
	}
	public int GetSystemListSize(){
		GetSystemData();
		systemsListSize = systems.size();
		return systemsListSize;
	}
		
	public long GetSystemID(){
		return systemID;
	}
	public String GetSystemTotal() {
		return systemTotal;
	}
	public String GetSystemSize() {
		return systemSize;
	}
		
	//-------------------------------------------------------------
	//all about Panel data
	public List<Entity> GetPanelData(){
		Key panelKey = KeyFactory.createKey(PANELID+"kind", PANELID);
		Query query = new Query(PANELID+"entity", panelKey);
		    panels = dataSv.prepare(query).asList(FetchOptions.Builder.withLimit(5));
			
		return panels;
	}
	public int GetPanelListSize(){
		GetPanelData();
		panelListSize = panels.size();
		return panelListSize;
	}
	public long GetPanelID(){
		return panelID;
	}
	//to get the systemID in panel info so that can compare to the systemID in system info
	public String GetPanelSystemID(int panelNum){
		return GetPanelData().get(panelNum).getProperty("panelSystemID").toString();
	}
	public String GetPanelQuentity() {
		return panelQuentity;
	}
	public String GetPanelSize() {
		return panelSize;
	}
	public String GetPanelEfficency() {
		return panelEfficency;
	}
	public String GetPanelPrice() {
		return panelPrice;
	}
	public void SetPanelQuentity(String panelQuentity) {
		this.panelQuentity = panelQuentity;
	}
	public void SetPanelSize(String panelSize) {
		this.panelSize = panelSize;
	}
	public void SetPanelEfficency(String panelEfficency) {
		this.panelEfficency = panelEfficency;
	}
	public void SetPanelPrice(String panelPrice) {
		this.panelPrice = panelPrice;
	}

	
	
	

	
}

