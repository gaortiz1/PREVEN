/**
 * 
 */
package ec.com.gesso.repository.impl;

import java.io.Serializable;

import org.hibernate.SessionFactory;

import ec.com.gesso.repository.IRepositoryEntity;


/**
 * @author Gabriel
 *
 */
public class RepositoryWrapper<Entity extends Serializable> extends AbstractHibernateRepository implements IRepositoryEntity<Entity>{
	
	public RepositoryWrapper(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public Entity create(Entity entity) {
		this.getSession().persist(entity);
		this.getSession().flush();
		return entity;
	}

}
