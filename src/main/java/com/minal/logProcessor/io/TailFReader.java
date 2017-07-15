package com.minal.logProcessor.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TailFReader {
	
	final BufferedReader reader;
	
	public TailFReader(String _file) throws FileNotFoundException {
		this.reader = new BufferedReader(new FileReader(_file));
	}
	
	public void tailF(TailFCallback callback) throws IOException, InterruptedException {
		
		String line = null;
		
		while (true) {
			
			if ((line = this.reader.readLine()) == null) {
				Thread.sleep(1000);
				continue;
			}
			
			callback.newLine(line);
		}
	}
	
	public void close() throws IOException {
		this.reader.close();
	}
}
