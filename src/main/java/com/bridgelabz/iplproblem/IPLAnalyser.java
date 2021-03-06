package com.bridgelabz.iplproblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.bl.creatingJar.CSVBuilderException;
import com.bl.creatingJar.CSVBuilderFactory;
import com.bl.creatingJar.ICSVBuilder;
import com.google.gson.Gson;

public class IPLAnalyser {

	List<IPLBatsmanCSV> batsmanCSVList = null;
	List<IPLBowlerCSV> bowlerCSVList = null;

	// loading batsman Csv file
	public int loadIPLBatsmanData(String csvFilePath) throws IPLAnalyserException {
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
			ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
			batsmanCSVList = csvBuilder.getCSVFileList(reader, IPLBatsmanCSV.class);
			return batsmanCSVList.size();
		} catch (IOException e) {
			throw new IPLAnalyserException(e.getMessage(), IPLAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
		} catch (CSVBuilderException e) {
			throw new IPLAnalyserException(e.getMessage(), e.type.name());
		}
	}

	// loading bowler Csv file
	public int loadIPLBowlerData(String csvFilePath) throws IPLAnalyserException {
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
			ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
			bowlerCSVList = csvBuilder.getCSVFileList(reader, IPLBowlerCSV.class);
			return bowlerCSVList.size();
		} catch (IOException e) {
			throw new IPLAnalyserException(e.getMessage(), IPLAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
		} catch (CSVBuilderException e) {
			throw new IPLAnalyserException(e.getMessage(), e.type.name());
		}
	}

	// Sorting the list according to batting average in descending order
	public String getAverageWiseSortedData() {
		List<IPLBatsmanCSV> averageWiseSortedList = batsmanCSVList.stream()
				.sorted(Comparator.comparing(batsman -> batsman.Avg))
				.collect(Collectors.toList());
		Collections.reverse(averageWiseSortedList);
		return new Gson().toJson(averageWiseSortedList);
	}

	// Sorting the list according to strike rate in descending order
	public String getStrikeRateWiseSortedData() {
		List<IPLBatsmanCSV> strikeRateWiseSortedList = batsmanCSVList.stream()
				.sorted(Comparator.comparing(batsman -> batsman.SR))
				.collect(Collectors.toList());
		Collections.reverse(strikeRateWiseSortedList);
		return new Gson().toJson(strikeRateWiseSortedList);
	}

	// Sorting the list according to maximum number of 6s and 4s
	public String get6sAnd4sWiseSortedData() {
		Comparator<IPLBatsmanCSV> comparator = Comparator.comparing(batsman -> batsman.Sixes);
		List<IPLBatsmanCSV> sixesAndFoursWiseSortedList= batsmanCSVList.stream()
				.sorted(comparator.thenComparing(batsman -> batsman.Fours))
				.collect(Collectors.toList());
		Collections.reverse(sixesAndFoursWiseSortedList);
		return new Gson().toJson(sixesAndFoursWiseSortedList);
	}

	// Sorting the list according to strike rate with 6s and 4s
	public String getStrikeRateWith6sAnd4sWiseSortedData() {
		List<IPLBatsmanCSV> strikeRateWithSixesAndFoursWiseSortedList= batsmanCSVList.stream()
				.sorted(Comparator.comparing(batsman -> ((batsman.Sixes*6 + batsman.Fours*4)/batsman.BF)*100))
				.collect(Collectors.toList());
		Collections.reverse(strikeRateWithSixesAndFoursWiseSortedList);
		return new Gson().toJson(strikeRateWithSixesAndFoursWiseSortedList);
	}

	// Sorting the list according to best average and strike rate 
	public String getAverageAndStrikeRateWiseSortedData() {
		Comparator<IPLBatsmanCSV> comparator = Comparator.comparing(batsman -> batsman.Avg);
		List<IPLBatsmanCSV> averageAndStrikeRateWiseSortedList = batsmanCSVList.stream()
				.sorted(comparator.thenComparing(batsman -> batsman.SR))
				.collect(Collectors.toList());
		Collections.reverse(averageAndStrikeRateWiseSortedList);
		return new Gson().toJson(averageAndStrikeRateWiseSortedList);
	}

	// Sorting the list according to runs and best average
	public String getRunsAndAverageWiseSortedData() {
		Comparator<IPLBatsmanCSV> comparator = Comparator.comparing(batsman -> batsman.Runs);
		List<IPLBatsmanCSV> runsAndAverageWiseSortedList = batsmanCSVList.stream()
				.sorted(comparator.thenComparing(batsman -> batsman.Avg))
				.collect(Collectors.toList());
		Collections.reverse(runsAndAverageWiseSortedList);
		return new Gson().toJson(runsAndAverageWiseSortedList);
	}

	// Sorting the list according to best bowling average
	public String getTopBowlingAverageWiseSortedData() {
		List<IPLBowlerCSV> averageWiseSortedList = bowlerCSVList.stream()
				.filter(bowler -> bowler.Avg>0)
				.sorted(Comparator.comparing(bowler -> bowler.Avg))
				.collect(Collectors.toList());
		return new Gson().toJson(averageWiseSortedList);
	}

	// Sorting the list according to best bowling strike rate
	public String getTopBowlingStrikeRateWiseSortedData() {
		List<IPLBowlerCSV> strikeRateWiseSortedList = bowlerCSVList.stream()
				.filter(bowler -> bowler.SR>0)
				.sorted(Comparator.comparing(bowler -> bowler.SR))
				.collect(Collectors.toList());
		return new Gson().toJson(strikeRateWiseSortedList);
	}

	// Sorting the list according to best bowling Economy
	public String getBowlingEconomyWiseSortedData() {
		List<IPLBowlerCSV> bowlingEconomyWiseSortedList = bowlerCSVList.stream()
				.sorted(Comparator.comparing(bowler -> bowler.Econ))
				.collect(Collectors.toList());
		return new Gson().toJson(bowlingEconomyWiseSortedList);
	}

	// Sorting the list according to best strike rate with 5w and 4w
	public String getBowlingStrikeRateWith5wAnd4wWiseSortedData() {
		Comparator<IPLBowlerCSV> comparator = Comparator.comparing(bowler -> bowler.SR);
		List<IPLBowlerCSV> bowlingStrikeRateWith5wAnd4wWiseSortedList = bowlerCSVList.stream()
				.filter(bowler -> bowler.SR>0)
				.sorted(comparator.thenComparing(bowler -> bowler.fiveWickets))
				.collect(Collectors.toList());
		return new Gson().toJson(bowlingStrikeRateWith5wAnd4wWiseSortedList);
	}

	// Sorting the list according to best bowling average with best strike rate
	public String getBowlingAverageWithStrikeRateWiseSortedData() {
		Comparator<IPLBowlerCSV> comparator = Comparator.comparing(bowler -> bowler.Avg);
		List<IPLBowlerCSV> bowlingAverageWithStrikeRateWiseSortedList = bowlerCSVList.stream()
				.filter(bowler -> bowler.SR>0)
				.sorted(comparator.thenComparing(bowler -> bowler.SR))
				.collect(Collectors.toList());
		return new Gson().toJson(bowlingAverageWithStrikeRateWiseSortedList);
	}

	// Sorting the list according to maximum wicket taken with best bowling average
	public String getWicketsWithAverageWiseSortedData() {
		Comparator<IPLBowlerCSV> comparator = Comparator.comparing(bowler -> bowler.Wkts);
		List<IPLBowlerCSV> bowlingAverageWithStrikeRateWiseSortedList = bowlerCSVList.stream()
				.filter(bowler -> bowler.Avg>0)
				.sorted(comparator.thenComparing(bowler -> bowler.Avg).reversed())
				.collect(Collectors.toList());
		return new Gson().toJson(bowlingAverageWithStrikeRateWiseSortedList);
	}

	// Finding a player with best batting as well as bowling average 
	public String getBattingAndBowlingAverageWiseSortedData() {
		IPLBatsmanCSV[] sortedArrayByBattingAverage = (IPLBatsmanCSV[]) new Gson().fromJson(this.getAverageWiseSortedData(), IPLBatsmanCSV[].class);
		IPLBowlerCSV[] sortedArrayByBowlingAverage = (IPLBowlerCSV[]) new Gson().fromJson(this.getTopBowlingAverageWiseSortedData(), IPLBowlerCSV[].class);
		return this.allRounder(sortedArrayByBattingAverage, sortedArrayByBowlingAverage);
	}

	// Findind a player with most runs as well as most wickets
	public String getRunsAndWicketWiseSortedData() {
		IPLBatsmanCSV[] sortedArrayByMostRuns = (IPLBatsmanCSV[]) new Gson().fromJson(this.getRunsAndAverageWiseSortedData(), IPLBatsmanCSV[].class);
		IPLBowlerCSV[] sortedArrayByMostWickets = (IPLBowlerCSV[]) new Gson().fromJson(this.getWicketsWithAverageWiseSortedData(), IPLBowlerCSV[].class);
		return this.allRounder(sortedArrayByMostRuns, sortedArrayByMostWickets);
	}
	
	// Getting the allrounder with best bowling and betting performance 
	private String allRounder(IPLBatsmanCSV[] sortedArrayByBattingData, IPLBowlerCSV[] sortedArrayByBowlingData) {
		List<String> averageList = new ArrayList(); 
		for(IPLBatsmanCSV runs: sortedArrayByBattingData){
			for(IPLBowlerCSV ball: sortedArrayByBowlingData){
				if(runs.PLAYER.equals(ball.PLAYER))
					averageList.add(runs.PLAYER);
			}
		}
		return averageList.get(0);
	}

	// Finding a player with maximum number of hundreds and best batting average
	public String getHundredsAndAverageWiseSortedData() {
		Comparator<IPLBatsmanCSV> comparator = Comparator.comparing(batsman -> batsman.Hundreds);
		List<IPLBatsmanCSV> HundredsAndAverageWiseSortedList= batsmanCSVList.stream()
				.sorted(comparator.thenComparing(batsman -> batsman.Avg))
				.collect(Collectors.toList());
		Collections.reverse(HundredsAndAverageWiseSortedList);
		return new Gson().toJson(HundredsAndAverageWiseSortedList);
	}

	// Finding a player with zero 100s and zero 50s with best batting average
	public String getZeroHundredsAndFiftiesWithAverageWiseSortedData() {
		List<IPLBatsmanCSV> HundredsAndAverageWiseSortedList= batsmanCSVList.stream()
				.filter(batsman -> (batsman.Hundreds==0 && batsman.Fifties==0))
				.sorted(Comparator.comparing(batsman -> batsman.Avg))
				.collect(Collectors.toList());
		Collections.reverse(HundredsAndAverageWiseSortedList);
		return new Gson().toJson(HundredsAndAverageWiseSortedList);
	}
}
