/**
 * 
 */
package ec.com.gesso.criteria.test.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Gabriel
 *
 */
@Embeddable
public class JobRiskPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "ID_JOB")
	private Long idJob;
	
	@Column(name = "ID_RISK")
	private Long idRisk;

	/**
	 * @return the idJob
	 */
	public Long getIdJob() {
		return idJob;
	}

	/**
	 * @param idJob the idJob to set
	 */
	public void setIdJob(Long idJob) {
		this.idJob = idJob;
	}

	/**
	 * @return the idRisk
	 */
	public Long getIdRisk() {
		return idRisk;
	}

	/**
	 * @param idRisk the idRisk to set
	 */
	public void setIdRisk(Long idRisk) {
		this.idRisk = idRisk;
	}
}
