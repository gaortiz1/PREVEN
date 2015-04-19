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
public abstract class AbstractTemplateFrom<T extends AbstractAttribute> implements FromCriteria<T> {
	
	protected final From<?, ?> from;

	protected AbstractTemplateFrom(From<?, ?> from) {
		this.from = from;
	}

}