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
	private Long idProbability;
	
	@Column(name = "ID_CONSEQUENCES")
	private Long idConsequence;

	/**
	 * @return the idProbability
	 */
	public Long getIdProbability() {
		return idProbability;
	}

	/**
	 * @param idProbability the idProbability to set
	 */
	public void setIdProbability(Long idProbability) {
		this.idProbability = idProbability;
	}

	/**
	 * @return the idConsequence
	 */
	public Long getIdConsequence() {
		return idConsequence;
	}

	/**
	 * @param idConsequence the idConsequence to set
	 */
	public void setIdConsequence(Long idConsequence) {
		this.idConsequence = idConsequence;
	}
}
