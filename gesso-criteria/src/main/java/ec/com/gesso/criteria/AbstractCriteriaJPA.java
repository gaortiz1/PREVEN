/**
 * 
 */
package ec.com.gesso.criteria;

import java.io.Serializable;

import javax.persistence.EntityManager;

/**
 * @author gortiz
 *
 */
public abstract class AbstractCriteriaJPA implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected abstract EntityManager getEntityManager();
}
