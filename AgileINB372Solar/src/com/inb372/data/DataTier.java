package com.inb372.data;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import java.util.List;

public class DataTier {
	
	
	
	private static DatastoreService dataStoreService = DatastoreServiceFactory.getDatastoreService();

	public static CalculationVariables GetLocationData(String state){

		
		//switch for state parameters
			//retrieve data from datastore based on state provided 
		//return array of variables for the website 
		
	
		
		//return array of variables for the website		
		return (CalculationVariables)QueryDataStore("CalculationVariable", state);
		
	}
	

	

	public static String AddToDataStore(String kind, String key, List<String> PropertyName, List<Object> obj){
		
		
		Key dataKey = KeyFactory.createKey(kind, key);
		Entity dataEntity = new Entity(kind, dataKey);
	
		for (int i=0; i < PropertyName.size(); i++) {
			dataEntity.setProperty(PropertyName.get(i), obj.get(i));
		}
		//dataEntity.setProperty("Value", obj);
		//dataStoreService.put(dataEntity);
		
		Key dataEntityKey = dataStoreService.put(dataEntity);
		
		return  dataEntityKey.getName();

	}
	
	

	public static Object QueryDataStore(String kind, String key){
		
		Key dataKey = KeyFactory.createKey(kind, key);
		Query query = new Query(kind, dataKey);
		
		Object obj = dataStoreService.prepare(query).asList(FetchOptions.Builder.withLimit(5));
		
		return obj;

	}
	
	
	
	
	public static boolean AddSinglePanel(double d, int efficiency){
		
		return true;
	}

	public static int GetSinglePanel(int i){
		
		return i;
	}

	public static boolean GetAllPanels(){
		
		return true;
	}


}
