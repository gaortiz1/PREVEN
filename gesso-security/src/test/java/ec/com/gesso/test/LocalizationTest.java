package ec.com.gesso.test;

import java.util.Collection;

import org.junit.Test;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.CountryDto;
import ec.com.gesso.security.factory.GessoSecurityFactory;

public class LocalizationTest {
	@Test
	public void findCountry(){
		Collection<CountryDto> lstCountryDtos;
		try {
			lstCountryDtos = GessoSecurityFactory.getInstance().getLocalizationService().findCountry();
			for(CountryDto countryDto: lstCountryDtos){
				System.out.println(countryDto);
			}
		} catch (GessoException e) {
			e.printStackTrace();
		}
	}
}
