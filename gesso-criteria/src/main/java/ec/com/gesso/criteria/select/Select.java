/**
 * 
 */
package ec.com.gesso.criteria.select;

import java.io.Serializable;

import javax.persistence.criteria.From;
import javax.persistence.metamodel.EntityType;

import ec.com.gesso.criteria.WrapperPredicable;

/**
 * @author gortiz
 *
 */
public interface Select {
	
	<T extends Serializable> WrapperPredicable getWhere(T entity, From<?, ?> from, EntityType<?> entityType);
	
}
