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
public final class Equal extends AbstractTemplateCriteria implements Condicionable<AttributeOneValue> {
	
	private Equal(CriteriaBuilder criteriaBuilderWhere, Path<?> pathField){
		super(criteriaBuilderWhere, pathField);
	}
	
	public static Condicionable<AttributeOneValue> equalPredicate(final CriteriaBuilder criteriaBuilder, final Path<?> path) {
        return new Equal(criteriaBuilder, path);
    }

	/* (non-Javadoc)
	 * @see ec.gob.seps.query.operador.Comparacion#getExpression(java.lang.String, java.lang.Object)
	 */
	@Override
	public Predicate getPredicate(final AttributeOneValue rowOneValue) {
		return this.criteriaBuilderWhere.equal(this.pathField.get(rowOneValue.getNombreCampo()), rowOneValue.getValue());
	}

}
