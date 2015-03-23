package ec.com.gesso.application.test.unit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ec.com.gesso.application.lang.CompanyBuilder;

public class TestBuildCompany {
	
	private CompanyBuilder companyBuilder;

	@Before
	public void setUp() throws Exception {
		this.companyBuilder = new CompanyBuilder();
	}

	@Test
	public void testAddNombre() {
		assertEquals("Company ANC", this.companyBuilder.createNameCompany("Company ANC").build().getName());
	}
	
	@Test
	public void testaddActivityEconomic() {
		assertEquals(Integer.parseInt("2"), this.companyBuilder.addActivityEconomic("1").addActivityEconomic("2").build().getActivityEconomicCompanyCollection().size());
	}
	
	@Test
	public void testaddTypeCompany() {
		assertEquals("MED", this.companyBuilder.addTypeCompany("MED").build().getIdTypeCompany());
	}
	
	@Test
	public void testaddIdsScheduleWork() {
		assertEquals(Integer.parseInt("2"), this.companyBuilder.addScheduleWork("J8").addScheduleWork("J9").build().getScheduleWorkCollection().size());
	}
	
	@Test
	public void testaddIdsProductiveSector() {
		assertEquals("2", this.companyBuilder.addProductiveSector("2").build().getIdProductiveSector());
	}
	
	@Test
	public void testaddDocument() {
		assertEquals(Integer.parseInt("1"), this.companyBuilder.addDocument("CI", "1717189235").build().getDocumentCollection().size());
	}
	

}
