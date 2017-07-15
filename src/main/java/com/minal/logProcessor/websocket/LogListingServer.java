package com.minal.logProcessor.websocket;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.minal.logProcessor.AppPath;

@Path("/logs/")
public class LogListingServer {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String[] list() {
		File logsDirectory = new File(AppPath.logsDirectory);
		return logsDirectory.list();
	}
}
