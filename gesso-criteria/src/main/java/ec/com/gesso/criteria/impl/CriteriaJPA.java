/**
 * 
 */
package ec.com.gesso.criteria.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import ec.com.gesso.criteria.AbstractCriteriaJPA;

/**
 * @author Gabriel
 *
 */
public final class CriteriaJPA extends AbstractCriteriaJPA {
	
	private EntityManager entityManager;

	/**
	 * @param entityManager
	 */
	public CriteriaJPA(EntityManagerFactory entityManagerFactory) {
		this.entityManager = entityManagerFactory.createEntityManager();
	}

	/* (non-Javadoc)
	 * @see ec.com.gesso.criteria.AbstractCriteriaJPA#getEntityManager()
	 */
	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
