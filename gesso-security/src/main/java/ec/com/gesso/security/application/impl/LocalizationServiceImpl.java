package ec.com.gesso.security.application.impl;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.CountryDto;

import java.util.Collection;

import ec.com.gesso.security.application.ILocalizationService;
import ec.com.gesso.security.domain.model.localization.ILocalizationRepository;

/**
 * @author roberto
 *
 */
public class LocalizationServiceImpl implements ILocalizationService{
	private ILocalizationRepository localizationRepository;
	
	public void setLocalizationRepository(
			ILocalizationRepository localizationRepository) {
		this.localizationRepository = localizationRepository;
	}


	@Override
	public Collection<CountryDto> findCountry() throws GessoException {
		return localizationRepository.findCountry();
	}
	
}
