/**
 * 
 */
package ec.com.gesso.criteria.from.fetch.impl;

import javax.persistence.criteria.From;

import org.hibernate.jpa.criteria.FromImplementor;

import ec.com.gesso.criteria.entity.attribute.basic.AttributeOneValue;
import ec.com.gesso.criteria.entity.attribute.decorator.AttributeJoin;
import ec.com.gesso.criteria.from.AbstractTemplateFrom;
import ec.com.gesso.criteria.from.FromCriteria;

/**
 * @author gortiz
 *
 */
public final class FetchEntityEager extends AbstractTemplateFrom<AttributeJoin<AttributeOneValue>> {

	private FetchEntityEager(From<?, ?> from) {
		super(from);
	}
	
	public static FromCriteria<AttributeJoin<AttributeOneValue>> join(final From<?, ?> from){
		return new FetchEntityEager(from);
	}

	@Override
	public From<?, ?> getFrom(AttributeJoin<AttributeOneValue> field) {
		return (FromImplementor<?, ?>) from.fetch(field.getNombreCampo(), field.getJoinTypeCriteria().getJoinType());
	}

}
