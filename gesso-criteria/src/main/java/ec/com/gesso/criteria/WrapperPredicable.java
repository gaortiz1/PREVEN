/**
 * 
 */
package ec.com.gesso.criteria;

import javax.persistence.criteria.Predicate;

/**
 * @author gortiz
 *
 */
public interface WrapperPredicable {
	
	Predicate getPredicate();

}
