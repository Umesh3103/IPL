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

	@Override
	public String toString() {
		return "IPLBatsmanCSV [PLAYER=" + PLAYER + ", Runs=" + Runs + ", Avg=" + Avg + ", SR=" + SR + "]";
	}

}
