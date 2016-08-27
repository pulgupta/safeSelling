package com.org.safeSelling.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class safeSellingWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	//application beans i.e middle tier and data tier
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {RootConfig.class};
	}
	
	//Dispatcher Servlet bean context 
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
