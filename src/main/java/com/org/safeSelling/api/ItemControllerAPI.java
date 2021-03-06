package com.org.safeSelling.api;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.org.safeSelling.dao.ItemRepository;
import com.org.safeSelling.dto.Item;

@RestController
@RequestMapping("/itemsapi")
public class ItemControllerAPI {
	
	public static final Logger log = Logger.getLogger(ItemControllerAPI.class.getName());

	private ItemRepository itemRepository;
	
	@Autowired
	public ItemControllerAPI (ItemRepository itemRepository){
		this.itemRepository = itemRepository;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	
	//As a standard always use @Transactional on the service layer and not on the DAO layer
	@Transactional
	public Item item(
			@RequestParam(value="item_id") int item_id){	
		Item item = itemRepository.findOne(item_id); 
		if(item==null) throw new ItemNotFoundException(item_id);
		log.log(Level.INFO,"Record found");
		return item;
	}
	
	//To catch all the exceptions we can create a method like this and can then 
	//define the exceptions which we want to catch
	//In this way again we can separate the normal business logic from the exceptions 
	@ExceptionHandler(ItemNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String itemNotFound(ItemNotFoundException e){
		log.log(Level.WARNING, "Record not found");
		long itemId = e.getItemId();
		return ("Item [" + itemId + "] not found");
	}
}
