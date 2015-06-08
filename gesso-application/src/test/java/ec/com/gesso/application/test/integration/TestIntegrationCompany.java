package ec.com.gesso.application.test.integration;

import org.junit.Before;
import org.junit.Test;

import ec.com.gesso.application.factory.GessoServiceFactory;
import ec.com.gesso.application.lang.CompanyBuilder;
import ec.com.gesso.model.entity.Company;

public class TestIntegrationCompany {

	private CompanyBuilder companyBuilder = new CompanyBuilder();
	private Company company;
	
	@Before
	public void setUp() throws Exception {
		company = companyBuilder.createNameCompany("empresa abc")
				.addDocument("RUC", "1717189235001")
				.addDocument("RUC", "1717189235001")
				.addActivityEconomic(null, "PRINC","ActivityEconomic 1")
				.addActivityEconomic(null, "SECUN","ActivityEconomic 2")
				.addRazonSocial("Razon social")
				.addGeopoliticalDivision(8l)
				.addTypeCompany("MICRO")
				.addScheduleWork("J8")
				.addScheduleWork("JC")
				.addProductiveSector("BR")
				.addAddress(null, "calle abc")
				.addAddress(null, "calle 2")
				.addEmail(null, "bisbiridolfo@hotmail.com")
				.addEmail(null, "gabrielortiz260388@hotmail.com")
				.addPhone(null, "0999090909", "CEL")
				.addPhone(null, "123213", "TEL")
				.build();
	}
	
	@Test
	public void testCreateCompanyWithFactory(){
		GessoServiceFactory.getInstance().getServiceCompany().register(company);
	}
}
