package ec.com.gesso.security.domain.model.process;

import java.util.Collection;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Job;
import ec.com.gesso.model.entity.Process;
import ec.com.gesso.model.entity.SubProcess;

/**
 * @author roberto
 *
 */
public interface IProcessRepository {
	public Collection<Process> findProcess() throws GessoException;
	public Collection<SubProcess> findSubProcess(Long idProcess) throws GessoException;
	
	public void persisNewProcess(Process process) throws GessoException;
	public void persisNewSubProcess(SubProcess subProcess) throws GessoException;
	public void persisNewJob(Job job) throws GessoException;
}
