package com.org.safeSelling.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.safeSelling.dao.ItemRepository;
import com.org.safeSelling.dto.Item;

@Controller
@RequestMapping("/items")
public class ItemController {
	private final String MIN_INT_AS_STRING = "0";
	private ItemRepository ItemRepository;

	// just a constructor in which we have injected the class for Item
	// repository
	@Autowired
	public ItemController(ItemRepository ItemRepository) {
		this.ItemRepository = ItemRepository;
	}

	// the method which will handle the request to get all the Items
	// not used as of now
	/*
	 * @RequestMapping(method=RequestMethod.GET) public String Items(Model
	 * model){ model.addAttribute(ItemRepository.findItems(Long.MAX_VALUE, 20));
	 * return "items"; }
	 */

	// This method will give us the logged in user
	public String getLoggedInUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		return userName;
	}

	// This method will return all the items which are added to the site
	@RequestMapping(method = RequestMethod.GET)
	public void Items(@RequestParam(value = "min", defaultValue = MIN_INT_AS_STRING) int min,
			@RequestParam(value = "count", defaultValue = "20") int count, Model model) {
		model.addAttribute("itemList", ItemRepository.findItems(min, count));
	}

	// Just to pass a new object so that we will not get a null pointer at the
	// .jsp side
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addItemView(Model model) {
		model.addAttribute(new Item());
		return "addItem";
	}

	// Will save a new item in the database
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addItem(Item item) {
		item.setUserName(this.getLoggedInUser());
		ItemRepository.save(item);
		return "index";
	}

	// Return a single item by using the item id
	@RequestMapping(value = "/{item_id}", method = RequestMethod.GET)
	public String showItem(@PathVariable("item_id") long item_id, Model model) {
		model.addAttribute(ItemRepository.findOne(item_id));
		return "items";
	}

	// Will check if the logged in user can actually edit the item
	@RequestMapping(value = "/edit/{item_id}", method = RequestMethod.GET)
	public String editItem(@PathVariable("item_id") long item_id, Model model) {
		Item item = ItemRepository.findOne(item_id);
		if (item.getUserName() == this.getLoggedInUser())
			return "profile";
		else {
			model.addAttribute(item);
			return "editItem";
		}
	}

	// Update the item with the new details
	@RequestMapping(value = "/edit/{item_id}", method = RequestMethod.POST)
	public String editItem(Item item) {
		ItemRepository.update(item);
		return "profile";
	}

	// provide the search functionality by using the tags assigned to an item
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam(value = "tags", defaultValue = "*") String searchQuery,
			@RequestParam(value="min", defaultValue="0" ) int min,
			@RequestParam(value="count", defaultValue ="10") int count, Model model) {
		model.addAttribute(ItemRepository.searchTags(searchQuery, min,count));
		return "items";
	}
}
