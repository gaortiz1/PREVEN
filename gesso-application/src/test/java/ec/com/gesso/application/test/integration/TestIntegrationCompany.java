package ec.com.gesso.application.test.integration;

import org.junit.Before;
import org.junit.Test;

import ec.com.gesso.application.factory.GessoFactory;
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
				.addActivityEconomic("nada")
				.addActivityEconomic("nada 2")
				.addGeopoliticalDivision(8l)
				.addTypeCompany("MICRO")
				.addScheduleWork("J8")
				.addScheduleWork("JC")
				.addProductiveSector("BR")
				.addAddress("calle abc")
				.addAddress("calle 2")
				.addEmail("asd")
				.addEmail("dasdas")
				.addPhone("0999090909", "CEL")
				.addPhone("123213", "TEL")
				.build();
	}
	
	@Test
	public void testCreateCompanyWithFactory() {
		GessoFactory.getInstance().getServiceCompany().register(company);
	}
}
