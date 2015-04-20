/**
 * 
 */
package ec.com.gesso.criteria.from;

import javax.persistence.criteria.From;

import ec.com.gesso.criteria.entity.attribute.AbstractAttribute;

/**
 * @author gortiz
 *
 */
public interface FromCriteria<T extends AbstractAttribute> {
	
	From<?, ?> getFrom(T field);

}
