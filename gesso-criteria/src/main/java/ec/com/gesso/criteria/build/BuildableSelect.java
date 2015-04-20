/**
 * 
 */
package ec.com.gesso.criteria.build;

import java.io.Serializable;

import javax.persistence.criteria.CriteriaQuery;

/**
 * @author gortiz
 *
 */
public interface BuildableSelect {
	
	<T extends Serializable> CriteriaQuery<T> getCriteriaQuery(T entity);

}
