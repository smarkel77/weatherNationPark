package com.techelevator.npgeek.DAO.JDBC;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.DAO.ParkDAO;

@Component
public class JDBCParkDAO implements ParkDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Park> getAllParks() {
		
		String sql = "SELECT parkcode, parkname, state, acreage,"
				+ "elevationinfeet, milesoftrail, numberofcampsites, climate,"
				+ "yearfounded, annualvistiorcount, quote, quotesource, description,"
				+ "entryfee, numberofanimalspecies FROM park";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		
		List<Park> newParkDetails = new ArrayList<Park>();
		
		while(results.next()) {
			newParkDetails.add(mapRowToPark(results));
		}
		
		
		return newParkDetails;
	}

	private Park mapRowToPark(SqlRowSet row) {
		String parkCode = row.getString("parkcode");
		String parkName = row.getString("parkname");
		String state = row.getString("state");
		int acreage = row.getInt("acreage");
		int elevationInFeet = row.getInt("elevationinfeet");
		int milesOfTrail = row.getInt("milesoftail");
		int numberOfCampsites = row.getInt("numberofcampsites");
		String climate = row.getString("climate");
		int yearFounded = row.getInt("yearfounded");
		int annualVisitorCount = row.getInt("annualvisitorcount");
		String quote = row.getString("quote");
		String quoteSource = row.getString("quotesource");
		String description = row.getString("description");
		int entryFee = row.getInt("entryfee");
		int numOfAnimalSpecies = row.getInt("numberofanimalspecies");
		
		
		Park newPark = new Park();
		newPark.setParkCode(parkCode);
		newPark.setParkName(parkName);
		newPark.setState(state);
		newPark.setAcreage(acreage);
		newPark.setElevation(elevationInFeet);
		newPark.setMilesOfTrail(milesOfTrail);
		newPark.setNumOfCampsites(numberOfCampsites);
		newPark.setClimate(climate);
		newPark.setYearFounded(yearFounded);
		newPark.setAnnualVisitors(annualVisitorCount);
		newPark.setQuote(quote);
		newPark.setQuoteSource(quoteSource);
		newPark.setDescription(description);
		newPark.setEntryFee(entryFee);
		newPark.setNumOfSpecies(numOfAnimalSpecies);
		
		return newPark;
		
	}
}
