/**
 * 
 */
package ec.com.gesso.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author Gabriel
 *
 */
public abstract class BaseHibernateRepository {

	private final SessionFactory sessionFactory;

	/**
	 * @param sessionFactory
	 */
	public BaseHibernateRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	protected final Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
