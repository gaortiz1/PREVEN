/**
 * 
 */
package ec.com.gesso.repository.impl;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import ec.com.gesso.model.entity.GeopoliticalDivision;
import ec.com.gesso.repository.IRepositoryCriteriaGeoPolDivi;

/**
 * @author Gabriel
 *
 */
public class RepositoryCriteriaGeoPolDivi extends BaseHibernateRepository implements IRepositoryCriteriaGeoPolDivi {

	public RepositoryCriteriaGeoPolDivi(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	public Collection<GeopoliticalDivision> findGeopoliticalDivisionRoot(Long idRoot){
		Criteria criteria =  null;
		criteria = getSession().createCriteria(GeopoliticalDivision.class);
		criteria.add(Restrictions.eq("idRoot", idRoot));
		return criteria.list();
	}
	
	public Collection<GeopoliticalDivision> findGeopoliticalDivisionWitoutRoot(){
		Criteria criteria =  null;
		criteria = getSession().createCriteria(GeopoliticalDivision.class);
		criteria.add(Restrictions.isNull("idRoot"));
		return criteria.list();
	}
	
	public Collection<GeopoliticalDivision> findGeopoliticalDivisionById(Long id){
		Criteria criteria =  null;
		criteria = getSession().createCriteria(GeopoliticalDivision.class);
		criteria.add(Restrictions.eq("id", id));
		return criteria.list();
	}
	
	

}