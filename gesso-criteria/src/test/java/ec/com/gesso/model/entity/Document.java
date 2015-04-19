/**
 * 
 */
package ec.com.gesso.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Gabriel
 *
 */
@Entity
@Table(name = "DOCUMENT")
public class Document implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	protected DocumentPK idDocument;
	
	@Column(name = "ID_COMPANY")
    private Long idCompany;
	
	@Column(name = "ID_PERSON")
    private Long idPerson;
	
	@Column(name = "VALUE_DOCUMENT")
    private String value;
	
	@Column(name = "STATE_DOCUMENT")
	private Boolean state;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_COMPANY", referencedColumnName="ID_COMPANY", insertable=false, updatable=false)
	private Company company;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_TYPE_DOCUMENT", referencedColumnName="id_catalog", insertable=false, updatable=false)
	private Catalog typeDocument;

	/**
	 * @return the idDocument
	 */
	public DocumentPK getIdDocument() {
		return idDocument;
	}

	/**
	 * @param idDocument the idDocument to set
	 */
	public void setIdDocument(DocumentPK idDocument) {
		this.idDocument = idDocument;
	}

	/**
	 * @return the idCompany
	 */
	public Long getIdCompany() {
		return idCompany;
	}

	/**
	 * @param idCompany the idCompany to set
	 */
	public void setIdCompany(Long idCompany) {
		this.idCompany = idCompany;
	}

	/**
	 * @return the idPerson
	 */
	public Long getIdPerson() {
		return idPerson;
	}

	/**
	 * @param idPerson the idPerson to set
	 */
	public void setIdPerson(Long idPerson) {
		this.idPerson = idPerson;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the state
	 */
	public Boolean getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(Boolean state) {
		this.state = state;
	}

	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}
	
	/**
	 * @param typeDocument the typeDocument to set
	 */
	public void setTypeDocument(Catalog typeDocument) {
		this.typeDocument = typeDocument;
	}

}
