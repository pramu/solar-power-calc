package com.inb372.project;

import static org.junit.Assert.*;
import static com.inb372.project.*;

import org.junit.*;

public class BusinessTierTest {
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	//Testing for US #2
	//@Test
	//public void basicCalcTest() {
	//	assertEquals(3.2, BusinessTier.calculateMinKw(500), 0.01);
	//}
	
	//Testing for US #3
	@Test
	public void addParamsCalcTest() {
		assertEquals(4, BusinessTier.calculateMinKw(565, 4.5, 1, 0.1941, 0.05), 0.01);
	}
	
	@Test
	public void save500PerYear() {
		assertEquals(3.2, BusinessTier.calculateMinKw(500, 4.5, 1, 0.1941, 0.05), 0.01);
	}
	
	@Test
	public void verySmallProfit() {
		assertEquals(0.01, BusinessTier.calculateMinKw(100, 4.5, 1, 0.1941, 0.05), 0.01);
	}
	
	
	
	@Test
	public void calculateYearlySaving()
	{
		assertEquals(3.2, BusinessTier.calculateMinKwForSavingInterval(500,"YEAR",4.5,1,0.1941,0.05), 0.01);
	}
	@Test
	public void calculateYearlySavingTooSmall()
	{
		assertEquals(0.01, BusinessTier.calculateMinKwForSavingInterval(200,"YEAR",4.5,1,0.1941,0.05), 0.01);
	}
	
	@Test
	public void calculateSixMonthSaving()
	{
		assertEquals(3.2, BusinessTier.calculateMinKwForSavingInterval(250,"SIXMONTHS",4.5,1,0.1941,0.05), 0.01);
	}
	
	@Test
	public void calculateSixMonthSavingTooSmall()
	{
		assertEquals(0.01, BusinessTier.calculateMinKwForSavingInterval(50,"SIXMONTHS",4.5,1,0.1941,0.05), 0.01);
	}
	
	@Test
	public void calculateMonthSaving()
	{
		assertEquals(3.2, BusinessTier.calculateMinKwForSavingInterval(41.6,"MONTH",4.5,1,0.1941,0.05), 0.01);
	}
	@Test
	public void calculateMonthSavingTooSmall()
	{
		assertEquals(0.01, BusinessTier.calculateMinKwForSavingInterval(10,"MONTH",4.5,1,0.1941,0.05), 0.01);
	}
	
	
	@Test
	public void calculateFortnightSaving()
	{
		assertEquals(3.2, BusinessTier.calculateMinKwForSavingInterval(19.2,"FORTNIGHT",4.5,1,0.1941,0.05), 0.01);
	}
	@Test
	public void calculateFortnightSavingTooSmall()
	{
		assertEquals(0.01, BusinessTier.calculateMinKwForSavingInterval(5,"FORTNIGHT",4.5,1,0.1941,0.05), 0.01);
	}
	
	
	@Test
	public void calculateWeekSaving()
	{
		assertEquals(3.2, BusinessTier.calculateMinKwForSavingInterval(9.6,"WEEK",4.5,1,0.1941,0.05), 0.01);
	}
	
	@Test
	public void calculateWeekSavingTooSmall()
	{
		assertEquals(0.01, BusinessTier.calculateMinKwForSavingInterval(1,"WEEK",4.5,1,0.1941,0.05), 0.01);
	}
	
	@Test(expected=NullPointerException.class)
	public void calculateNullWeek()
	{
		assertEquals(0.01, BusinessTier.calculateMinKwForSavingInterval(1,null,4.5,1,0.1941,0.05), 0.01);
	}
	
	
	@Test
	public void calculateReturnOn500()
	{
		assertEquals(13, BusinessTier.numberOfMonthsToBreakEven(500.0, 3.2, 4.5, 1.0, 0.1941, 0.05), 0.01);
	}
	
	@Test
	public void calculateReturnOn565()
	{
		assertEquals(14, BusinessTier.numberOfMonthsToBreakEven(565.0, 3.2, 4.5, 1.0, 0.1941, 0.05), 0.01);
	}
	
	
	@Test
	public void calculateReturnOn250()
	{
		assertEquals(7, BusinessTier.numberOfMonthsToBreakEven(250.0, 3.2, 4.5, 1.0, 0.1941, 0.05), 0.01);
	}

	@Test(expected=NullPointerException.class)
	public void nullGetSystemID()
	{
		assertEquals(7, BusinessTier.GetSystemID(1), 0.01);
	}
	
	@Test(expected=NullPointerException.class)
	public void nullGetPanelListSize() {
		assertEquals(7, BusinessTier.GetPanelListSize(), 0.01);
		
	}
	
	@Test(expected=NullPointerException.class)
	public void nullGetPanelID() {
		assertEquals(7, BusinessTier.GetPanelID(1), 0.01);
		
	}
	
	@Test(expected=NullPointerException.class)
	public void nullGetPanelSystemID() {	
		assertEquals("1", BusinessTier.GetPanelSystemID(1));
		
	}
	
	@Test(expected=NullPointerException.class)
	public void nullGetPanelPrice() {		
		assertEquals("1", BusinessTier.GetPanelPrice(1));
		
	}
	
	@Test(expected=NullPointerException.class)
	public void nullGetPanelEfficency() {	
		assertEquals("1", BusinessTier.GetPanelEfficency(1));
		
	}
	
	@Test(expected=NullPointerException.class)
	public void nullGetPanelSize() {
		assertEquals("1", BusinessTier.GetPanelSize(1));
		
	}
	
	@Test(expected=NullPointerException.class)
	public void nullGetPanelQuentity() {
		assertEquals("1", BusinessTier.GetPanelQuentity(1));
		
	}

}
