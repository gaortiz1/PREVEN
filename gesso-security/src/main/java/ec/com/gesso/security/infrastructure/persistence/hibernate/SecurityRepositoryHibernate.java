package ec.com.gesso.security.infrastructure.persistence.hibernate;

import ec.com.gesso.security.domain.model.security.SecurityRepository;

public class SecurityRepositoryHibernate extends HibernateRepository implements SecurityRepository{

	public void autenticateUser(String userName, String userPassword) {
		// TODO Auto-generated method stub
		getSession().createCriteria(String.class);
	}

}
