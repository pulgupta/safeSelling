package safeSelling.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import safeSelling.siteAspects.SiteLogger;

@Configuration
@EnableAspectJAutoProxy	 		//To enable aspect oriented programming
@ComponentScan
public class AspectsConfig {

	@Bean
	public SiteLogger siteLogger(){
		return new SiteLogger();
	}
}
