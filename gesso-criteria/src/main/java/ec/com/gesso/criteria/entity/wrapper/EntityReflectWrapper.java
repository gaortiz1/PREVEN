/**
 * 
 */
package ec.com.gesso.criteria.entity.wrapper;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * @author gortiz
 *
 */
public final class EntityReflectWrapper {
	
	private EntityReflectWrapper(){ }
	
	
	public static Object getProperty(final Object object, final String nombreMetodo) {
		try {
			return PropertyUtils.getProperty(object, nombreMetodo);
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
			return null;
		}
	}

	
	public static void setProperty(final Object object, final String nombreMetodo, final Object value){
		try {
			PropertyUtils.setProperty(object, nombreMetodo, value);
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
	
}
