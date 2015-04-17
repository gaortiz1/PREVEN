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
						"ec/com/gesso/application/resource/spring/config/gesso-transactions.xml",
						"ec/com/gesso/persistence/resources/spring/config/gesso-persistencia.xml", 
						"ec/com/gesso/persistence/resources/spring/config/gesso-criteria.xml", 
						"ec/com/gesso/application/resource/spring/config/gesso-application-criteria.xml"
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
