package com.bridgelabz.iplproblem;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;

public class IPLAnalyserTest {

	private static final String IPL_BATSMAN_CSV_FILE_PATH = "./src/test/java/resources/IPL2019FactsheetMostRuns.csv";
	private static final String IPL_BOWLERS_CSV_FILE_PATH = "./src/test/java/resources/IPL2019FactsheetMostWkts.csv";
	
	@Test 
	public void givenIPLBatsmanCSVFile_ShouldReturnCorrectRecords(){
		try {
			IPLAnalyser iplAnalyser = new IPLAnalyser();
			int numOfRecords = iplAnalyser.loadIPLBatsmanData(IPL_BATSMAN_CSV_FILE_PATH);
			Assert.assertEquals(100, numOfRecords);
		} catch (IPLAnalyserException e) {
			System.out.println("Something went wrong, please recheck");
		}
	}
	
	@Test 
	public void givenIPLBowlerCSVFile_ShouldReturnCorrectRecords(){
		try {
			IPLAnalyser iplAnalyser = new IPLAnalyser();
			int numOfRecords = iplAnalyser.loadIPLBowlerData(IPL_BOWLERS_CSV_FILE_PATH);
			Assert.assertEquals(99, numOfRecords);
		} catch (IPLAnalyserException e) {
			System.out.println("Something went wrong, please recheck");
		}
	}
	
	@Test 
	public void givenIPLBatsmanCSVFile_WhenSortedByAverages_ShouldReturnSortedresult(){
		
		try{
			IPLAnalyser iplAnalyser = new IPLAnalyser();
			iplAnalyser.loadIPLBatsmanData(IPL_BATSMAN_CSV_FILE_PATH);
			String sortedIPLDate = iplAnalyser.getAverageWiseSortedData();
			IPLBatsmanCSV[] batsmanCSV= new Gson().fromJson(sortedIPLDate, IPLBatsmanCSV[].class);
			Assert.assertEquals("MS Dhoni", batsmanCSV[0].PLAYER);
		} catch (IPLAnalyserException e) {
			System.out.println("Something went wrong, please recheck");
		}
	}
}
