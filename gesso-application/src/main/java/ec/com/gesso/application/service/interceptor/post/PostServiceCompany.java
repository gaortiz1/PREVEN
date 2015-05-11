/**
 * 
 */
package ec.com.gesso.application.service.interceptor.post;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

import ec.com.gesso.application.service.email.IServiceMail;
import ec.com.gesso.model.entity.Company;

/**
 * @author Gabriel
 *
 */
public class PostServiceCompany implements AfterReturningAdvice {
	
	private IServiceMail<Company> serviceMail;
	

	/* (non-Javadoc)
	 * @see org.springframework.aop.AfterReturningAdvice#afterReturning(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], java.lang.Object)
	 */
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		serviceMail.send((Company) returnValue);
	}


	/**
	 * @param serviceMail the serviceMail to set
	 */
	public void setServiceMail(IServiceMail<Company> serviceMail) {
		this.serviceMail = serviceMail;
	}

}
