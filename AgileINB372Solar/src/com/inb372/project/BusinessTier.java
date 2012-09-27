package com.inb372.project;

import java.util.List;
//
//import com.google.appengine.api.datastore.Entity;
//import java.awt.List;
import java.util.ArrayList;


import com.google.appengine.api.datastore.EntityNotFoundException;
//import com.google.appengine.api.datastore.FetchOptions;
//import com.google.appengine.api.datastore.Key;
//import com.google.appengine.api.datastore.KeyFactory;
//import com.google.appengine.api.datastore.Query;
import com.inb372.data.CalculatorDataStore;
import com.inb372.data.SystemDataStore;

public class BusinessTier {
	
	//Calculator inputs from user
	private static String systemCost = "systemCost";
	private static String systemSize = "systemSize";
	private static CalculatorDataStore calculDs;
	private static final String CALID = "calID";
	
	//System data store data
	private static ArrayList<SystemDataStore> systemList;
	private static SystemDataStore systemDataStore = new SystemDataStore();
	
	private static ArrayList<SystemDataStore> panelList;
	
	//------------------------------------------------------------------------------
	//------------------Calculator Data
//	public static void InsertCalculatorData(String systemCost, String systemSize){
//		calculDs = new CalculatorDataStore();
//		calculDs.InsertCalculatorData(CALID, systemCost, systemSize);
//		
//	}
//	public static String GetSystemCost(){
//		systemCost = calculDs.GetSystemCost();
//		return systemCost;
//	}
//	public static String GetSystemSize(){
//		systemSize = calculDs.GetSystemSize();
//		return systemSize;
//	}
//	
	
	public static double[] savingPerYearToBreakEven(double investment, double systemKW, double avgDailyHoursSun, double dayTimeHourlyUsage, double tariff, double feedInFee){
		double [] savings = new double[1];
		
		return savings;
	}
	
	public static int numberOfMonthsToBreakEven(double investment, double systemKW, double avgDailyHoursSun, double dayTimeHourlyUsage, double tariff, double feedInFee){
		
		double replacementGeneration = avgDailyHoursSun * dayTimeHourlyUsage;
		
		double exportedGenKw = systemKW * replacementGeneration - replacementGeneration;
		
		
		double savings = ((exportedGenKw * feedInFee) + (replacementGeneration * tariff)) * 365;
		
		savings = savings /12;
		
		int numMonths = (int)(Math.ceil(investment/savings)); 
		return numMonths;
	}
	
	public static double calculateMinKw(double savings,  double avgDailyHoursSun, double dayTimeHourlyUsage, double tariff, double feedInFee){
		double systemSizeKw;
		//double tariff = 0.1941;
		//double avgDailyHoursSun = 4.5;
		//double feedInFee = 0.05;
		double replacementGeneration = avgDailyHoursSun * dayTimeHourlyUsage;
		double exportedGenKw;
		
		
		exportedGenKw = (((savings / 365) - (replacementGeneration * tariff)) / feedInFee);
		
		systemSizeKw = ((replacementGeneration + exportedGenKw) / replacementGeneration);
		if (systemSizeKw < 0){
			systemSizeKw = 0.01;
		}
		return systemSizeKw;
	}
	
	public static double calculateMinKwForSavingInterval(double savings, String interval, double avgDailyHoursSun, double dayTimeHourlyUsage, double tariff, double feedInFee){
		double systemSizeKw;

		double replacementGeneration = avgDailyHoursSun * dayTimeHourlyUsage;
		double exportedGenKw;


		if (interval.toUpperCase() == "WEEK") {
			savings = savings * 52;
        } else if (interval.toUpperCase() == "FORTNIGHT") {
        	savings = savings * 26;
        } else if (interval.toUpperCase() == "MONTH") {
        	savings = savings * 12;
        } else if (interval.toUpperCase() == "SIXMONTHS") {
        	savings = savings * 2;
        }

		
		exportedGenKw = (((savings / 365) - (replacementGeneration * tariff)) / feedInFee);
		
		systemSizeKw = ((replacementGeneration + exportedGenKw) / replacementGeneration);
		if (systemSizeKw < 0){
			systemSizeKw = 0.01;
		}
		return systemSizeKw;
	}
	
	
	//--------------------------------------------------------------------------------
	//temp insertPanel to create datastore
	
	public static void InsertSystemData(String systemTotal, String systemSize,
			String panelQuentity,String panelSize,
			String panelEfficency, String panelPrice){
		
		systemDataStore.InsertSystemData(systemTotal, systemSize,
				panelQuentity, panelSize, panelEfficency, panelPrice);
	}
//	public static void InsertPanelData(String panelQuentity,String panelSize,
//		String panelEfficency, String panelPrice){
//		systemDataStore.InsertPanelData(panelQuentity, panelSize, panelEfficency, panelPrice);
//	}
	//---------------------------------------------------------------------------------	
	//to get the all the list of objects of SystemDataStore so that can get system, panel, and inverter info
	public static ArrayList<SystemDataStore> SystemList(){
		systemList = new ArrayList<SystemDataStore>();
		for(int i = 0; i < systemDataStore.GetSystemListSize(); i++){
			systemList.add(new SystemDataStore(i));
		}
		return  systemList;
	}
	
//	public static ArrayList<SystemDataStore> PanelList(){
//		panelList = new ArrayList<SystemDataStore>();
//		for(int i = 0; i < systemDataStore.GetPanelListSize(); i++){
//			//need to be find a way for tmep, panelstore
//			panelList.add(new SystemDataStore(i,"panelStore"));
//		}
//		return  panelList;
//	}
	//---------------------------------------------------------------------------------	
	//all data of system
	public static int GetSystemListSize(){
		return systemDataStore.GetSystemListSize();
	}
	public static long GetSystemID(int num){
		return SystemList().get(num).GetSystemID();
	}
	public static String GetSystemTotal(int num){
		return SystemList().get(num).GetSystemTotal();
	}
	public static String GetSystemSize(int num){
		return SystemList().get(num).GetSystemSize();
	}
	
	//---------------------------------------------------------------------------------	
	//all data of panel
	public static int GetPanelListSize(){
		return systemDataStore.GetPanelListSize();
	}
	public static long GetPanelID(int num){
		return SystemList().get(num).GetPanelID();
	}
	//systemID, stored into panel datastore 
	public static String GetPanelSystemID(int num){
		return SystemList().get(num).GetPanelSystemID(num);
	}
	public static String GetPanelPrice(int num){
		return SystemList().get(num).GetPanelPrice();
	}
	public static String GetPanelEfficency(int num){
		return SystemList().get(num).GetPanelEfficency();
	}
	public static String GetPanelSize(int num){
		return SystemList().get(num).GetPanelSize();
	}
	public static String GetPanelQuentity(int num){
		return SystemList().get(num).GetPanelQuentity();
	}

}
