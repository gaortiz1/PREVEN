/**
 * 
 */
package ec.com.gesso.domain.test.integration;

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
		"classpath:ec/com/gesso/persistence/resources/spring/config/gesso-repository.xml",
		"gesso-persistencia.xml", 
		"classpath:ec/com/gesso/domain/resource/spring/config/gesso-domain.xml",
		"gesso-transactions.xml" })
public abstract class AbstractModelIntegration {
	
	@Autowired protected ApplicationContext applicationContext;

}
