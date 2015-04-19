/**
 * 
 */
package ec.com.gesso.criteria.select;

import java.io.Serializable;

import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import javax.persistence.metamodel.EntityType;

/**
 * @author gortiz
 *
 */
public interface Select {
	
	<T extends Serializable> Predicate getWhere(T entity, From<?, ?> from, EntityType<?> entityType);
	
}