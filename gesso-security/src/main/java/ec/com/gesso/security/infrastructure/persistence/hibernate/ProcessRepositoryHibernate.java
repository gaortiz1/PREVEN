package ec.com.gesso.security.infrastructure.persistence.hibernate;

import java.util.Collection;

import ec.com.gesso.model.entity.UserProfile;
import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Job;
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
		criteria.createAlias("subProcesses", "subProcessesA", JoinType.LEFT_OUTER_JOIN);
		criteria.setFetchMode("subProcessesA", FetchMode.SELECT);
		
//		criteria.createAlias("subProcessesA.jobs", "jobsA", JoinType.LEFT_OUTER_JOIN);
//		criteria.setFetchMode("jobsA", FetchMode.SELECT);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		Collection<Process> lst = criteria.list();
		
		return lst;
	}
	
	@Override
	public Collection<Job> findJobs(Long idSubProcess){
		Criteria criteria =  null;
		criteria =  getSession().createCriteria(Job.class);
		criteria.add(Restrictions.eq("idSubProcess", idSubProcess));
		Collection<Job> lst = criteria.list();
		if(lst != null && CollectionUtils.isNotEmpty(lst)){
			return criteria.list();
		}
		return null;
		
	}

	@Override
	public Collection<SubProcess> findSubProcess(Long idProcess) throws GessoException {
		Criteria criteria =  null;
		criteria =  getSession().createCriteria(SubProcess.class);
		criteria.add(Restrictions.eq("idProcess", idProcess));
		return criteria.list();
	}

	@Override
	public void persisNewProcess(Process process)
			throws GessoException {
		
		try {
			process.setStatus(Boolean.TRUE);
			getSession().persist(process);
			getSession().flush();
		} catch (Exception e) {
			e.printStackTrace();
			throw new GessoException(e.getCause());
		}
	}

	@Override
	public void persisNewSubProcess(SubProcess subProcess)
			throws GessoException {
		try {
			subProcess.setState(Boolean.TRUE);
			getSession().persist(subProcess);
			getSession().flush();
		} catch (Exception e) {
			e.printStackTrace();
			throw new GessoException(e.getCause());
		}
	}

	@Override
	public void persisNewJob(Job job) throws GessoException {
		try {
			job.setState(Boolean.TRUE);
			getSession().persist(job);
			getSession().flush();
		} catch (Exception e) {
			e.printStackTrace();
			throw new GessoException(e.getCause());
		}
	}



}
