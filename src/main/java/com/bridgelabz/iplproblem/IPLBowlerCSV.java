package com.bridgelabz.iplproblem;

import com.opencsv.bean.CsvBindByName;

public class IPLBowlerCSV {

	@CsvBindByName(column = "PLAYER", required =true)
	public String PLAYER;
	
	@CsvBindByName(column = "Wkts", required =true)
	public int Runs;
	
	@CsvBindByName(column = "Econ", required =true)
	public Double Econ;
	
	@CsvBindByName(column = "Avg", required =true)
	public Double Avg;
	
	@CsvBindByName(column = "SR", required =true)
	public Double SR;

	@CsvBindByName(column = "fourWickets", required =true)
	public Double fourWickets;
	
	@CsvBindByName(column = "fiveWickets", required =true)
	public Double fiveWickets;
	
	@CsvBindByName(column = "Wkts", required =true)
	public Double Wkts;
	
	@Override
	public String toString() {
		return "IPLBowlerCSV [PLAYER=" + PLAYER + ", Runs=" + Runs + ", Econ=" + Econ + ", Avg=" + Avg + ", SR=" + SR
				+ "]";
	}
}
