package com.db.DbTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class InputSource {

	public static List<String> getInputList(String fileNameParam) throws IOException {
		List<String> inputList = new ArrayList<String>();
		File file = new File(fileNameParam);
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			inputList.add(line);
		}
		fileReader.close();
		return inputList;
	}
	
	public static String getInput(List<String> inputList) {
		Collections.shuffle(inputList);
		String inputString = inputList.get(0);
		return inputString;
	}
	
	public static LocalDate randomDate(int a) {
		long minDay = 0L;
		long maxDay = 0L;
		if (a == 0) {
			minDay = LocalDate.of(2018, 1, 1).toEpochDay();
		    maxDay = LocalDate.of(2018, 12, 31).toEpochDay();
		}else if (a == 1) {
			minDay = LocalDate.of(2019, 1, 1).toEpochDay();
		    maxDay = LocalDate.of(2023, 12, 31).toEpochDay();
		}
		
	    long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
	    LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
	    
	    return randomDate;
	}
}
