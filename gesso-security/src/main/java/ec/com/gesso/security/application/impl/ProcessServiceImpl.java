package ec.com.gesso.security.application.impl;

import java.util.Collection;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Process;
import ec.com.gesso.security.application.IProcessService;
import ec.com.gesso.security.domain.model.process.IProcessRepository;

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
}
