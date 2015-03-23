package ec.com.gesso.security.domain.model.localization;

import java.util.Collection;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.CountryDto;

/**
 * @author roberto
 *
 */
public interface ILocalizationRepository {
	public Collection<CountryDto> findCountry() throws GessoException;
}
