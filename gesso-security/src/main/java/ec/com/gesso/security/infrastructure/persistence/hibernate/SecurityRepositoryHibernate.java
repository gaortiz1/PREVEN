package ec.com.gesso.security.infrastructure.persistence.hibernate;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;

import ec.com.gesso.model.entity.Person;
import ec.com.gesso.model.entity.UserDto;
import ec.com.gesso.security.domain.model.security.SecurityRepository;

public class SecurityRepositoryHibernate extends HibernateRepository implements SecurityRepository{

	public UserDto autenticateUser(String userName, String userPassword) {

		Criteria criteria =  null;
		
		criteria =  getSession().createCriteria(UserDto.class);
		
		criteria.add(Restrictions.eq("usrNickName", userName));
		criteria.add(Restrictions.eq("usrPassword", userPassword));
		
		UserDto userDto = (UserDto) criteria.uniqueResult();
		
		return userDto;
	}

//	@Override
	public void persistNewUser(Person person) {
		try {
			
			getSession().persist(person.getUserDto());
			getSession().persist(person);
			getSession().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

//	@Override
	public Collection<UserDto> findAllUsers() {
		Criteria criteria =  null;
		criteria = getSession().createCriteria(UserDto.class);
		criteria.createAlias("person", "personA");
		criteria.setFetchMode("personA", FetchMode.JOIN);
		
		return criteria.list();
	}

	public void persistPerson(Person person) {
//		getSession().persist(person.getUserDto());
		getSession().persist(person);
		getSession().flush();
	}

}
