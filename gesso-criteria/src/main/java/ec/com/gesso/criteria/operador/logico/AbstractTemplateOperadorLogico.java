/**
 * 
 */
package ec.com.gesso.criteria.operador.logico;

import javax.persistence.criteria.Predicate;

import ec.com.gesso.criteria.WrapperPredicable;

/**
 * @author gortiz
 *
 */
public abstract class AbstractTemplateOperadorLogico implements WrapperPredicable {
	
	protected final Predicate predicate;

	protected AbstractTemplateOperadorLogico(Predicate predicate) {
		this.predicate = predicate;
	}

	/* (non-Javadoc)
	 * @see ec.gob.seps.query.operador.logico.Logico#getPredicate()
	 */
	@Override
	public Predicate getPredicate() {
		return this.predicate;
	}

}
