/**
 * 
 */
package ec.com.gesso.domain.impl;

import ec.com.gesso.domain.IDomainEntity;
import ec.com.gesso.model.entity.Process;
import ec.com.gesso.model.entity.SubProcess;
import ec.com.gesso.repository.IRepositoryEntity;

/**
 * @author Gabriel
 *
 */
public class DomainProcess implements IDomainEntity<Process> {
	
	private IRepositoryEntity<Process> repositoryProcess;
	private IDomainEntity<SubProcess> domainSubProcess;

	public Process create(Process process) {
		
		this.repositoryProcess.create(process);
		
		if(process.getSubLevels() != null && !process.getSubLevels().isEmpty()) {
			
			for(final Process subLevel : process.getSubLevels()) {
				subLevel.setIdRoot(process.getId());
				this.create(subLevel);
			}
		}
		
		if(process.getSubProcesses() != null && !process.getSubProcesses().isEmpty()) {
			
			for(final SubProcess subProcess : process.getSubProcesses()) {
				subProcess.setIdProcess(process.getId());
				this.domainSubProcess.create(subProcess);
			}
		}
		
		return process;
	}

	/**
	 * @param repositoryProcess the repositoryProcess to set
	 */
	public void setRepositoryProcess(IRepositoryEntity<Process> repositoryProcess) {
		this.repositoryProcess = repositoryProcess;
	}

	/**
	 * @param domainSubProcess the domainSubProcess to set
	 */
	public void setDomainSubProcess(IDomainEntity<SubProcess> domainSubProcess) {
		this.domainSubProcess = domainSubProcess;
	}

}
