package com.vking.config;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.vking.config.spring.RootConfig;
import com.vking.config.web.WebConfig;

public class SpringMVCWebApplnitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {RootConfig.class};
	}
	
	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	@Override
	protected void customizeRegistration(Dynamic registration) {
		super.customizeRegistration(registration);
	}
	
	
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		super.onStartup(servletContext);
//		ServletRegistration myServlet = servletContext.addServlet("myServlet", MyServlet.class);
//		myServlet.addMapping("/custom");
//	}
	
//	@Override
//	protected void customizeRegistration(Dynamic registration) {
//		registration.setMultipartConfig(new MultipartConfigElement("/tmp/spitter/uploads",2097152,4194304,0));
//	}

	
}
