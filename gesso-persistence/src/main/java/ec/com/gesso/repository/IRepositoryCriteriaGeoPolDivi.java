/**
 * 
 */
package ec.com.gesso.repository;

import java.util.Collection;

import ec.com.gesso.model.entity.GeopoliticalDivision;

/**
 * @author Gabriel
 *
 */
public interface IRepositoryCriteriaGeoPolDivi {
	
	Collection<GeopoliticalDivision> findGeopoliticalDivisionRoot(Long idRoot);
	
	Collection<GeopoliticalDivision> findGeopoliticalDivisionWitoutRoot();
	
	Collection<GeopoliticalDivision> findGeopoliticalDivisionById(Long id);

}
