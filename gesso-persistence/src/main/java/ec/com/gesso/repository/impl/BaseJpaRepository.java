/**
 * 
 */
package ec.com.gesso.repository.impl;

import javax.persistence.EntityManager;

/**
 * @author Gabriel
 *
 */
public abstract class BaseJpaRepository {

	private final EntityManager entityManager;

	/**
	 * @param entityManager
	 */
	public BaseJpaRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * @return the entityManager
	 */
	protected final EntityManager getEntityManager() {
		return entityManager;
	}

	

}
