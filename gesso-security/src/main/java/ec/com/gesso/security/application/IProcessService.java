package ec.com.gesso.security.application;

import java.util.Collection;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Job;
import ec.com.gesso.model.entity.Process;
import ec.com.gesso.model.entity.SubProcess;
import ec.com.gesso.model.entity.UserProfile;

/**
 * @author roberto
 * pruebas friki
 *
 */
public interface IProcessService {
	/**
	 * @return
	 * @throws GessoException
	 */
	Collection<Process> findProcess() throws GessoException;
	Collection<SubProcess> findSubProcess(Long idProcess) throws GessoException;
	Collection<Job> findJobs(Long idSubProcess) throws GessoException;
	
	void persisNewProcess(Process process) throws GessoException;
	void persisNewSubProcess(SubProcess subProcess) throws GessoException;
	/**
	 * @param job
	 * @throws GessoException
	 */
	void persisNewJob(Job job) throws GessoException;
}
