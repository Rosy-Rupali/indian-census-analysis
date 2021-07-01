/************************************************************
 * Purpose : Test cases required to perform operations on CSV data
 * @author Rosy Rupali
 * @Version 1.0
 * @since 30-06-2021
 *
 ************************************************************/
package javapractice.censusanalysis;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import service.CensusAnalyserException;
import service.CensusAnalyserException.CensusExceptionType;
import service.StateCensusAnalyser;

public class StateCensusAnalyserTest {
	StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();

	public static final String CENSUS_CSV_FILE = "C:\\Users\\HEMANT\\eclipse-workspace\\censusanalysis\\src\\resources\\IndianStateCensus.csv";
	public static final String INCORRECT_FILE = "C:\\Users\\HEMANT\\eclipse-workspace\\censusanalysis\\src\\resources\\Contacts.txt";
	public static final String INCORRECT_CSV_FILE = "C:\\Users\\HEMANT\\eclipse-workspace\\censusanalysis\\src\\resources\\Contacts.csv";
	public static final String WRONGDELIMITER_CENSUS_CSV = "C:\\Users\\HEMANT\\eclipse-workspace\\censusanalysis\\src\\resources\\stateCensusDelimiter.csv";
	public static final String INCORRECT_HEADER_CSV = "C:\\Users\\HEMANT\\eclipse-workspace\\censusanalysis\\src\\resources\\stateCensusDelimiter.csv";

	@Test
	public void givenIndiaCensusDataCsvShouldReturnExactCount() {
		try {
			int numberOfEntries = stateCensusAnalyser.loadStateCensusData(CENSUS_CSV_FILE);
			Assert.assertEquals(29, numberOfEntries);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void GivenTheStateCensusCsvFile_IfDoesntExist_ShouldThrowCensusAnalyserException() throws IOException {
		try {
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			stateCensusAnalyser.loadStateCensusData(INCORRECT_FILE);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusExceptionType.CENSUS_FILE_PROBLEM, e.exceptionType);
		}
	}

	@Test
	public void givenWrongTypeCSVFile_ShouldThrowExceptionOfType_IncorrectTypeOfCSV() {
		try {
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			stateCensusAnalyser.loadStateCensusData(INCORRECT_CSV_FILE);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusExceptionType.INCORRECT_TYPE_ISSUE, e.exceptionType);
		}
	}

	@Test
	public void givenCsvFile_IFDelimiterIsWrong_ShouldThrowExceptionOfDelimiterISSUE() {
		try {
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			stateCensusAnalyser.loadStateCensusData(WRONGDELIMITER_CENSUS_CSV);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusExceptionType.DELIMITER_ISSUE, e.exceptionType);
		}
	}

	@Test
	public void givenCsvFile_WrongHeaderShouldThrowExceptionOfTypeIncorrectHeader() {
		try {
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			stateCensusAnalyser.loadStateCensusData(INCORRECT_HEADER_CSV);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusExceptionType.INCORRECT_HEADER, e.exceptionType);
		}
	}
}
