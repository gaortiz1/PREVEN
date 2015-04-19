/**
 * 
 */
package ec.com.gesso.criteria.entity.attribute;


/**
 * @author gortiz
 *
 */
public abstract class AbstractAttribute {
	
	private final String nombreCampo;

	protected AbstractAttribute(final String nombreCampo) {
		this.nombreCampo = nombreCampo;
	}

	/**
	 * @return the nombreCampo
	 */
	public final String getNombreCampo() {
		return nombreCampo;
	}
}
