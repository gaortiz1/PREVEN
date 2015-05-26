/**
 * 
 */
package ec.com.gesso.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Gabriel
 *
 */
@Embeddable
public class ProbabilityConsequencePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "ID_PROBABILITY")
	private String idProbability;
	
	@Column(name = "ID_CONSEQUENCES")
	private String idConsequence;

	/**
	 * 
	 */
	public ProbabilityConsequencePK() {
	}

	/**
	 * @param idProbability
	 * @param idConsequence
	 */
	public ProbabilityConsequencePK(String idProbability, String idConsequence) {
		this.idProbability = idProbability;
		this.idConsequence = idConsequence;
	}

	/**
	 * @return the idProbability
	 */
	public String getIdProbability() {
		return idProbability;
	}

	/**
	 * @param idProbability the idProbability to set
	 */
	public void setIdProbability(String idProbability) {
		this.idProbability = idProbability;
	}

	/**
	 * @return the idConsequence
	 */
	public String getIdConsequence() {
		return idConsequence;
	}

	/**
	 * @param idConsequence the idConsequence to set
	 */
	public void setIdConsequence(String idConsequence) {
		this.idConsequence = idConsequence;
	}
}
