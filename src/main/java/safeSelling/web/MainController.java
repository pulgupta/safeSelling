package safeSelling.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.apache.log4j.Logger;

@Controller
public class MainController {
	
	private static Logger logger = Logger.getLogger(MainController.class);
	@RequestMapping(value="/", method=GET)
	public String home(){
		logger.debug("This log is from log4j");
		return "index";
	}

}
