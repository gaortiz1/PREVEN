/**
 * 
 */
package ec.com.gesso.criteria.entity.attribute.decorator;

import ec.com.gesso.criteria.entity.attribute.AbstractAttribute;
import ec.com.gesso.criteria.from.fetch.enumeration.FetchTypeWrapper;
import ec.com.gesso.criteria.from.join.enumeration.JoinTypeWrapper;

/**
 * @author gortiz
 *
 */
public class AttributeJoin<T extends AbstractAttribute> extends AbstractAttributeDecorator<T> {
	
	private final JoinTypeWrapper joinTypeWrapper;
	private final FetchTypeWrapper fetchTypeCriteria;

	public AttributeJoin(T attribute, JoinTypeWrapper joinTypeWrapper, FetchTypeWrapper fetchType) {
		super(attribute);
		this.joinTypeWrapper = joinTypeWrapper;
		this.fetchTypeCriteria = fetchType;
	}

	/**
	 * @return the comparacionEnum
	 */
	public JoinTypeWrapper getJoinTypeCriteria() {
		return joinTypeWrapper;
	}

	/**
	 * @return the fetchTypeCriteria
	 */
	public FetchTypeWrapper getFetchTypeCriteria() {
		return fetchTypeCriteria;
	}

}
