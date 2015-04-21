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
public class SearchCriteria {
	
private static final SearchCriteria SEARCH_CRITERIA = new SearchCriteria();
	
	private ApplicationContext context =  null;
	
	private SearchCriteria() {
		context = new ClassPathXmlApplicationContext(
				new String []{
						"classpath:ec/com/gesso/application/resource/spring/config/gesso-application.xml",
						"classpath:ec/com/gesso/application/resource/spring/config/gesso-criteria.xml", 
						"classpath:ec/com/gesso/application/resource/spring/config/gesso-persistencia.xml",
						"classpath:ec/com/gesso/application/resource/spring/config/gesso-transactions.xml",
						"classpath:ec/com/gesso/domain/resource/spring/config/gesso-domain.xml",
						"classpath:ec/com/gesso/persistence/resources/spring/config/gesso-repository.xml"
			});
	}

	/**
	 * @return the gessoFactory
	 */
	public static SearchCriteria getInstance() {
		return SEARCH_CRITERIA;
	}
	
	public IServiceCriteria getServiceCriteria(){
		return this.context.getBean("serviceCriteria",IServiceCriteria.class);
	}

}
