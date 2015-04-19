/**
 * 
 */
package ec.com.gesso.criteria.operador.condicion.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import ec.com.gesso.criteria.entity.attribute.basic.AttributeOneValue;
import ec.com.gesso.criteria.operador.condicion.AbstractTemplateCriteria;
import ec.com.gesso.criteria.operador.condicion.Condicionable;

/**
 * @author gortiz
 * 
 */
public final class Like extends AbstractTemplateCriteria implements Condicionable<AttributeOneValue> {

	public static final String OPERATOR = "%";

	private Like(CriteriaBuilder criteriaBuilder, Path<?> pathField) {
		super(criteriaBuilder, pathField);
	}
	
	public static Condicionable<AttributeOneValue> likePredicate(final CriteriaBuilder criteriaBuilder, final Path<?> pathField) {
        return new Like(criteriaBuilder, pathField);
    }

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ec.gob.seps.query.operador.Comparable#getExpression(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public Predicate getPredicate(final AttributeOneValue rowOneValue) {
		final StringBuilder campoLike = new StringBuilder();
		campoLike.append(OPERATOR).append(rowOneValue.getValue()).append(OPERATOR);
		return this.criteriaBuilderWhere.like(this.pathField.<String>get(rowOneValue.getNombreCampo()), campoLike.toString());
	}

}
