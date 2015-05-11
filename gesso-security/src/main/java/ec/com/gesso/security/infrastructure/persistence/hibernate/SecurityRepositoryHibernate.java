package ec.com.gesso.security.infrastructure.persistence.hibernate;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Person;
import ec.com.gesso.model.entity.User;
import ec.com.gesso.model.entity.UserProfile;
import ec.com.gesso.security.domain.model.security.SecurityRepository;

public class SecurityRepositoryHibernate extends HibernateRepository implements SecurityRepository{

	public User autenticateUser(String userName, String userPassword) throws GessoException{

		Criteria criteria =  null;
		
		criteria =  getSession().createCriteria(User.class);
		
		criteria.add(Restrictions.eq("nickName", userName));
		criteria.add(Restrictions.eq("password", userPassword));
		
		User userDto = (User) criteria.uniqueResult();
		
		return userDto;
	}

//	@Override
	public void persistNewUser(Person person) throws GessoException{
		try {
			
			getSession().persist(person.getUserDto());
			person.setUserId(person.getUserDto().getUserId());
			getSession().persist(person);
			getSession().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

//	@Override
	public Collection<User> findAllUsers() throws GessoException{
		Criteria criteria =  null;
		criteria = getSession().createCriteria(User.class);
		criteria.createAlias("person", "personA");
		criteria.setFetchMode("personA", FetchMode.JOIN);
		criteria.addOrder(Order.desc("nickName"));
		
		
		return criteria.list();
	}

	public Collection<Person> findAllUsersByPerson() throws GessoException {
		Criteria criteria =  null;
		criteria =  getSession().createCriteria(Person.class);
		criteria.createAlias("userDto", "userDtoA", JoinType.INNER_JOIN);
		criteria.setFetchMode("userDtoA", FetchMode.JOIN);
		return criteria.list();
	}

	public void persistPerson(Person person) throws GessoException{
		getSession().persist(person);
		getSession().flush();
	}

	@Override
	public void persistUser(User userDto) throws GessoException {
		getSession().persist(userDto);
		getSession().flush();
	}

	@Override
	public User findUserById(Integer usrId) throws GessoException {
		Criteria criteria =  null;
		
		criteria =  getSession().createCriteria(User.class);
		
		criteria.add(Restrictions.eq("usrId", usrId));
		
		User userDto = (User) criteria.uniqueResult();
		return userDto;
	}

	public Collection<Person> findAllPersons() throws GessoException {
		Criteria criteria =  null;

		criteria =  getSession().createCriteria(Person.class);
		criteria.createAlias("userDto", "userDtoA", JoinType.LEFT_OUTER_JOIN);
		criteria.setFetchMode("userDtoA", FetchMode.JOIN);
		return criteria.list();
	}

	public void persistPersonUpdate(Person person) {
		try {

			getSession().update(person);
			getSession().flush();
		}catch(Exception ex){
			System.out.println(ex);
		}
	}

	@Override
	public Collection<UserProfile> findMenuForUser(Integer usrId) throws GessoException {
		Criteria criteria =  null;
		criteria =  getSession().createCriteria(UserProfile.class, "userProfileA");

		criteria.createAlias("userProfileA.lstUserProfileMenu", "userProfileMenuA");
		criteria.setFetchMode("userProfileMenuA", FetchMode.JOIN);

        criteria.createAlias("userProfileMenuA.menu", "menuA");
        criteria.setFetchMode("menuA", FetchMode.JOIN);

        criteria.createAlias("menuA.lstOption", "optionA");
        criteria.setFetchMode("optionA", FetchMode.JOIN);

        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);


		Collection<UserProfile> lst = criteria.list();
        Hibernate.initialize(lst);

		return lst;
	}

	@Override
	public void updateUser(User userDto) throws GessoException {
		try {

			getSession().update(userDto);
			getSession().flush();
		}catch(Exception ex){
			System.out.println(ex);
		}
		
	}

}
