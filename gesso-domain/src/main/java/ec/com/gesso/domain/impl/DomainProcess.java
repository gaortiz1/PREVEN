/**
 * 
 */
package ec.com.gesso.domain.impl;

import ec.com.gesso.domain.IDomainEntity;
import ec.com.gesso.model.entity.Process;
import ec.com.gesso.model.entity.SubProcess;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class DomainProcess extends BaseDomainEntity<Process> {
	
	private IDomainEntity<SubProcess> domainSubProcess;
	
	public Process register(final Process process) {
		if(null == process) {
			throw new ValidationEntity("No se puede insert un valor null");
		}
		if(null == process.getName()) {
			throw new ValidationEntity("El campo name es null");
		}
		
		if(null == process.getDescription()) {
			throw new ValidationEntity("El campo Description es null");
		}
		
		if (process.getId() == null) {
			process.setStatus(Boolean.TRUE);
			this.repositoryEntity.add(process);
		} else {
			this.repositoryEntity.update(process);
		}
		
		if(process.getSubLevels() != null && !process.getSubLevels().isEmpty()) {
			
			for(final Process subLevel : process.getSubLevels()) {
				subLevel.setIdRoot(process.getId());
				this.register(subLevel);
			}
		}
		
		if(process.getSubProcesses() != null && !process.getSubProcesses().isEmpty()) {
			
			for(final SubProcess subProcess : process.getSubProcesses()) {
				subProcess.setIdProcess(process.getId());
				this.domainSubProcess.register(subProcess);
			}
		}
		
		return process;
	}

	/**
	 * @param domainSubProcess the domainSubProcess to set
	 */
	public void setDomainSubProcess(final IDomainEntity<SubProcess> domainSubProcess) {
		this.domainSubProcess = domainSubProcess;
	}

}
