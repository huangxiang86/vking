package com.vking.web.servlet;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ProxyServlet extends HttpServlet {

	private String targetBean;
	private Servlet proxyServlet;

	
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		proxyServlet.service(req, res);
	}

	@Override
	public void init() throws ServletException {
		this.targetBean = getServletName();
		getServletBean();
		proxyServlet.init(getServletConfig());
	}

	private void getServletBean() {
		WebApplicationContext wac = WebApplicationContextUtils
				.getRequiredWebApplicationContext(getServletContext());
		this.proxyServlet = (Servlet) wac.getBean(targetBean);
	}
}
