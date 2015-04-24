package ec.com.gesso.security.infrastructure.persistence.hibernate;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Person;
import ec.com.gesso.model.entity.User;
import ec.com.gesso.security.domain.model.security.SecurityRepository;

public class SecurityRepositoryHibernate extends HibernateRepository implements SecurityRepository{

	public User autenticateUser(String userName, String userPassword) throws GessoException{

		Criteria criteria =  null;
		
		criteria =  getSession().createCriteria(User.class);
		
		criteria.add(Restrictions.eq("usrNickName", userName));
		criteria.add(Restrictions.eq("usrPassword", userPassword));
		
		User userDto = (User) criteria.uniqueResult();
		
		return userDto;
	}

//	@Override
	public void persistNewUser(Person person) throws GessoException{
		try {
			
			getSession().persist(person.getUserDto());
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
		return criteria.list();
	}

}
