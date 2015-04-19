/**
 * 
 */
package ec.com.gesso.criteria.from.fetch.impl;

import javax.persistence.criteria.From;

import ec.com.gesso.criteria.entity.attribute.basic.AttributeOneValue;
import ec.com.gesso.criteria.entity.attribute.decorator.AttributeJoin;
import ec.com.gesso.criteria.from.AbstractTemplateFrom;
import ec.com.gesso.criteria.from.FromCriteria;

/**
 * @author gortiz
 *
 */
public final class FetchEntityLazy extends AbstractTemplateFrom<AttributeJoin<AttributeOneValue>> {

	private FetchEntityLazy(From<?, ?> from) {
		super(from);
	}
	
	public static FromCriteria<AttributeJoin<AttributeOneValue>> join(final From<?, ?> from){
		return new FetchEntityLazy(from);
	}

	@Override
	public From<?, ?> getFrom(AttributeJoin<AttributeOneValue> field) {
		return (From<?, ?>) from.fetch(field.getNombreCampo(), field.getJoinTypeCriteria().getJoinType());
	}

}
