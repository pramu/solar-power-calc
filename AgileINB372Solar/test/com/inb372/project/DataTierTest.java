/**
 * 
 */
package com.inb372.project;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.inb372.data.CalculationVariables;
import com.inb372.data.DataTier;

/**
 * @author Basil
 *
 */
public class DataTierTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}


	
	/*
	@Test
	public void getLocationDatabyStat (){
		
		assertEquals("QLD",DataTier.GetLocationData("QLD"));
		assertEquals("NSW",DataTier.GetLocationData("NSW"));
	}
	*/
	
/*	@Test
	public void getLocationDatabyState(){
		CalculationVariables calc = DataTier.GetLocationData("QLD");
		assertEquals(10.0,calc.tariff,0.0);
		
		calc = DataTier.GetLocationData("NSW");
		assertEquals(20.0,calc.tariff,0.0);

	}
	
	*/
	
	
	
	
	
	
	
	
	
	
	//addSinglePanel(kw,efficiency %)
	@Test
	public void addSinglePanelToDataStore() {
		
		assertTrue(DataTier.AddSinglePanel(1.5,99));
	}
	
	@Test
	public void addSinglePanelToDataStoreInvalidKWNegative() {
		assertTrue(DataTier.AddSinglePanel(-1,99));
	}
	@Test
	public void addSinglePanelToDataStoreInvalidKWZero() {

		assertTrue(DataTier.AddSinglePanel(0,99));
	}
	@Test
	public void addSinglePanelToDataStoreInvalidKWLowerBound() {
		assertTrue(DataTier.AddSinglePanel(0.01,99));
	}
	@Test
	public void addSinglePanelToDataStoreInvalidKWHigh() {
		assertTrue(DataTier.AddSinglePanel(10000,99));
	}
	
	@Test
	public void addSinglePanelToDataStoreInvalidPanelEfficiencyOver100() {
		assertTrue(DataTier.AddSinglePanel(1.5,101));
	}
	
	@Test
	public void addSinglePanelToDataStoreInvalidPanelEfficiencyUpperBound() {
		assertTrue(DataTier.AddSinglePanel(1.5,99));
	}
	
	@Test
	public void addSinglePanelToDataStoreInvalidPanelEfficiencyLowerBound() {
		assertTrue(DataTier.AddSinglePanel(1.5,1));
	}
	
	@Test
	public void addSinglePanelToDataStoreInvalidPanelEfficiencyZero() {
		assertTrue(DataTier.AddSinglePanel(1.5,0));
	}
	
	@Test
	public void addSinglePanelToDataStoreInvalidPanelEfficiencyNegative() {

		assertTrue(DataTier.AddSinglePanel(1.5,-1));
	}
	
	
	//return Panel object from getSinglePanel(datastorekey)
	@Test
	public void getSinglePanelFromDataStore() {
		assertEquals(1,DataTier.GetSinglePanel(1));
	}
	
	@Test
	public void getSinglePanelFromDataStoreInvalidKey() {
		assertEquals(-1,DataTier.GetSinglePanel(-1));
		//assertTrue(DataTier.GetSinglePanel(-1));
	}
	
	//return list of 
	
	@Test
	public void getPanelList() {
		assertTrue(DataTier.GetAllPanels());
	}
	
	
}
