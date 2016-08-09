package safeSelling.api;

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
