/**
 * 
 */
package ec.com.gesso.application.test.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import ec.com.gesso.application.lang.ContactDataBuilder;

/**
 * @author Gabriel
 *
 */
public class TestBuilContactData {
	
	private ContactDataBuilder contactDataBuilder;
	
	@Before
	public void setUp() throws Exception {
		this.contactDataBuilder = new ContactDataBuilder();
	}
	
	@Test
	public void testaddEmail(){
		assertEquals(Integer.parseInt("1"),contactDataBuilder.addEmail(null, "a").build().getEmails().size());
	}
	
	@Test
	public void testaddAddress(){
		assertEquals(Integer.parseInt("1"),contactDataBuilder.addAddress(null, "a").build().getAddresses().size());
	}
	
	@Test
	public void testaddPhone(){
		assertEquals(Integer.parseInt("1"),contactDataBuilder.addPhone(null, "a", "099990909").build().getPhones().size());
	}
	
	@Test
	public void testContactDataEmpty(){
		assertNotEquals(null, contactDataBuilder.build());
	}

}
