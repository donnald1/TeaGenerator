package com.db.DbTest;

import java.io.IOException;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App {
	private static final Logger LOG = LogManager.getLogger(App.class);

	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(50);
		for (int i=0; i<2000; i++) {
			executor.execute(new GenerateTea());
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
			Thread.yield();
        }
		LOG.info("Elapsed time: " + (System.currentTimeMillis()-start));
	}

	

}
