/**
 * 
 */
package ec.com.gesso.mail.model.impl;

import java.io.Serializable;
import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import ec.com.gesso.mail.model.IModelMessage;

/**
 * @author Gabriel
 *
 */
public class ModelMessageNotifier implements IModelMessage, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String messageTitle; 
	private final String content;
	
	/**
	 * @param title
	 * @param messageTitle
	 * @param content
	 */
	public ModelMessageNotifier(String messageTitle, String content) {
		this.messageTitle = messageTitle;
		this.content = content;
	}

	@Override
	public String getText() {
		
		final VelocityEngine ve = new VelocityEngine();
		ve.setProperty("resource.loader", "class");
		ve.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
	    ve.init();
	    
	    final VelocityContext context = new VelocityContext();
        context.put("notifierModel", this);
        
        final Template template = ve.getTemplate( "ec/com/gesso/domain/resource/velocity/notifier.vm" );
	    
        final StringWriter result = new StringWriter();
        template.merge(context, result);
		return result.toString();
	}

	/**
	 * @return the messageTitle
	 */
	public String getMessageTitle() {
		return messageTitle;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

}
