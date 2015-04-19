/**
 * 
 */
package ec.com.gesso.criteria.operador.logico;

import javax.persistence.criteria.Predicate;

/**
 * @author gortiz
 *
 */
public abstract class AbstractTemplateOperadorLogico {
	
	protected final Predicate predicate;

	protected AbstractTemplateOperadorLogico(Predicate predicate) {
		this.predicate = predicate;
	}
	
	public final Predicate getPredicate() {
		return this.predicate;
	}

}
