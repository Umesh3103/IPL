package com.bridgelabz.iplproblem;

import org.junit.Assert;
import org.junit.Test;

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
		}
	}
	
	@Test 
	public void givenIPLBowlerCSVFile_ShouldReturnCorrectRecords(){
		try {
			IPLAnalyser iplAnalyser = new IPLAnalyser();
			int numOfRecords = iplAnalyser.loadIPLBowlerData(IPL_BOWLERS_CSV_FILE_PATH);
			Assert.assertEquals(99, numOfRecords);
		} catch (IPLAnalyserException e) {
		}
	}
}
