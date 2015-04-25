/**
 * 
 */
package ec.com.gesso.application.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ec.com.gesso.application.service.IServiceCriteria;

/**
 * @author Gabriel
 *
 */
public class GessoSearchCriteria {
	
private static final GessoSearchCriteria SEARCH_CRITERIA = new GessoSearchCriteria();
	
	private ApplicationContext context =  null;
	
	private GessoSearchCriteria() {
		context = new ClassPathXmlApplicationContext(
				new String []{
						"classpath:ec/com/gesso/application/resource/spring/config/gesso-criteria.xml", 
						"classpath:ec/com/gesso/application/resource/spring/config/gesso-persistencia.xml",
						"classpath:ec/com/gesso/application/resource/spring/config/gesso-transactions-jpa.xml"
			});
	}

	/**
	 * @return the gessoFactory
	 */
	public static GessoSearchCriteria getInstance() {
		return SEARCH_CRITERIA;
	}
	
	public IServiceCriteria getServiceCriteria(){
		return this.context.getBean("serviceCriteria",IServiceCriteria.class);
	}

}
