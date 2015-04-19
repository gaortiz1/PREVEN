/**
 * 
 */
package ec.com.gesso.criteria.build;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;

import ec.com.gesso.criteria.WrapperPredicable;

/**
 * @author gortiz
 *
 */
public final class BuilderWrapperPredicable implements WrapperPredicable {
	
	private WrapperPredicable operadorLogico;

	public BuilderWrapperPredicable(WrapperPredicable operadorLogico) {
		this.setPredicate(operadorLogico);
	}

	public BuilderWrapperPredicable addCondicion(final Expression<Boolean> expression) {
		
		final boolean tieneOperadorLogico = this.operadorLogico != null;
		final boolean tienePredicate = tieneOperadorLogico && this.operadorLogico.getPredicate() != null;
		final boolean tieneExpression = expression != null;
		
		if (tienePredicate && tieneExpression) {
			this.operadorLogico.getPredicate().getExpressions().add(expression);
		}
		return this;
	}
	
	public BuilderWrapperPredicable addCondicion(final WrapperPredicable operadorLogico) {
		
		this.setPredicate(operadorLogico);
		
		if (operadorLogico != null && operadorLogico.getPredicate() != null) {
			this.operadorLogico.getPredicate().getExpressions().add(operadorLogico.getPredicate());
		}
		return this;
	}
	
	private void setPredicate(final WrapperPredicable operadorLogico){
		
		final boolean tieneOperadorLogico = this.operadorLogico != null;
		final boolean tieneParemtro = operadorLogico != null;
		
		if (!tieneOperadorLogico && tieneParemtro){
			this.operadorLogico = operadorLogico;
		}
	}

	@Override
	public Predicate getPredicate() {
		return this.operadorLogico != null ? this.operadorLogico.getPredicate() : null;
	}

}
