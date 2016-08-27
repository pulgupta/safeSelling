package safeSelling.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/*NOTES:
 * As per the document we can load the configurations either from the 
 * xml file or from the classes. These two approaches are mutually exclusive. 
*/
@ActiveProfiles("development")
//Context Configurations should be pick up from the class path
@ContextConfiguration(locations={"classpath:safeSelling/test/safeSelling-servlet.xml"}, 
	classes={com.org.safeSelling.config.WebConfig.class, com.org.safeSelling.config.RootConfig.class
			})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestController {

	@Test
	public void testCase1() {
		assertEquals("dummy test" , 1,1);
	}
}
