package com.bridgelabz.iplproblem;

import com.opencsv.bean.CsvBindByName;

public class IPLBatsmanCSV {

	@CsvBindByName(column = "PLAYER", required =true)
	public String PLAYER;
	
	@CsvBindByName(column = "Runs", required =true)
	public int Runs;
	
	@CsvBindByName(column = "Avg", required =true)
	public Double Avg;
	
	@CsvBindByName(column = "SR", required =true)
	public Double SR;

	@CsvBindByName(column = "Fours", required =true)
	public Double Fours;
	
	@CsvBindByName(column = "Sixes", required =true)
	public Double Sixes;
	
	@CsvBindByName(column = "BF", required =true)
	public Double BF;
	
	@CsvBindByName(column = "Hundreds", required =true)
	public Double Hundreds;
	
	@CsvBindByName(column = "Fifties", required =true)
	public Double Fifties;

	@Override
	public String toString() {
		return "IPLBatsmanCSV [PLAYER=" + PLAYER + ", Runs=" + Runs + ", Avg=" + Avg + ", SR=" + SR + ", Fours=" + Fours
				+ ", Sixes=" + Sixes + ", BF=" + BF + "]";
	}
}
