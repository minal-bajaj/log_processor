package com.minal.logProcessor.io;

import java.io.IOException;

public interface TailFCallback {
	public void newLine(String line) throws IOException;
}
