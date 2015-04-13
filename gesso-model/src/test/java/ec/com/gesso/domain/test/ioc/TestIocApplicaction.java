package ec.com.gesso.domain.test.ioc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @author Gabriel
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
		"classpath:ec/com/gesso/domain/resource/spring/config/gesso-domain.xml",
		"classpath:ec/com/gesso/persistence/resources/spring/config/gesso-repository.xml",
		"classpath:ec/com/gesso/persistence/resources/spring/config/gesso-persistencia.xml"
		})
public class TestIocApplicaction {
	
	@Autowired protected ApplicationContext applicationContext;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
	}

}
