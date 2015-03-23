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
		assertEquals(Integer.parseInt("1"),contactDataBuilder.addEmail("a").build().getCollectionEmails().size());
	}
	
	@Test
	public void testaddAddress(){
		assertEquals(Integer.parseInt("1"),contactDataBuilder.addAddress("a").build().getCollectionAddress().size());
	}
	
	@Test
	public void testaddPhone(){
		assertEquals(Integer.parseInt("1"),contactDataBuilder.addPhone("a", "099990909").build().getCollectionPhones().size());
	}
	
	@Test
	public void testContactDataEmpty(){
		assertNotEquals(null, contactDataBuilder.build());
	}

}
