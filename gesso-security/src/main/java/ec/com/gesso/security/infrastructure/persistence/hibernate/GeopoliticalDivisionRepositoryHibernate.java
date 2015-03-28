package ec.com.gesso.security.infrastructure.persistence.hibernate;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.GeopoliticalDivision;
import ec.com.gesso.security.domain.model.geopoliticalDivisionRepository.IGeopoliticalDivisionRepository;

public class GeopoliticalDivisionRepositoryHibernate extends HibernateRepository implements IGeopoliticalDivisionRepository{

	@Override
	public Collection<GeopoliticalDivision> findGeopoliticalDivision(Long idGeopoliticalDivision) throws GessoException {
		Criteria criteria =  null;
		criteria = getSession().createCriteria(GeopoliticalDivision.class);
		criteria.add(Restrictions.eq("id", idGeopoliticalDivision));
		criteria.add(Restrictions.isNull("idRoot"));
		return criteria.list();
	}

	@Override
	public Collection<GeopoliticalDivision> findRoorGeopoliticalDivision(Long idRootGeopoliticalDivision) throws GessoException {
		Criteria criteria =  null;
		criteria = getSession().createCriteria(GeopoliticalDivision.class);
		criteria.add(Restrictions.eq("idRoot", idRootGeopoliticalDivision));
		
		return criteria.list();
	}
	
	@Override
	public Collection<GeopoliticalDivision> findAllGeopoliticalDivisionRoot() throws GessoException {
		Criteria criteria =  null;
		criteria = getSession().createCriteria(GeopoliticalDivision.class);
		criteria.add(Restrictions.isNull("idRoot"));
		return criteria.list();
	}

}
