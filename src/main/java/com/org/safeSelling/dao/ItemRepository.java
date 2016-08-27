package com.org.safeSelling.dao;

import java.util.List;

import com.org.safeSelling.dto.Item;

public interface ItemRepository {
	
	List<Item> findItems(int min, int count);
	Item findOne(long item_id);
	void save(Item item);
	List<Item> findMyItems(String userName);
	void update(Item item);
	List<Item> searchTags(String searchQuery , int min, int count);
}
