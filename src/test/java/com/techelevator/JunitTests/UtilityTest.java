package com.techelevator.JunitTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.npgeek.Utility;




public class UtilityTest {
	
	@Before
	public void before() {
	}
	
	@After
	public void after() {
	}
	
	@Test
	public void change_temps_to_celsius() {
		int F = 100;
		int C = Utility.convertToCelsius(F);
		Assert.assertEquals(37, C);
	}

}
