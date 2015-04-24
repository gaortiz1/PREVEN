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
	
	Collection<GeopoliticalDivision> findChildrenGeopoliticalDivision(Long idRoot);
	
	Collection<GeopoliticalDivision> findRootGeopoliticalDivision();
	
	Collection<GeopoliticalDivision> findGeopoliticalDivisionById(Long id);

}
