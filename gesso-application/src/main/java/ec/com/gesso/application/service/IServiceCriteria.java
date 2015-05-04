/**
 * 
 */
package ec.com.gesso.application.service;

import java.util.Collection;

import ec.com.gesso.criteria.QueryCriteria;
import ec.com.gesso.model.entity.GeopoliticalDivision;

/**
 * @author Gabriel
 *
 */
public interface IServiceCriteria  extends QueryCriteria{
	
	Collection<GeopoliticalDivision> findRootGeopoliticalDivision();

}