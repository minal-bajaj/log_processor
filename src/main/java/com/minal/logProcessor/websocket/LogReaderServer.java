package com.minal.logProcessor.websocket;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.minal.logProcessor.AppPath;
import com.minal.logProcessor.io.TailFReader;

@ServerEndpoint("/logs/tailf")
public class LogReaderServer {

	@OnOpen
	public void open(Session session) {
		System.out.println("opened.");
	}

	@OnClose
	public void close(Session session) {
		System.out.println("closed.");
	}

	@OnError
	public void onError(Throwable error) {
	}

	@OnMessage
	public void handleMessage(String message, Session session) {
		try {
			TailFReader reader = new TailFReader(AppPath.getAbsolutePath(message));
			reader.tailF(new WSTailfCallback(session.getBasicRemote()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}