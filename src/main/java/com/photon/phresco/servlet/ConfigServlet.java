package com.photon.phresco.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ConfigReader reader;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("");
		try {
			reader = new ConfigReader(resourceAsStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		try {
			String configType = request.getParameter("configType");
			String currentEnv = System.getProperty("SERVER_ENVIRONMENT");
			String configJson = reader.getConfigAsJSON(currentEnv, configType);
			response.setContentType("application/json");		
			PrintWriter out = response.getWriter();
			out.print(configJson);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}