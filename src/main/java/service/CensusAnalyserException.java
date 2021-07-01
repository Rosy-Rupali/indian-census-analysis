/***************************************************************************
 * Purpose : CensusAnalyser Exception Class to throw CensusAnalyser Exception messages.
 * @author Rosy Rupali
 * @Since 30-06-2021
 * @Version 1.0 
 ***************************************************************************/
package service;
public class CensusAnalyserException extends Exception {

	public enum CensusExceptionType {
		CENSUS_FILE_PROBLEM, INCORRECT_TYPE_ISSUE, DELIMITER_ISSUE, INCORRECT_HEADER
	}

	public CensusExceptionType exceptionType;

	public CensusAnalyserException(CensusExceptionType exceptionType, String message) {
		super(message);
		this.exceptionType = exceptionType;
	}

}
