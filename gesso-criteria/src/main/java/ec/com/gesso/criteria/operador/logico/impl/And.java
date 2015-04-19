/**
 * 
 */
package ec.com.gesso.criteria.operador.logico.impl;

import javax.persistence.criteria.CriteriaBuilder;

import ec.com.gesso.criteria.operador.logico.AbstractTemplateOperadorLogico;

/**
 * @author gortiz
 *
 */
public final class And extends AbstractTemplateOperadorLogico {

	private And(CriteriaBuilder criteriaBuilderWhere) {
		super(criteriaBuilderWhere.conjunction());
	}
	
	public static AbstractTemplateOperadorLogico andPredicate(final CriteriaBuilder criteriaBuilderWhere) {
        return new And(criteriaBuilderWhere);
    }
	
}
