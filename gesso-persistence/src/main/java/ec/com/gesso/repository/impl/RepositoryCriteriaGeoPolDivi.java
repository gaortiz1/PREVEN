/**
 * 
 */
package ec.com.gesso.repository.impl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ec.com.gesso.model.entity.GeopoliticalDivision;
import ec.com.gesso.repository.IRepositoryCriteriaGeoPolDivi;

/**
 * @author Gabriel
 *
 */
public class RepositoryCriteriaGeoPolDivi extends BaseJpaRepository implements IRepositoryCriteriaGeoPolDivi {
	
	public RepositoryCriteriaGeoPolDivi(EntityManager entityManager) {
		super(entityManager);
	}

	public Collection<GeopoliticalDivision> findGeopoliticalDivisionRoot(Long idRoot){
		
		final CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<GeopoliticalDivision> criteriaQuery = criteriaBuilder.createQuery(GeopoliticalDivision.class);
		final Root<GeopoliticalDivision> root = criteriaQuery.from(GeopoliticalDivision.class);
		
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("idRoot"), idRoot));
		return this.getEntityManager().createQuery(criteriaQuery).getResultList();
	}
	
	public Collection<GeopoliticalDivision> findGeopoliticalDivisionWitoutRoot(){
		final CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<GeopoliticalDivision> criteriaQuery = criteriaBuilder.createQuery(GeopoliticalDivision.class);
		final Root<GeopoliticalDivision> root = criteriaQuery.from(GeopoliticalDivision.class);
		
		criteriaQuery.select(root).where(criteriaBuilder.isNull(root.get("idRoot")));
		return this.getEntityManager().createQuery(criteriaQuery).getResultList();
	}
	
	public Collection<GeopoliticalDivision> findGeopoliticalDivisionById(Long id){
		final CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<GeopoliticalDivision> criteriaQuery = criteriaBuilder.createQuery(GeopoliticalDivision.class);
		final Root<GeopoliticalDivision> root = criteriaQuery.from(GeopoliticalDivision.class);
		
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"), id));
		return this.getEntityManager().createQuery(criteriaQuery).getResultList();
	}
	
	

}