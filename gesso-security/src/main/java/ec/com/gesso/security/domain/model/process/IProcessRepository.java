package ec.com.gesso.security.domain.model.process;

import java.util.Collection;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Process;

/**
 * @author roberto
 *
 */
public interface IProcessRepository {
	public Collection<Process> findProcess() throws GessoException;
}
