/**
 * 
 */
package ec.com.gesso.repository.test.integration;

import java.io.Serializable;

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
		"gesso-criteria.xml",
		"gesso-persistencia.xml",
		"gesso-transactions.xml",
		"classpath:ec/com/gesso/persistence/resources/spring/config/gesso-repository.xml" })
public abstract class BaseRepositoryIntegration <Entity extends Serializable>{
	
	protected IRepositoryEntity<Entity> repository;
	@Autowired protected ApplicationContext applicationContext;

}
