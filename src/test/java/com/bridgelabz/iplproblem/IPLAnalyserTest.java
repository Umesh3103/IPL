package com.bridgelabz.iplproblem;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;

public class IPLAnalyserTest {

	private static final String IPL_BATSMAN_CSV_FILE_PATH = "./src/test/java/resources/IPL2019FactsheetMostRuns.csv";
	private static final String IPL_BOWLERS_CSV_FILE_PATH = "./src/test/java/resources/IPL2019FactsheetMostWkts.csv";

	@Test
	public void givenIPLBatsmanCSVFile_ShouldReturnCorrectRecords() {
		try {
			IPLAnalyser iplAnalyser = new IPLAnalyser();
			int numOfRecords = iplAnalyser.loadIPLBatsmanData(IPL_BATSMAN_CSV_FILE_PATH);
			Assert.assertEquals(100, numOfRecords);
		} catch (IPLAnalyserException e) {
			System.out.println("Something went wrong, please recheck");
		}
	}

	@Test
	public void givenIPLBowlerCSVFile_ShouldReturnCorrectRecords() {
		try {
			IPLAnalyser iplAnalyser = new IPLAnalyser();
			int numOfRecords = iplAnalyser.loadIPLBowlerData(IPL_BOWLERS_CSV_FILE_PATH);
			Assert.assertEquals(99, numOfRecords);
		} catch (IPLAnalyserException e) {
			System.out.println("Something went wrong, please recheck");
		}
	}

	@Test
	public void givenIPLBatsmanCSVFile_WhenSortedByAverages_ShouldReturnSortedresult() {
		try {
			IPLAnalyser iplAnalyser = new IPLAnalyser();
			iplAnalyser.loadIPLBatsmanData(IPL_BATSMAN_CSV_FILE_PATH);
			String sortedIPLData = iplAnalyser.getAverageWiseSortedData();
			IPLBatsmanCSV[] batsmanCSV = new Gson().fromJson(sortedIPLData, IPLBatsmanCSV[].class);
			Assert.assertEquals("MS Dhoni", batsmanCSV[0].PLAYER);
		} catch (IPLAnalyserException e) {
			System.out.println("Something went wrong, please recheck");
		}
	}

	@Test
	public void givenIPLBatsmanCSVFile_WhenSortedByStrikeRate_ShouldReturnSortedresult() {
		try {
			IPLAnalyser iplAnalyser = new IPLAnalyser();
			iplAnalyser.loadIPLBatsmanData(IPL_BATSMAN_CSV_FILE_PATH);
			String sortedIPLData = iplAnalyser.getStrikeRateWiseSortedData();
			IPLBatsmanCSV[] batsmanCSV = new Gson().fromJson(sortedIPLData, IPLBatsmanCSV[].class);
			Assert.assertEquals("Ishant Sharma", batsmanCSV[0].PLAYER);
		} catch (IPLAnalyserException e) {
			System.out.println("Something went wrong, please recheck");
		}
	}
	
	@Test
	public void givenIPLBatsmanCSVFile_WhenSortedBy6sAnd4s_ShouldReturnSortedresult() {
		try {
			IPLAnalyser iplAnalyser = new IPLAnalyser();
			iplAnalyser.loadIPLBatsmanData(IPL_BATSMAN_CSV_FILE_PATH);
			String sortedIPLData = iplAnalyser.get6sAnd4sWiseSortedData();
			IPLBatsmanCSV[] batsmanCSV = new Gson().fromJson(sortedIPLData, IPLBatsmanCSV[].class);
			Assert.assertEquals("Andre Russell", batsmanCSV[0].PLAYER);
		} catch (IPLAnalyserException e) {
			System.out.println("Something went wrong, please recheck");
		}
	} 
	
	@Test
	public void givenIPLBatsmanCSVFile_WhenSortedByBestStrikeWith6sAnd4s_ShouldReturnSortedresult() {
		try {
			IPLAnalyser iplAnalyser = new IPLAnalyser();
			iplAnalyser.loadIPLBatsmanData(IPL_BATSMAN_CSV_FILE_PATH);
			String sortedIPLData = iplAnalyser.getStrikeRateWith6sAnd4sWiseSortedData();
			IPLBatsmanCSV[] batsmanCSV = new Gson().fromJson(sortedIPLData, IPLBatsmanCSV[].class);
			Assert.assertEquals("Ishant Sharma", batsmanCSV[0].PLAYER);
		} catch (IPLAnalyserException e) {
			System.out.println("Something went wrong, please recheck");
		}
	} 
	
	@Test
	public void givenIPLBatsmanCSVFile_WhenSortedByBestAverageWithBestStrike_ShouldReturnSortedresult() {
		try {
			IPLAnalyser iplAnalyser = new IPLAnalyser();
			iplAnalyser.loadIPLBatsmanData(IPL_BATSMAN_CSV_FILE_PATH);
			String sortedIPLData = iplAnalyser.getAverageAndStrikeRateWiseSortedData();
			IPLBatsmanCSV[] batsmanCSV = new Gson().fromJson(sortedIPLData, IPLBatsmanCSV[].class);
			Assert.assertEquals("MS Dhoni", batsmanCSV[0].PLAYER);
		} catch (IPLAnalyserException e) {
			System.out.println("Something went wrong, please recheck");
		}
	} 
	
	@Test
	public void givenIPLBatsmanCSVFile_WhenSortedByRunsWithBestAverage_ShouldReturnSortedresult() {
		try {
			IPLAnalyser iplAnalyser = new IPLAnalyser();
			iplAnalyser.loadIPLBatsmanData(IPL_BATSMAN_CSV_FILE_PATH);
			String sortedIPLData = iplAnalyser.getRunsAndAverageWiseSortedData();
			IPLBatsmanCSV[] batsmanCSV = new Gson().fromJson(sortedIPLData, IPLBatsmanCSV[].class);
			Assert.assertEquals("David Warner", batsmanCSV[0].PLAYER);
		} catch (IPLAnalyserException e) {
			System.out.println("Something went wrong, please recheck");
		}
	} 
	
	@Test
	public void givenIPLBowlerCSVFile_WhenSortedByAverage_ShouldReturnSortedresult() {
		try {
			IPLAnalyser iplAnalyser = new IPLAnalyser();
			iplAnalyser.loadIPLBowlerData(IPL_BOWLERS_CSV_FILE_PATH);
			String sortedIPLData = iplAnalyser.getTopBowlingAverageWiseSortedData();
			IPLBowlerCSV[] bowlerCSV = new Gson().fromJson(sortedIPLData, IPLBowlerCSV[].class);
			Assert.assertEquals("Anukul Roy", bowlerCSV[0].PLAYER);
		} catch (IPLAnalyserException e) {
			System.out.println("Something went wrong, please recheck");
		}
	} 
	
	@Test
	public void givenIPLBowlerCSVFile_WhenSortedByStrikeRate_ShouldReturnSortedresult() {
		try {
			IPLAnalyser iplAnalyser = new IPLAnalyser();
			iplAnalyser.loadIPLBowlerData(IPL_BOWLERS_CSV_FILE_PATH);
			String sortedIPLData = iplAnalyser.getTopBowlingStrikeRateWiseSortedData();
			IPLBowlerCSV[] bowlerCSV = new Gson().fromJson(sortedIPLData, IPLBowlerCSV[].class);
			Assert.assertEquals("Alzarri Joseph", bowlerCSV[0].PLAYER);
		} catch (IPLAnalyserException e) {
			System.out.println("Something went wrong, please recheck");
		}
	} 
	
	@Test
	public void givenIPLBowlerCSVFile_WhenSortedByEconomy_ShouldReturnSortedresult() {
		try {
			IPLAnalyser iplAnalyser = new IPLAnalyser();
			iplAnalyser.loadIPLBowlerData(IPL_BOWLERS_CSV_FILE_PATH);
			String sortedIPLData = iplAnalyser.getBowlingEconomyWiseSortedData();
			IPLBowlerCSV[] bowlerCSV = new Gson().fromJson(sortedIPLData, IPLBowlerCSV[].class);
			Assert.assertEquals("Shivam Dube", bowlerCSV[0].PLAYER);
		} catch (IPLAnalyserException e) {
			System.out.println("Something went wrong, please recheck");
		}
	} 
	
	@Test
	public void givenIPLBowlerCSVFile_WhenSortedByStrikeRateWith5wAnd4w_ShouldReturnSortedresult() {
		try {
			IPLAnalyser iplAnalyser = new IPLAnalyser();
			iplAnalyser.loadIPLBowlerData(IPL_BOWLERS_CSV_FILE_PATH);
			String sortedIPLData = iplAnalyser.getBowlingStrikeRateWith5wAnd4wWiseSortedData();
			IPLBowlerCSV[] bowlerCSV = new Gson().fromJson(sortedIPLData, IPLBowlerCSV[].class);
			Assert.assertEquals("Alzarri Joseph", bowlerCSV[0].PLAYER);
		} catch (IPLAnalyserException e) {
			System.out.println("Something went wrong, please recheck");
		}
	} 
	
	@Test
	public void givenIPLBowlerCSVFile_WhenSortedByBowlingAverageWithStrikeRate_ShouldReturnSortedresult() {
		try {
			IPLAnalyser iplAnalyser = new IPLAnalyser();
			iplAnalyser.loadIPLBowlerData(IPL_BOWLERS_CSV_FILE_PATH);
			String sortedIPLData = iplAnalyser.getBowlingAverageWithStrikeRateWiseSortedData();
			IPLBowlerCSV[] bowlerCSV = new Gson().fromJson(sortedIPLData, IPLBowlerCSV[].class);
			Assert.assertEquals("Anukul Roy", bowlerCSV[0].PLAYER);
		} catch (IPLAnalyserException e) {
			System.out.println("Something went wrong, please recheck");
		}
	}
	
	@Test
	public void givenIPLBowlerCSVFile_WhenSortedByWicketsWithBestAverage_ShouldReturnSortedresult() {
		try {
			IPLAnalyser iplAnalyser = new IPLAnalyser();
			iplAnalyser.loadIPLBowlerData(IPL_BOWLERS_CSV_FILE_PATH);
			String sortedIPLData = iplAnalyser.getWicketsWithAverageWiseSortedData();
			IPLBowlerCSV[] bowlerCSV = new Gson().fromJson(sortedIPLData, IPLBowlerCSV[].class);
			Assert.assertEquals("Imran Tahir", bowlerCSV[0].PLAYER);
		} catch (IPLAnalyserException e) {
			System.out.println("Something went wrong, please recheck");
		}
	}
	
	@Test
	public void givenIPLBowlerCSVFile_WhenSortedByBattingAndBowlingAverage_ShouldReturnSortedresult() {
		try {
			IPLAnalyser iplAnalyser = new IPLAnalyser();
			iplAnalyser.loadIPLBowlerData(IPL_BOWLERS_CSV_FILE_PATH);
			iplAnalyser.loadIPLBatsmanData(IPL_BATSMAN_CSV_FILE_PATH);
			String result = iplAnalyser.getBattingAndBowlingAverageWiseSortedData();
			Assert.assertEquals("Andre Russell", result);
		} catch (IPLAnalyserException e) {
			System.out.println("Something went wrong, please recheck");
		}
	}
	
	@Test
	public void givenIPLBowlerCSVFile_WhenSortedByRunsAndWickets_ShouldReturnSortedresult() {
		try {
			IPLAnalyser iplAnalyser = new IPLAnalyser();
			iplAnalyser.loadIPLBowlerData(IPL_BOWLERS_CSV_FILE_PATH);
			iplAnalyser.loadIPLBatsmanData(IPL_BATSMAN_CSV_FILE_PATH);
			String result = iplAnalyser.getRunsAndWicketWiseSortedData();
			Assert.assertEquals("Andre Russell", result);
		} catch (IPLAnalyserException e) {
			System.out.println("Something went wrong, please recheck");
		}
	}
	
	@Test
	public void givenIPLBatsmanCSVFile_WhenSortedByMaximum100sWithBattingAverage_ShouldReturnSortedresult() {
		try {
			IPLAnalyser iplAnalyser = new IPLAnalyser();
			iplAnalyser.loadIPLBatsmanData(IPL_BATSMAN_CSV_FILE_PATH);
			String sortedIPLData = iplAnalyser.getHundredsAndAverageWiseSortedData();
			IPLBatsmanCSV[] batsmanCSV = new Gson().fromJson(sortedIPLData, IPLBatsmanCSV[].class);
			Assert.assertEquals("David Warner", batsmanCSV[0].PLAYER);
		} catch (IPLAnalyserException e) {
			System.out.println("Something went wrong, please recheck");
		}
	} 
}
