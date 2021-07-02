/************************************************************************
 * Purpose : Pojo model for State census CSV file
 * Entries in state code CSV file will be made as objects of this class
 * @author Rosy Rupali
 * @Since 30-06-2021
 * @Version 1.1
 *********************************************************************/
package model;

import com.opencsv.bean.CsvBindByName;

public class CSVStatesCensus {
	@CsvBindByName(column = "state")
	private String state;
	@CsvBindByName(column = "population")
	private double population;
	@CsvBindByName(column = "areaPerSqKm")
	private double areaPerSqKm;
	@CsvBindByName(column = "densityPerSqKm")
	private double densityPerSqKm;

	public CSVStatesCensus(String state, double population, double areaPerSqKm, double densityPerSqKm) {
		this.state = state;
		this.population = population;
		this.areaPerSqKm = areaPerSqKm;
		this.densityPerSqKm = densityPerSqKm;
	}

	public CSVStatesCensus() {

	}
}
