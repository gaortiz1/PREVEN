/**
 * 
 */
package ec.com.gesso.criteria.operador.condicion;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;

/**
 * @author gortiz
 *
 */
public abstract class AbstractTemplateCriteria extends AbstractTemplatePath {
	
	protected final CriteriaBuilder criteriaBuilderWhere;
	
	protected AbstractTemplateCriteria(final CriteriaBuilder criteriaBuilderWhere, final Path<?> pathField) {
		super(pathField);
		this.criteriaBuilderWhere = criteriaBuilderWhere;
	}

}
