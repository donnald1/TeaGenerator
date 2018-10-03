package com.db.DbTest;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jdbi.v3.core.Handle;

import com.db.dbconnection.Connection;


public class GenerateTea implements Runnable {
	private static final Logger LOG = LogManager.getLogger(GenerateTea.class);
	@Override
	public void run() {
		LOG.info("BEGIN");
		try {
			insertTea();
			Thread.sleep(20);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		LOG.info("END");
	}

	public static void insertTea() throws IOException {
		
		Handle handle = Connection.get().getDBI().open();
		List<String> teaBrandList = InputSource.getInputList("TeaBrand.txt");
		List<String> teaTypeList = InputSource.getInputList("TeaType.txt");

		handle.createUpdate(
				"INSERT INTO tea " + "(brand, " + "brand_type, " + "price, " + "manufacture_date, " + "expiry_date) "
						+ "VALUES (" + ":brand, " + ":brand_type," + ":price," + ":manufacture_date," + ":expiry_date)")
				.bind("brand", InputSource.getInput(teaBrandList)).bind("brand_type", InputSource.getInput(teaTypeList))
				.bind("price", (Math.random() * ((200 - 50) + 1)) + 50)
				.bind("manufacture_date", InputSource.randomDate(0)).bind("expiry_date", InputSource.randomDate(1))
				.execute();
		handle.close();
	}

}
