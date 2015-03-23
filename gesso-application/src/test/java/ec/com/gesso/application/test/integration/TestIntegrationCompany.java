package ec.com.gesso.application.test.integration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ec.com.gesso.application.lang.CompanyBuilder;
import ec.com.gesso.application.service.IServiceEntity;
import ec.com.gesso.model.entity.Company;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
		"gesso-transactions.xml",
		"gesso-persistencia.xml", "gesso-repository.xml", "gesso-domain.xml",
		"gesso-application.xml" })
public class TestIntegrationCompany {

	private IServiceEntity<Company> serviceCompany;
	private CompanyBuilder companyBuilder = new CompanyBuilder();
	@Autowired
	private ApplicationContext applicationContext;

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
}
