/**
 * 
 */
package ec.com.gesso.application.lang;

import ec.com.gesso.model.entity.JobRisk;
import ec.com.gesso.model.entity.JobRiskPK;


/**
 * @author Gabriel
 *
 */
public class JobRiskBuilder implements IEntityBuilder<JobRisk> {
	
	private Long idJob;
	private Long idRisk;
	private String idProbability;
	private String idConsequence;
	private Boolean state;
	/**
	 * @param idJob the idJob to add
	 */
	public JobRiskBuilder addIdJob(Long idJob) {
		this.idJob = idJob;
		return this;
	}
	/**
	 * @param idRisk the idRisk to add
	 */
	public JobRiskBuilder addIdRisk(Long idRisk) {
		this.idRisk = idRisk;
		return this;
	}
	/**
	 * @param idProbability the idProbability to add
	 */
	public JobRiskBuilder addIdProbability(String idProbability) {
		this.idProbability = idProbability;
		return this;
	}
	/**
	 * @param idConsequence the idConsequence to add
	 */
	public JobRiskBuilder addIdConsequence(String idConsequence) {
		this.idConsequence = idConsequence;
		return this;
	}
	/**
	 * @param state the state to add
	 */
	public JobRiskBuilder addState(Boolean state) {
		this.state = state;
		return this;
	}
	public JobRisk build() {
		final JobRisk jobRisk = new JobRisk();
		jobRisk.setId(new JobRiskPK());
		jobRisk.getId().setIdJob(this.idJob);
		jobRisk.getId().setIdRisk(this.idRisk);
		jobRisk.setIdConsequence(this.idConsequence);
		jobRisk.setIdProbability(this.idProbability);
		jobRisk.setState(this.state);
		return jobRisk;
	}

}
