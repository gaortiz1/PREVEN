package ec.com.gesso.security.application.impl;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Job;
import ec.com.gesso.model.entity.Process;
import ec.com.gesso.model.entity.SubProcess;
import ec.com.gesso.security.application.IProcessService;
import ec.com.gesso.security.domain.model.process.IProcessRepository;

import java.util.Collection;

/**
 * @author roberto
 *
 */
public class ProcessServiceImpl implements IProcessService{
	private IProcessRepository processRepository;
	
	public void setProcessRepository(IProcessRepository processRepository) {
		this.processRepository = processRepository;
	}

	@Override
	public Collection<Process> findProcess() throws GessoException {
		return processRepository.findProcess();
	}

	@Override
	public Collection<SubProcess> findSubProcess(Long idProcess) throws GessoException {
		return processRepository.findSubProcess(idProcess);
	}

	@Override
	public void persisNewProcess(Process process)
			throws GessoException {
		processRepository.persisNewProcess(process);
	}

	@Override
	public void persisNewSubProcess(SubProcess subProcess)
			throws GessoException {
		processRepository.persisNewSubProcess(subProcess);
	}

	@Override
	public void persisNewJob(Job job) throws GessoException {
		processRepository.persisNewJob(job);
	}

	@Override
	public Collection<Job> findJobs(Long idSubProcess) throws GessoException {
		// TODO Auto-generated method stub
		return processRepository.findJobs(idSubProcess);
	}
}
