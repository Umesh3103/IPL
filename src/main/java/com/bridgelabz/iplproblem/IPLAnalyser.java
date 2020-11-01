package com.bridgelabz.iplproblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.bl.creatingJar.CSVBuilderException;
import com.bl.creatingJar.CSVBuilderFactory;
import com.bl.creatingJar.ICSVBuilder;

public class IPLAnalyser {

	List<IPLBatsmanCSV> batsmanCSVList = null;
	List<IPLBowlerCSV> bowlerCSVList = null;
	
	// loading batsman Csv file
	public int loadIPLBatsmanData(String csvFilePath) throws IPLAnalyserException {
		try(Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));){
			ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
			batsmanCSVList = csvBuilder.getCSVFileList(reader, IPLBatsmanCSV.class);
			return batsmanCSVList.size();
		} catch(IOException e){
			throw new IPLAnalyserException(e.getMessage(),IPLAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
		} catch(CSVBuilderException e){
			throw new IPLAnalyserException(e.getMessage(),e.type.name());
		}
	}
	
	// loading bowler Csv file
	public int loadIPLBowlerData(String csvFilePath) throws IPLAnalyserException {
		try(Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));){
			ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
			bowlerCSVList = csvBuilder.getCSVFileList(reader, IPLBowlerCSV.class);
			return bowlerCSVList.size();
		} catch(IOException e){
			throw new IPLAnalyserException(e.getMessage(),IPLAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
		} catch(CSVBuilderException e){
			throw new IPLAnalyserException(e.getMessage(),e.type.name());
		}
	}
}
