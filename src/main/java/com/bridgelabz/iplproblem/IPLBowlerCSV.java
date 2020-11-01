package com.bridgelabz.iplproblem;

import com.opencsv.bean.CsvBindByName;

public class IPLBowlerCSV {

	@CsvBindByName(column = "PLAYER", required =true)
	public String PLAYER;
	
	@CsvBindByName(column = "Wkts", required =true)
	public int Runs;
	
	@CsvBindByName(column = "Econ", required =true)
	public Double Econ;
}
