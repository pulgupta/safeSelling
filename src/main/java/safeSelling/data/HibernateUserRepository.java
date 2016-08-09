package safeSelling.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import safeSelling.User;

@Primary
@Repository
public class HibernateUserRepository implements UserRepository {

	SessionFactory sessionFactory;
	
	@Autowired
	public HibernateUserRepository(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	private Session currentSession() { 
		return sessionFactory.getCurrentSession();
	}
	
	public long count(){
		return findAll().size();
	}
	
	@SuppressWarnings("unchecked")
	public List<User> findAll() { 
		return(List<User>)currentSession().createCriteria(User.class).list();
	}

	@Override
	@Transactional
	public void save(User user) {
		currentSession().save(user);
		
		/*
		 *Transaction txn = currentSession().getTransaction();
		 *txn.begin();
		 *txn.commit();
		 */
	}

	//In this way we can set the isolation level at the transaction level
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public User findByUsername(String userName) {
		User user = (User)currentSession().get(User.class, userName);
		return user;
	}

	@Override
	@Transactional
	public void update(User user) {
		currentSession().update(user);
	}
	
	/*
	//Tester code
	public static void main(String args[]){
		User usr = new User();
		usr.setFirstName("haha");
		DataSourceConfiguration dsc = new DataSourceConfiguration();
		FactoryBeanConfig fbc = new FactoryBeanConfig();
		HibernateUserRepository hur = new HibernateUserRepository(fbc.sessionFactory(dsc.Data()).getObject());
		hur.save(usr);
	}
	*/
}
