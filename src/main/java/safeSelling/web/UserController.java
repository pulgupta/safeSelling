package safeSelling.web;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import safeSelling.FilePicker;
import safeSelling.Item;
import safeSelling.User;
import safeSelling.data.ItemRepository;
import safeSelling.data.UserRepository;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/user")
public class UserController {
	private UserRepository userRepository;
	private ItemRepository itemRepository;
	
	@Autowired
	public UserController(UserRepository userRepository){
		this.userRepository = userRepository; 
	}
	
	@Autowired
	public void setItemRepository(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	public String getLoggedinUser(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
		String userName = auth.getName();
		return userName;
	}
	
	@RequestMapping(value="/register", method=GET)
	public String showRegistrationForm(Model model){
		model.addAttribute(new User());
		return "registerForm";
	}
	
	@RequestMapping(value="/register", method=POST)
	public String processRegistration(@Valid User user, Errors errors, Model model, BindingResult result){
	
		if(errors.hasErrors())
			return "registerForm";
		try{
			userRepository.save(user);
		}
		catch(DataIntegrityViolationException e){
			System.out.println(e.getMessage());
			result.rejectValue("userName","DuplicateKey.user.userName");
			return "registerForm";
		}
		model.addAttribute("userName",user.getUserName());
		return "profilePicker";
	}
	
	@RequestMapping(value="/profile", method=GET)
	public String checkProfile(){
		String userName = this.getLoggedinUser();
		return "redirect:/user/profile/" + userName;
	}
	
	@RequestMapping(value="/profile/{username}" , method=GET)
	public String showUserProfile(
			@PathVariable String username, Model model){
		User user = userRepository.findByUsername(username);
		List<Item> myItems = itemRepository.findMyItems(username);
		model.addAttribute(user);
		model.addAttribute(myItems);
		return "profile";
	}
	
	@RequestMapping(value="/register/picture", method=POST)
	public String addProfilePic(FilePicker filePicker) throws IOException{
			
		if(!filePicker.getFile().isEmpty()){
			BufferedImage src = ImageIO.read(new ByteArrayInputStream(filePicker.getFile().getBytes()));
			File destination = new File("E:\\siteImages\\" + filePicker.getUserName() + ".png");
			ImageIO.write(src, "png", destination);
		}
		return "redirect:/user/profile/" + filePicker.getUserName();
	}
	
	@RequestMapping(value="/profile/private/details", method=GET)
	public String editProfile(Model model){
		String userName = this.getLoggedinUser();
		User user = userRepository.findByUsername(userName);
		model.addAttribute(user);
		return "editProfile";
	}
	
	@RequestMapping(value="/profile/private/details", method=POST)
	public String updateEditProfile(User user, Model model){
		User user1 = userRepository.findByUsername(user.getUserName());
		user.setPassword(user1.getPassword());
		userRepository.update(user);
		return "profile";
	}
}
