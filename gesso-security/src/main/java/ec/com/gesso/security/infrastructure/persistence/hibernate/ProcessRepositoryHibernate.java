package ec.com.gesso.security.infrastructure.persistence.hibernate;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Process;
import ec.com.gesso.model.entity.SubProcess;
import ec.com.gesso.security.domain.model.process.IProcessRepository;

/**
 * @author roberto
 *
 */
public class ProcessRepositoryHibernate extends HibernateRepository implements IProcessRepository{

	@Override
	public Collection<Process> findProcess() throws GessoException {
		Criteria criteria =  null;
		criteria =  getSession().createCriteria(Process.class);
		return criteria.list();
	}

	@Override
	public Collection<SubProcess> findSubProcess(Long idProcess) throws GessoException {
		Criteria criteria =  null;
		criteria =  getSession().createCriteria(SubProcess.class);
		criteria.add(Restrictions.eq("idProcess", idProcess));
		return criteria.list();
	}

}
