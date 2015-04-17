/**
 * 
 */
package ec.com.gesso.application.service.impl;

import java.util.Collection;

import ec.com.gesso.application.service.IServiceCriteria;
import ec.com.gesso.model.entity.GeopoliticalDivision;
import ec.com.gesso.repository.IRepositoryCriteriaGeoPolDivi;

/**
 * @author Gabriel
 *
 */
public class ServiceCriteria implements IServiceCriteria {
	
	private IRepositoryCriteriaGeoPolDivi repositoryCriteriaGeoPolDivi;

	public Collection<GeopoliticalDivision> findGeopoliticalDivisionRoot(Long idRoot) {
		return this.repositoryCriteriaGeoPolDivi.findGeopoliticalDivisionRoot(idRoot);
	}

	public Collection<GeopoliticalDivision> findGeopoliticalDivisionWitoutRoot() {
		return this.repositoryCriteriaGeoPolDivi.findGeopoliticalDivisionWitoutRoot();
	}
	
	public Collection<GeopoliticalDivision> findGeopoliticalDivisionById(Long id) {
		return this.repositoryCriteriaGeoPolDivi.findGeopoliticalDivisionById(id);
	}

	/**
	 * @param repositoryCriteriaGeoPolDivi the repositoryCriteriaGeoPolDivi to set
	 */
	public void setRepositoryCriteriaGeoPolDivi(IRepositoryCriteriaGeoPolDivi repositoryCriteriaGeoPolDivi) {
		this.repositoryCriteriaGeoPolDivi = repositoryCriteriaGeoPolDivi;
	}

}