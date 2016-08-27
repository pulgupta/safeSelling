package com.org.safeSelling.data;

import java.util.List;

import com.org.safeSelling.Item;

public interface ItemRepository {
	
	List<Item> findItems(int min, int count);
	Item findOne(long item_id);
	void save(Item item);
	List<Item> findMyItems(String userName);
	void update(Item item);
	List<Item> searchTags(String searchQuery , int min, int count);
}
