/**
 * 
 */
package ec.com.gesso.criteria;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author gortiz
 * 
 */
public interface QueryCriteria {

	/**
	 * 
	 * @param entity
	 * @return
	 */
	<T extends Serializable> T find(T entity);
	
	
	
	
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
	<T extends Serializable> Collection<T> findAll(T entity);

}
