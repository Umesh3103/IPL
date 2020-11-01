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
}
