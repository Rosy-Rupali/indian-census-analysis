/************************************************************
 * Purpose : To perform required operations on CSV data
 * @author Rosy Rupali
 * @Version 1.0
 * @since 30-06-2021
 *
 ************************************************************/
package service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;
import org.apache.commons.lang3.exception.ExceptionUtils;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import model.CSVStatesCensus;
import service.CensusAnalyserException.CensusExceptionType;

public class StateCensusAnalyser {

	/**
	 * @param csvfilePath
	 * @return number of entries in census CSV file
	 * @throws CensusAnalyserException
	 */
	public int loadStateCensusData(String csvfilePath) throws CensusAnalyserException {
		try {
			Reader reader;
			reader = Files.newBufferedReader(Paths.get(csvfilePath));
			CsvToBeanBuilder<CSVStatesCensus> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(CSVStatesCensus.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<CSVStatesCensus> csvToBean = csvToBeanBuilder.build();
			Iterator<CSVStatesCensus> csvStateCensusIterator = csvToBean.iterator();
			Iterable<CSVStatesCensus> csvStateCensusIterable = () -> csvStateCensusIterator;
			int numberOfEntries = (int) StreamSupport.stream(csvStateCensusIterable.spliterator(), false).count();
			return numberOfEntries;
		} catch (IOException e) {
			throw new CensusAnalyserException(CensusAnalyserException.CensusExceptionType.CENSUS_FILE_PROBLEM,
					"Incorrect File");
		} catch (RuntimeException e) {
			if (ExceptionUtils.indexOfType(e, CsvDataTypeMismatchException.class) != -1) {
				throw new CensusAnalyserException(CensusAnalyserException.CensusExceptionType.INCORRECT_TYPE_ISSUE,
						"Incorrect Type");
			} else if (ExceptionUtils.indexOfType(e, CsvRequiredFieldEmptyException.class) != -1) {
				if (e.getMessage().equalsIgnoreCase("Error capturing CSV header")) {
					throw new CensusAnalyserException(CensusExceptionType.INCORRECT_HEADER, "Incorrect header");
				} else {
					throw new CensusAnalyserException(CensusExceptionType.DELIMITER_ISSUE, "Incorrect Delimiter Issue");
				}
			} else {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}
	}
}
