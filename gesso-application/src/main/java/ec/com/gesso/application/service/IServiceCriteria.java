/**
 * 
 */
package ec.com.gesso.application.service;

import java.util.Collection;

import ec.com.gesso.model.entity.GeopoliticalDivision;

/**
 * @author Gabriel
 *
 */
public interface IServiceCriteria {
	
	Collection<GeopoliticalDivision> findGeopoliticalDivisionRoot(Long idRoot);
	
	Collection<GeopoliticalDivision> findGeopoliticalDivisionWitoutRoot();
	
	Collection<GeopoliticalDivision> findGeopoliticalDivisionById(Long id);

}
