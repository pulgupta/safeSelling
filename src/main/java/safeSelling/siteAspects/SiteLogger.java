package safeSelling.siteAspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import safeSelling.FilePicker;
import safeSelling.Item;
import safeSelling.User;

//One of the best use of Spring is to create Aspects
//By using Aspects we can separate different concerns
//For a business service the main concern is to perform the business tasks
//We can then take the logging operations outside of that concern
@Aspect
public class SiteLogger {
	
	private static final Logger logger = Logger.getLogger(SiteLogger.class);
	
	//Point cut definition
	//We will then attach advice with these pointcuts
	@Pointcut("execution(* safeSelling.web.MainController.home(..))")
	public void mainController(){}
	
	@Pointcut("execution(* safeSelling.web.UserController.processRegistration(safeSelling.User,..)) && args(user,..)")
	public void userController(User user){}
	
	@Pointcut("execution(* safeSelling.web.UserController.addProfilePic(safeSelling.FilePicker)) && args(filePicker)")
	public void saveProfilePic(FilePicker filePicker){}
	
	@Pointcut("execution(* safeSelling.web.ItemController.editItem(safeSelling.Item)) && args(item)")
	public void updateItem(Item item){}
	
	
	//defining aspects and linking them to the pointcuts defined above
	@Before("mainController()")
	public void mainControllerCalled(){
		logger.info("The main controller is called from aspect");
	}
	
	@Before("userController(user)")
	public void userControllerCalled(User user){
		logger.info("Details saved for user " + user.getFirstName() + " " + user.getLastName());
	}
	
	@Before("saveProfilePic(filePicker)")
	public void picSavedCalled(FilePicker filePicker){
		if(filePicker==null){
			logger.info("Object filePicker is received as null");
		}
		else if(filePicker.getUserName()==null)
			logger.info("Username received as null");
		else if(filePicker.getFile()==null)
			logger.info("File received as null userName was received as " + filePicker.getUserName() );

	}
	
	@Before("updateItem(item)")
	public void updateItemCalled(Item item){
		if(item!=null)
			logger.info("ID of the item is " + item.getId());
	}
}
