package com.org.safeSelling.data;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.org.safeSelling.Item;
import com.org.safeSelling.util.StringConversions;

@Primary 	// To tell spring that this is the primary bean to be used
@Repository  // It extends the @Component annotation and provide translatio
//for any exception thrown from the DOA layer into SpringDataAccessException
public class ItemRepositoryHibernateImpl implements ItemRepository {

	SessionFactory sessionFactory;

	@Autowired
	public ItemRepositoryHibernateImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession() { 
		return sessionFactory.getCurrentSession();
	}

	//This message will be used for implementing the pagination login
	//From the client we will send the initial records and maximum elements to return
	@Override
	@Transactional
	public List<Item> findItems(int min, int count) {
		String hql="from Item";
		Query qur = currentSession().createQuery(hql);
		qur.setFirstResult(min);
		qur.setMaxResults(count);
		@SuppressWarnings("unchecked")
		List<Item> result = qur.list();
		return result;
	}

	@Override
	
	public Item findOne(long item_id) {
		// TODO Auto-generated method stub
		Item item = (Item) currentSession().get(Item.class, item_id);
		if(item==null) return null;
		item.setTagList(com.org.safeSelling.util.StringConversions.listToString(item.getTags(), ";"));
		return item;
	}

	@Override
	@Transactional
	public void save(Item item) {
		List<String> tags = StringConversions.stringToList(item.getTagList(), ";");
		item.setTags(tags);
		currentSession().save(item);		
	}

	@Override
	@Transactional
	public List<Item> findMyItems(String userName) {
		String hql = "from Item where userName=:userName";
		Query qur = currentSession().createQuery(hql);
		qur.setParameter("userName", userName);
		@SuppressWarnings("unchecked")
		List<Item> result = qur.list();
		return result;
	}

	@Override
	@Transactional
	public void update(Item item){
		currentSession().update(item);
	}

	@Override
	@Transactional
	public List<Item> searchTags(String searchQuery, int min, int count) {
		String hql = "from Item where :searchQuery in elements(tags)";
		Query qur = currentSession().createQuery(hql);
		qur.setParameter("searchQuery", searchQuery);
		qur.setFirstResult(min);
		qur.setMaxResults(count);
		@SuppressWarnings("unchecked")
		List<Item> result = qur.list();
		return result;
	}	
}
