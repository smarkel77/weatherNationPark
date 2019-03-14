package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.DAO.JDBC.JDBCParkDAO;



public class JDBCParkDAOTest extends DAOIntegrationTest {
	private JDBCParkDAO dao;
	
	@Before
	public void setup() {
		insertPark();
		dao = new JDBCParkDAO(getDataSource());
	}
	
	@Test
	public void get_all_parks() {
		
	}
	
	private void assertParksAreEqual(Park expected, Park actual) {
		Assert.assertEquals(expected.getParkCode(), actual.getParkCode());
		Assert.assertEquals(expected.getParkName(), actual.getParkName());
		Assert.assertEquals(expected.getState(), actual.getState());
		Assert.assertEquals(expected.getAcreage(), actual.getParkCode());
		Assert.assertEquals(expected.getElevation(), actual.getElevation());
		Assert.assertEquals(expected.getMilesOfTrail(), actual.getMilesOfTrail());
		Assert.assertEquals(expected.getNumOfCampsites(), actual.getNumOfCampsites());
		Assert.assertEquals(expected.getClimate(), actual.getClimate());
		Assert.assertEquals(expected.getYearFounded(), actual.getYearFounded());
		Assert.assertEquals(expected.getAnnualVisitors(), actual.getAnnualVisitors());
		Assert.assertEquals(expected.getQuote(), actual.getQuote());
		Assert.assertEquals(expected.getQuoteSource(), actual.getQuoteSource());
		Assert.assertEquals(expected.getDescription(), actual.getDescription());
		Assert.assertEquals(expected.getEntryFee(), actual.getEntryFee());
		Assert.assertEquals(expected.getNumOfSpecies(), actual.getNumOfSpecies());
	}

}
