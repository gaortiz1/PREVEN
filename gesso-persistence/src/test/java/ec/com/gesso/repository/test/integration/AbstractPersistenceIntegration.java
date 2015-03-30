/**
 * 
 */
package ec.com.gesso.repository.test.integration;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Gabriel
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"geso-transactions.xml",
		"gesso-persistencia-embedded.xml",
		"classpath:ec/com/gesso/persistence/resources/spring/config/gesso-repository.xml" })
public abstract class AbstractPersistenceIntegration {
	
	@Autowired protected ApplicationContext applicationContext;

}
