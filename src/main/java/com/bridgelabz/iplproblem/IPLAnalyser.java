package com.bridgelabz.iplproblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
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
}
