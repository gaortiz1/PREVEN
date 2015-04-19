/**
 * 
 */
package ec.com.gesso.criteria.operador.logico.impl;

import javax.persistence.criteria.CriteriaBuilder;

import ec.com.gesso.criteria.WrapperPredicable;
import ec.com.gesso.criteria.operador.logico.AbstractTemplateOperadorLogico;

/**
 * @author gortiz
 *
 */
public final class Or extends AbstractTemplateOperadorLogico{

	private Or(CriteriaBuilder criteriaBuilder) {
		super(criteriaBuilder.disjunction());
	}
	
	public static WrapperPredicable orPredicate(final CriteriaBuilder criteriaBuilder) {
        return new Or(criteriaBuilder);
    }
}
