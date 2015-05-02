/**
 * 
 */
package ec.com.gesso.application.service.impl;

import java.io.Serializable;
import java.util.Collection;

import ec.com.gesso.application.service.IServiceCriteria;
import ec.com.gesso.criteria.QueryCriteria;
import ec.com.gesso.model.entity.GeopoliticalDivision;

/**
 * @author Gabriel
 *
 */
public class ServiceCriteria implements IServiceCriteria {
	
	private QueryCriteria queryCriteria;

	public Collection<GeopoliticalDivision> findChildrenGeopoliticalDivision(Long idRoot) {
		return null;
	}

	public Collection<GeopoliticalDivision> findRootGeopoliticalDivision() {
		return null;
	}
	
	public Collection<GeopoliticalDivision> findGeopoliticalDivisionById(Long id) {
		return null;
	}

	public <T extends Serializable> T find(T entity) {
		return this.queryCriteria.find(entity);
	}

	public <T extends Serializable> Collection<T> findAll(T entity) {
		return this.queryCriteria.findAll(entity);
	}

	/**
	 * @param queryCriteria the queryCriteria to set
	 */
	public void setQueryCriteria(QueryCriteria queryCriteria) {
		this.queryCriteria = queryCriteria;
	}

}