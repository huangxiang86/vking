package com.vking.config;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
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
		return new String[] {"/*"};
	}
	
	@Override
	protected void customizeRegistration(Dynamic registration) {
		registration.setLoadOnStartup(1);
		super.customizeRegistration(registration);
	}
	
	
	
	
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		super.onStartup(servletContext);
//		try {
//			genericStaticSourceServlet(servletContext);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	
//	private void genericStaticSourceServlet(ServletContext servletContext) throws FileNotFoundException, IOException {
//		String realPath = servletContext.getRealPath("/");
//		StringBuffer servletPropertiesPath = new StringBuffer(realPath);
//		servletPropertiesPath.append("/").append("config").append("/").append("servlet").append("/").append("servlet.properties");
//		Properties servletProperties = new Properties();
//		servletProperties.load(new FileInputStream(servletPropertiesPath.toString()));
//		String defalutServletMappings = servletProperties.getProperty("servlet.default");
//		System.out.println("Defalut Servlet Mapping Loading:" + defalutServletMappings);
//		String[] defalutServletMappingList = defalutServletMappings.split(";");
//		ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
//		System.out.println("defaultServlet:" + defaultServlet.getName());
//		defaultServlet.addMapping(defalutServletMappingList);
//	}
	
//	@Override
//	protected void customizeRegistration(Dynamic registration) {
//		registration.setMultipartConfig(new MultipartConfigElement("/tmp/spitter/uploads",2097152,4194304,0));
//	}

	
}
