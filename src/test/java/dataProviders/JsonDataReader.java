package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import managers.FileReaderManager;
import testDatatypes.CardDetails;

import com.google.gson.Gson;

public class JsonDataReader {
	private final String filePath;
	private List<CardDetails> cardDetails;

	public JsonDataReader(String fileName) {
		filePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + fileName+".json";
		cardDetails = getCardData();
	}

	private List<CardDetails> getCardData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(filePath));
			CardDetails[] details = gson.fromJson(bufferReader, CardDetails[].class);
			return Arrays.asList(details);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + filePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}
	
	public final CardDetails getCardDetails() {
		return cardDetails.stream().findAny().get();
	}
	

}
