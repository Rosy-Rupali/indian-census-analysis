/************************************************************
 * Purpose : To perform required operations on CSV data
 * @author Rosy Rupali
 * @Version 1.0
 * @since 30-06-2021
 *
 ************************************************************/
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public double getPopulation() {
		return population;
	}

	public void setPopulation(double population) {
		this.population = population;
	}

	public double getAreaPerSqKm() {
		return areaPerSqKm;
	}

	public void setAreaPerSqKm(double areaPerSqKm) {
		this.areaPerSqKm = areaPerSqKm;
	}

	public double getDensityPerSqKm() {
		return densityPerSqKm;
	}

	public void setDensityPerSqKm(double densityPerSqKm) {
		this.densityPerSqKm = densityPerSqKm;
	}

}
