/**
 * 
 */
package ec.com.gesso.criteria.impl;

import javax.persistence.EntityManager;

import ec.com.gesso.criteria.BaseQueryCriteriaJPA;

/**
 * @author Gabriel
 *
 */
public final class CriteriaJPA extends BaseQueryCriteriaJPA {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final EntityManager entityManager;

	/**
	 * @param entityManager
	 */
	public CriteriaJPA(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/* (non-Javadoc)
	 * @see ec.com.gesso.criteria.AbstractCriteriaJPA#getEntityManager()
	 */
	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
