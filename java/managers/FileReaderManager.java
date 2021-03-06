package managers;

import dataProviders.ConfigFileReader;
import dataProviders.ExcelReader;
import dataProviders.JsonDataReader;

public class FileReaderManager {
	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;
	private static JsonDataReader jsonDataReader;
	private static ExcelReader excelReader;
	
	private FileReaderManager() {
	}

	 public static FileReaderManager getInstance( ) {
	      return fileReaderManager;
	 }

	 public ConfigFileReader getConfigReader() {
		 return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
	 }
	 
	 public JsonDataReader getJsonReader(String fileName){
		 return (jsonDataReader == null) ? new JsonDataReader(fileName) : jsonDataReader;
	}
	 
	 public ExcelReader getExcelReader(){
		 return (excelReader == null) ? new ExcelReader() : excelReader;
	}
}
