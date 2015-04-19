/**
 * 
 */
package ec.com.gesso.criteria.operador.condicion.decorator.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;

import ec.com.gesso.criteria.entity.attribute.AbstractAttribute;
import ec.com.gesso.criteria.operador.condicion.Condicionable;
import ec.com.gesso.criteria.operador.condicion.decorator.AbstractCondicionDecorator;

/**
 * @author gortiz
 * @param <T>
 *
 */
public final class NotDecorator<T extends AbstractAttribute> extends AbstractCondicionDecorator<T> {
	
	private final CriteriaBuilder criteriaBuilderWhere;

	private NotDecorator(CriteriaBuilder criteriaBuilderWhere, Condicionable<T> condicionInterseccion) {
		super(condicionInterseccion);
		this.criteriaBuilderWhere = criteriaBuilderWhere;
	}
	
	public static <T extends AbstractAttribute> Condicionable<T> notPredicate(final CriteriaBuilder criteriaBuilder, final Condicionable<T> condicionInterseccion) {
        return new NotDecorator<T>(criteriaBuilder, condicionInterseccion);
    }

	@Override
	public Predicate getPredicate(T row) {
		return criteriaBuilderWhere.not(this.condicion.getPredicate(row));
	}

}
