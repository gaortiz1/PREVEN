package ec.com.gesso.security.infrastructure.persistence.hibernate;

import java.util.Collection;

import org.hibernate.Criteria;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.CountryDto;
import ec.com.gesso.security.domain.model.localization.ILocalizationRepository;

public class LocalizationRepositoryHibernate extends HibernateRepository implements ILocalizationRepository{

	@Override
	public Collection<CountryDto> findCountry() throws GessoException {
		Criteria criteria =  null;
		criteria =  getSession().createCriteria(CountryDto.class);
		
		return criteria.list();
	}

}
