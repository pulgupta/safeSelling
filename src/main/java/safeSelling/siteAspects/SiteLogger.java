package safeSelling.siteAspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import safeSelling.FilePicker;
import safeSelling.Item;
import safeSelling.User;

@Aspect
public class SiteLogger {
	
	//Point cut definition
	@Pointcut("execution(* safeSelling.web.MainController.home(..))")
	public void mainController(){}
	
	@Pointcut("execution(* safeSelling.web.UserController.processRegistration(safeSelling.User,..)) && args(user,..)")
	public void userController(User user){}
	
	@Pointcut("execution(* safeSelling.web.UserController.addProfilePic(safeSelling.FilePicker)) && args(filePicker)")
	public void saveProfilePic(FilePicker filePicker){}
	
	@Pointcut("execution(* safeSelling.web.ItemController.editItem(safeSelling.Item)) && args(item)")
	public void updateItem(Item item){}
	
	//defining aspects
	@Before("mainController()")
	public void mainControllerCalled(){
		System.out.println("The main controller is called");
	}
	
	@Before("userController(user)")
	public void userControllerCalled(User user){
		System.out.println("Details saved for user " + user.getFirstName() + " " + user.getLastName());
	}
	
	@Before("saveProfilePic(filePicker)")
	public void picSavedCalled(FilePicker filePicker){
		if(filePicker==null){
			System.out.println("Object filePicker is received as null");
		}
		else if(filePicker.getUserName()==null)
			System.out.println("Username received as null");
		else if(filePicker.getFile()==null)
			System.out.println("File received as null userName was received as " + filePicker.getUserName() );

	}
	
	@Before("updateItem(item)")
	public void updateItemCalled(Item item){
		if(item!=null)
			System.out.println("ID of the item is " + item.getId());
	}
}
