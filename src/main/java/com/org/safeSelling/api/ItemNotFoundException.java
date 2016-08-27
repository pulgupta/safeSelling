package com.org.safeSelling.api;

/**
 * Custom exception to handle if an element is not found
 * @author pulgupta
 *
 */
public class ItemNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	
	public ItemNotFoundException(long itemId){
		id=itemId;
	}
	
	public long getItemId(){
		return id;
	}
}
