/**
 * 
 */
package ec.com.gesso.criteria.operador.condicion.factory.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;

import ec.com.gesso.criteria.entity.attribute.basic.AttributeOneValue;
import ec.com.gesso.criteria.operador.condicion.AbstractTemplateCriteria;
import ec.com.gesso.criteria.operador.condicion.Condicionable;
import ec.com.gesso.criteria.operador.condicion.enumeration.ComparacionEnum;
import ec.com.gesso.criteria.operador.condicion.factory.FactoryFieldValue;
import ec.com.gesso.criteria.operador.condicion.impl.Equal;
import ec.com.gesso.criteria.operador.condicion.impl.Like;
import ec.com.gesso.criteria.operador.condicion.proxy.ProxyAttributeOneValue;

/**
 * @author gortiz
 *
 */
public final class OperadorOneValueFactory extends AbstractTemplateCriteria implements FactoryFieldValue<AttributeOneValue, ComparacionEnum> {

	private OperadorOneValueFactory(CriteriaBuilder criteriaBuilderWhere, Path<?> pathField) {
		super(criteriaBuilderWhere, pathField);
	}

	/**
	 * @return the instance
	 */
	public static FactoryFieldValue<AttributeOneValue, ComparacionEnum> getInstance(final CriteriaBuilder criteriaBuilderWhere, final Path<?> pathField) {
		return new OperadorOneValueFactory(criteriaBuilderWhere, pathField);		
	}

	
	public Condicionable<AttributeOneValue> newInstance(final ComparacionEnum condicion) {

		Condicionable<AttributeOneValue> condicionable = null;

		switch (condicion) {

		case EQUAL:
			condicionable = Equal.equalPredicate(criteriaBuilderWhere, pathField);
			break;
			
		case LIKE:
			condicionable = Like.likePredicate(criteriaBuilderWhere, pathField);
			break;

		default:
			condicionable = Like.likePredicate(criteriaBuilderWhere, pathField);
			break;
		}

		return new ProxyAttributeOneValue(condicionable);
	}

}
