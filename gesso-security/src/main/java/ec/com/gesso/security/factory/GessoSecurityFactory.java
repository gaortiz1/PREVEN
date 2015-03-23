package ec.com.gesso.security.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ec.com.gesso.security.application.ICatalogService;
import ec.com.gesso.security.application.ILocalizationService;
import ec.com.gesso.security.application.ISecurityService;

/**
 * @author roberto
 *
 */
public class GessoSecurityFactory {
	private static final GessoSecurityFactory GESSO_SECURITY_FACTORY = new GessoSecurityFactory();
	
	private ApplicationContext context =  null;
	
	private GessoSecurityFactory() {
		context = new ClassPathXmlApplicationContext(
				new String []{
						"ec/com/gesso/resources/spring/config/spring4.xml",
						"ec/com/gesso/resources/spring/config/gesso-services.xml",
						"ec/com/gesso/resources/spring/config/gesso-repository.xml",
						"ec/com/gesso/resources/spring/config/geso-transactions.xml"
			});
	}
	
	public void setContext(ApplicationContext context) {
		this.context = context;
	}

	public static GessoSecurityFactory getInstance() {
		return GESSO_SECURITY_FACTORY;
	}
	
	public ISecurityService getSecurityService(){
		return context.getBean("gesso-security-service", ISecurityService.class);
	}
	
	public ICatalogService getCatalogService(){
		return context.getBean("gesso-catalog-service", ICatalogService.class);
	}
	
	public ILocalizationService getLocalizationService(){
		return context.getBean("gesso-localization-service", ILocalizationService.class);
	}
}
