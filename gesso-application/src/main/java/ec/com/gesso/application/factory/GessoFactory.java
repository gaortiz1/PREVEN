package ec.com.gesso.application.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ec.com.gesso.application.service.IServiceEntity;
import ec.com.gesso.model.entity.Company;


/**
 * 
 * @author Gabriel
 *
 */
public final  class GessoFactory {
	
	private static final GessoFactory GESSO_FACTORY = new GessoFactory();
	
	private ApplicationContext context =  null;
	
	private GessoFactory() {
		context = new ClassPathXmlApplicationContext(
				new String []{
						"ec/com/gesso/application/resource/spring/config/gesso-transactions.xml",
						"ec/com/gesso/persistence/resources/spring/config/gesso-persistencia.xml", 
						"ec/com/gesso/persistence/resources/spring/config/gesso-repository.xml", 
						"ec/com/gesso/domain/resource/spring/config/gesso-domain.xml",
						"ec/com/gesso/application/resource/spring/config/gesso-application.xml"
			});
	}

	/**
	 * @return the gessoFactory
	 */
	public static GessoFactory getInstance() {
		return GESSO_FACTORY;
	}
	
	public IServiceEntity<Company> getServiceCompany(){
		return this.context.getBean("serviceCompany",IServiceEntity.class);
	}
	

}
