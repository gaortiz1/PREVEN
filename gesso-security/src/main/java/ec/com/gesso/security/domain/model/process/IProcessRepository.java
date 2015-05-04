package ec.com.gesso.security.domain.model.process;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Job;
import ec.com.gesso.model.entity.Process;
import ec.com.gesso.model.entity.SubProcess;

import java.util.Collection;

/**
 * @author roberto
 *
 */
public interface IProcessRepository {
	Collection<Process> findProcess() throws GessoException;
	Collection<SubProcess> findSubProcess(Long idProcess) throws GessoException;
	Collection<Job> findJobs(Long idSubProcess) throws GessoException;
	void persisNewProcess(Process process) throws GessoException;
	void persisNewSubProcess(SubProcess subProcess) throws GessoException;
	void persisNewJob(Job job) throws GessoException;
}
