package ec.com.gesso.security.application;

import java.util.Collection;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.CountryDto;

/**
 * @author roberto
 *
 */
public interface ILocalizationService {
	public Collection<CountryDto> findCountry() throws GessoException;

}
