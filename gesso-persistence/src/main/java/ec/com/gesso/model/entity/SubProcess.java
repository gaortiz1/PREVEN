package ec.com.gesso.model.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * 
 * @author Gabriel
 *
 */
@Entity
@Table(name = "SUBPROCESS")
public class SubProcess implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional = false)
	@Column(name = "ID_SUBPROCESS")
	private Long id;
	
	@Column(name = "ID_SUBPROCESS_ROOT")
	private Long idRoot;
	
	@Column(name = "ID_PROCESS")
	private Long idProcess;
	
	@Column(name = "NAME_SUBPROCESS")
	private String name;
	
	@Column(name = "DESCRIPTION_SUBPROCESS")
	private String description;
	
	@Column(name = "STATUS_SUBPROCESS")
	private Boolean status; 
	
	@JoinColumn(name = "ID_SUBPROCESS_ROOT", referencedColumnName = "ID_SUBPROCESS_ROOT", insertable=false, updatable=false)
	@ManyToOne(fetch = FetchType.LAZY)
	private SubProcess levelSubProcessRoot;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_PROCESS", referencedColumnName = "ID_PROCESS", insertable=false, updatable=false)
	private Process processRoot;
	
	@OneToMany(mappedBy="subProcessRoot")
	private Collection<Job> jobs;
	
	@OneToMany(mappedBy="levelSubProcessRoot")
	private Collection<SubProcess> subLevels;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the idRoot
	 */
	public Long getIdRoot() {
		return idRoot;
	}

	/**
	 * @param idRoot the idRoot to set
	 */
	public void setIdRoot(Long idRoot) {
		this.idRoot = idRoot;
	}

	/**
	 * @return the idProcess
	 */
	public Long getIdProcess() {
		return idProcess;
	}

	/**
	 * @param idProcess the idProcess to set
	 */
	public void setIdProcess(Long idProcess) {
		this.idProcess = idProcess;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the status
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	/**
	 * @return the levelSubProcessRoot
	 */
	public SubProcess getLevelSubProcessRoot() {
		return levelSubProcessRoot;
	}

	/**
	 * @param levelSubProcessRoot the levelSubProcessRoot to set
	 */
	public void setLevelSubProcessRoot(SubProcess levelSubProcessRoot) {
		this.levelSubProcessRoot = levelSubProcessRoot;
	}

	/**
	 * @return the processRoot
	 */
	public Process getProcessRoot() {
		return processRoot;
	}

	/**
	 * @param processRoot the processRoot to set
	 */
	public void setProcessRoot(Process processRoot) {
		this.processRoot = processRoot;
	}

	/**
	 * @return the jobs
	 */
	public Collection<Job> getJobs() {
		return jobs;
	}

	/**
	 * @param jobs the jobs to set
	 */
	public void setJobs(Collection<Job> jobs) {
		this.jobs = jobs;
	}

	/**
	 * @return the subLevels
	 */
	public Collection<SubProcess> getSubLevels() {
		return subLevels;
	}

	/**
	 * @param subLevels the subLevels to set
	 */
	public void setSubLevels(Collection<SubProcess> subLevels) {
		this.subLevels = subLevels;
	}
}
