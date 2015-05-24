/**
 * 
 */
package ec.com.gesso.repository.test.integration;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ec.com.gesso.repository.IRepositoryEntity;

/**
 * @author Gabriel
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"gesso-transactions.xml",
		"gesso-persistencia.xml",
		"classpath:ec/com/gesso/persistence/resources/spring/config/gesso-repository.xml" })
public abstract class BaseRepositoryIntegration{
	
	protected IRepositoryEntity repository;
	
	@Autowired 
	protected ApplicationContext applicationContext;

}
