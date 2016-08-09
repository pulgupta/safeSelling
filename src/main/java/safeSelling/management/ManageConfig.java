package safeSelling.management;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.jmx.export.MBeanExporter;

public class ManageConfig {
	@Bean
	public MBeanExporter mBeanExporter (safeSelling.User user) {
		MBeanExporter exporter = new MBeanExporter();
		Map<String, Object> beans = new HashMap<String, Object>();
		beans.put("safeSelling:name=User", user);
		exporter.setBeans(beans);
		return exporter;
	}
}
