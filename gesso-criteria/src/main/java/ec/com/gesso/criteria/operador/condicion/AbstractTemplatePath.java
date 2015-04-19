/**
 * 
 */
package ec.com.gesso.criteria.operador.condicion;

import javax.persistence.criteria.Path;

/**
 * @author gortiz
 *
 */
public abstract class AbstractTemplatePath {
	
	protected final Path<?> pathField;
	
	protected AbstractTemplatePath(final Path<?> pathField){
		this.pathField = pathField;
	}

}
