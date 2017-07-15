package com.minal.logProcessor.websocket;

import java.io.IOException;

import javax.websocket.RemoteEndpoint.Basic;

import com.minal.logProcessor.io.TailFCallback;

public class WSTailfCallback implements TailFCallback {

	private Basic endPoint;
	
	public WSTailfCallback(Basic endPoint) {
		this.endPoint = endPoint;
	}
	
	@Override
	public void newLine(String line) throws IOException {
		this.endPoint.sendText(line);
	}
}
