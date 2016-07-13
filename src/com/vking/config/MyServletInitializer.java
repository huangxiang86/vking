package com.vking.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;
import com.vking.web.servlet.*;

import org.apache.catalina.servlets.DefaultServlet;
import org.springframework.orm.hibernate4.support.OpenSessionInViewFilter;
import org.springframework.web.WebApplicationInitializer;

public class MyServletInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		ServletRegistration proxyServlet = servletContext.addServlet("myServlet", ProxyServlet.class);
		proxyServlet.addMapping("/custom");

		try {
			genericStaticSourceServlet(servletContext);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		FilterRegistration hibernateLazyFilter = servletContext.addFilter("hibernateLazyFilter",
				OpenSessionInViewFilter.class);
		hibernateLazyFilter.addMappingForUrlPatterns(null, true, "/custom");
		
	}

	private void genericStaticSourceServlet(ServletContext servletContext) throws FileNotFoundException, IOException {
		String realPath = servletContext.getRealPath("/");
		StringBuffer servletPropertiesPath = new StringBuffer(realPath);
		servletPropertiesPath.append("/").append("config").append("/").append("servlet").append("/").append("servlet.properties");
		Properties servletProperties = new Properties();
		servletProperties.load(new FileInputStream(servletPropertiesPath.toString()));
		String defalutServletMappings = servletProperties.getProperty("servlet.default");
		System.out.println("Defalut Servlet Mapping Loading:" + defalutServletMappings);
		String[] defalutServletMappingList = defalutServletMappings.split(";");
		ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
		System.out.println("defaultServlet:" + defaultServlet.getName());
		defaultServlet.addMapping(defalutServletMappingList);
	}

}
