package ec.com.gesso.application.test.integration;

import org.junit.Before;
import org.junit.Test;

import ec.com.gesso.application.factory.GessoFactory;
import ec.com.gesso.application.lang.CompanyBuilder;
import ec.com.gesso.application.service.IServiceEntity;
import ec.com.gesso.model.entity.Company;

public class TestIntegrationCompany extends AbstractApplicationIntegration {

	private IServiceEntity<Company> serviceCompany;
	private CompanyBuilder companyBuilder = new CompanyBuilder();

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		this.serviceCompany = (IServiceEntity<Company>) applicationContext.getBean("serviceCompany");
	}

	@Test
	public void testCreateCompany() {
		final Company company = companyBuilder.createNameCompany("empresa abc")
				.addDocument("RUC", "1717189235001")
				.addDocument("RUC", "1717189235001")
				.addActivityEconomic("nada").addActivityEconomic("nada 2")
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
		this.serviceCompany.create(company);
	}
	
	@Test
	public void testCreateCompanyWithFactory() {
		final Company company = companyBuilder.createNameCompany("empresa abc")
				.addDocument("RUC", "1717189235001")
				.addDocument("RUC", "1717189235001")
				.addActivityEconomic("nada").addActivityEconomic("nada 2")
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
		GessoFactory.getInstance().getServiceCompany().create(company);
	}
}
