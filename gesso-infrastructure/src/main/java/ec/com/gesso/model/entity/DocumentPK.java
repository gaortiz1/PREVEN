/**
 * 
 */
package ec.com.gesso.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Gabriel
 *
 */
@Embeddable
public class DocumentPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
    @Column(name = "ID_DOCUMENT")
    private Long idDocument;
	
    @Basic(optional = false)
    @Column(name = "ID_TYPE_DOCUMENT")
    private String idTypeDocument;

	/**
	 * @return the idDocument
	 */
	public Long getIdDocument() {
		return idDocument;
	}

	/**
	 * @param idDocument the idDocument to set
	 */
	public void setIdDocument(Long idDocument) {
		this.idDocument = idDocument;
	}

	/**
	 * @return the idTypeDocument
	 */
	public String getIdTypeDocument() {
		return idTypeDocument;
	}

	/**
	 * @param idTypeDocument the idTypeDocument to set
	 */
	public void setIdTypeDocument(String idTypeDocument) {
		this.idTypeDocument = idTypeDocument;
	} 
	
	

}
