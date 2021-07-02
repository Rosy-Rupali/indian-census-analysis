/************************************************************************
 * Purpose : Pojo model for State code CSV file
 * Entries in state code CSV file will be made as objects of this class
 * @author Rosy Rupali
 * @Since 30-06-2021
 * @Version 1.0
 *********************************************************************/
package model;

import com.opencsv.bean.CsvBindByName;

public class CSVStates {
	@CsvBindByName(column = "state name")
	public String stateName;

	@CsvBindByName(column = "state code")
	public String stateCode;
	@CsvBindByName(column = "sr no")
	public int srNo;
	@CsvBindByName(column = "tin")
	public int tin;

	public CSVStates() {
	}

	public CSVStates(String stateName, String stateCode, int srNo, int tin) {
		this.stateName = stateName;
		this.stateCode = stateCode;
		this.srNo = srNo;
		this.tin = tin;
	}
	

	


}
