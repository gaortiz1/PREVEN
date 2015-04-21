/**
 * 
 */
package ec.com.gesso.application.service.impl;

import java.io.Serializable;
import java.util.Collection;

import ec.com.gesso.application.service.IServiceCriteria;
import ec.com.gesso.criteria.QueryCriteria;
import ec.com.gesso.model.entity.GeopoliticalDivision;
import ec.com.gesso.repository.IRepositoryCriteriaGeoPolDivi;

/**
 * @author Gabriel
 *
 */
public class ServiceCriteria implements IServiceCriteria {
	
	private IRepositoryCriteriaGeoPolDivi repositoryCriteriaGeoPolDivi;
	
	private QueryCriteria queryCriteria;

	public Collection<GeopoliticalDivision> findGeopoliticalDivisionRoot(Long idRoot) {
		return this.repositoryCriteriaGeoPolDivi.findGeopoliticalDivisionRoot(idRoot);
	}

	public Collection<GeopoliticalDivision> findGeopoliticalDivisionWitoutRoot() {
		return this.repositoryCriteriaGeoPolDivi.findGeopoliticalDivisionWitoutRoot();
	}
	
	public Collection<GeopoliticalDivision> findGeopoliticalDivisionById(Long id) {
		return this.repositoryCriteriaGeoPolDivi.findGeopoliticalDivisionById(id);
	}

	public <T extends Serializable> T find(T entity) {
		return this.queryCriteria.find(entity);
	}

	public <T extends Serializable> Collection<T> findAll(T entity) {
		return this.queryCriteria.findAll(entity);
	}
	
	/**
	 * @param repositoryCriteriaGeoPolDivi the repositoryCriteriaGeoPolDivi to set
	 */
	public void setRepositoryCriteriaGeoPolDivi(IRepositoryCriteriaGeoPolDivi repositoryCriteriaGeoPolDivi) {
		this.repositoryCriteriaGeoPolDivi = repositoryCriteriaGeoPolDivi;
	}

	/**
	 * @param queryCriteria the queryCriteria to set
	 */
	public void setQueryCriteria(QueryCriteria queryCriteria) {
		this.queryCriteria = queryCriteria;
	}

}