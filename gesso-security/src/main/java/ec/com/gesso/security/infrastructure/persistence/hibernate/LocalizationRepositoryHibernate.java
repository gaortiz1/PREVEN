package ec.com.gesso.security.infrastructure.persistence.hibernate;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.CountryDto;
import ec.com.gesso.security.domain.model.localization.ILocalizationRepository;
import org.hibernate.Criteria;

import java.util.Collection;

public class LocalizationRepositoryHibernate extends HibernateRepository implements ILocalizationRepository{

	@Override
	public Collection<CountryDto> findCountry() throws GessoException {
		Criteria criteria =  null;
		criteria =  getSession().createCriteria(CountryDto.class);
		
		return criteria.list();
	}

}
