package com.org.safeSelling.management;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.jmx.export.MBeanExporter;

public class ManageConfig {
	@Bean
	public MBeanExporter mBeanExporter (com.org.safeSelling.dto.User user) {
		MBeanExporter exporter = new MBeanExporter();
		Map<String, Object> beans = new HashMap<String, Object>();
		beans.put("safeSelling:name=User", user);
		exporter.setBeans(beans);
		return exporter;
	}
}
