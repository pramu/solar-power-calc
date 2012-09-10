package com.inb372.data;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import java.util.List;

public class CalculatorDataStore{
    //private static final Logger log = Logger.getLogger(SignGuestbookServlet.class.getName());

	private DatastoreService dataSv = DatastoreServiceFactory.getDatastoreService();
	private String _systemCost;
	private String _systemSize;
	public void InsertCalculatorData(String dataID, String systemCost, String systemSize) {
     
    	Key dataKey = KeyFactory.createKey(dataID+"kind", dataID);
		Entity calculatorEntity = new Entity(dataID+"entity", dataKey);
		calculatorEntity.setProperty("systemCost", systemCost);
		calculatorEntity.setProperty("systemSize", systemSize);
		
		dataSv.put(calculatorEntity);
			 Query query = new Query(dataID+"entity", dataKey);//.addSort("systemCost", Query.SortDirection.DESCENDING)
			    List<Entity> calculs = dataSv.prepare(query).asList(FetchOptions.Builder.withLimit(5));
			     
//			    for(Entity calcul : calculs ){
//			    	if(calcul != null){
//			    		_systemCost = calcul.getProperty("systemCost").toString();
//			    		//String temp = _systemCost;
//			    		
//			    	}
//			    	else{
//			    		
//			    	}
//			    } 
			    
			    //get systemcost within the calID entity 
			    //the num indecated the line<ID>
			    int num = 0;
			    _systemCost = calculs.get(num).getProperty("systemCost").toString();
    }
    
    public String GetSystemCost(){
    	return _systemCost;
    }
    public String GetSystemSize(){
    	return _systemSize;
    }
    public DatastoreService GetDatastroeService(){
		return this.dataSv;
	}
}