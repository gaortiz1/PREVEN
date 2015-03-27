package ec.com.gesso.security.domain.model.process;

import java.util.Collection;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Process;
import ec.com.gesso.model.entity.SubProcess;

/**
 * @author roberto
 *
 */
public interface IProcessRepository {
	public Collection<Process> findProcess() throws GessoException;
	public Collection<SubProcess> findSubProcess(Long idProcess) throws GessoException;
}
