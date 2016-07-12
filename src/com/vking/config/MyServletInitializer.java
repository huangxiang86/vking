package com.vking.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.vking.web.servlet.*;

import org.springframework.orm.hibernate4.support.OpenSessionInViewFilter;
import org.springframework.web.WebApplicationInitializer;

public class MyServletInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext)
			throws ServletException {
		ServletRegistration proxyServlet = servletContext.addServlet(
				"myServlet", ProxyServlet.class);
		proxyServlet.addMapping("/custom");

		FilterRegistration hibernateLazyFilter = servletContext.addFilter(
				"hibernateLazyFilter", OpenSessionInViewFilter.class);
		hibernateLazyFilter.addMappingForUrlPatterns(null, true, "/custom");

	}

}
