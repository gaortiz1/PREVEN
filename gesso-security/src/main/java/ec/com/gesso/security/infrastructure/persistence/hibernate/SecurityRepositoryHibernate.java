package ec.com.gesso.security.infrastructure.persistence.hibernate;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import ec.com.gesso.security.domain.model.security.SecurityRepository;
import ec.com.gesso.security.domain.model.security.dto.UserDto;

public class SecurityRepositoryHibernate extends HibernateRepository implements SecurityRepository{

	public UserDto autenticateUser(String userName, String userPassword) {

		Criteria criteria =  null;
		
		criteria =  getSession().createCriteria(UserDto.class);
		
		criteria.add(Restrictions.eq("usrNickName", userName));
		criteria.add(Restrictions.eq("usrPassword", userPassword));
		
		UserDto userDto = (UserDto) criteria.uniqueResult();
		
		return userDto;
	}

}
