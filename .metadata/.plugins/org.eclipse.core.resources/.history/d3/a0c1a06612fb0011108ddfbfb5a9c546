package com.inb372.project;

import static org.junit.Assert.*;

import org.junit.*;
import com.inb372.project.*;

public class BusinessTierTest {
	
	private static BusinessTier bt; 
	
	@Before
	public void setup(){
		bt = new BusinessTier();
		
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
	public void verySmallProfit() {
		assertEquals(0.01, BusinessTier.calculateMinKw(100, 4.5, 1, 0.1941, 0.05), 0.01);
	}
}
