/**
 * 
 */
package ec.com.gesso.domain.impl;

import java.util.Collection;

import ec.com.gesso.domain.IDomainEntity;
import ec.com.gesso.domain.validator.impl.ValidatorCompany;
import ec.com.gesso.model.entity.ActivityEconomicCompany;
import ec.com.gesso.model.entity.Company;
import ec.com.gesso.model.entity.ContactData;
import ec.com.gesso.model.entity.Document;
import ec.com.gesso.model.entity.ScheduleWork;
import ec.com.gesso.repository.IRepositoryEntity;

/**
 * @author Gabriel
 *
 */
public class DomainCompany implements IDomainEntity<Company> {
	
	private IRepositoryEntity<Company> repositoryCompany;
	private IRepositoryEntity<ActivityEconomicCompany> repositoryActivityEconomicCompany;
	private IRepositoryEntity<ScheduleWork> repositoryScheduleWork;
	private IDomainEntity<ContactData> domainContactData;
	private IDomainEntity<Document> domainDocument;

	/*
	 * (non-Javadoc)
	 * @see ec.com.gesso.domain.IDomainEntity#create(java.io.Serializable)
	 */
	public Company create(final Company company) {
		
		ValidatorCompany validatorCompany = new ValidatorCompany();
		validatorCompany.validate(company);
		
		this.repositoryCompany.create(company);
		
		this.createCollectionDocument(company.getDocumentCollection(), company.getId());
		
		this.createCollectionScheduleWork(company.getScheduleWorkCollection(), company.getId());
		
		this.createCollectionActivityEconomicCompany(company.getActivityEconomicCompanyCollection(), company.getId());
		
		this.createCollectionContactData(company.getContactDataCollection(), company.getId());
		
		return company;
	}
	
	private void createCollectionDocument(final Collection<Document> collectionDocuments, final Long idCompany) {
		if(collectionDocuments != null) {
			for(final Document document : collectionDocuments){
				document.setIdCompany(idCompany);
				this.domainDocument.create(document);
			}
		}
	}
	
	private void createCollectionScheduleWork(final Collection<ScheduleWork> collectionScheduleWorks, final Long idCompany) {
		if(collectionScheduleWorks != null) {
			for(final ScheduleWork scheduleWork : collectionScheduleWorks) {
				
				if(scheduleWork.getIdScheduleWork() != null) {
					scheduleWork.getIdScheduleWork().setIdCompany(idCompany);
				}
				
				this.repositoryScheduleWork.create(scheduleWork);
			}
		}
	}
	
	private void createCollectionActivityEconomicCompany(final Collection<ActivityEconomicCompany> collectionActivityEconomicCompany, final Long idCompany) {
		if(collectionActivityEconomicCompany != null) {
			for(final ActivityEconomicCompany activityEconomicCompany : collectionActivityEconomicCompany){
				activityEconomicCompany.setIdCompany(idCompany);
				this.repositoryActivityEconomicCompany.create(activityEconomicCompany);	
			}
		}
	}
	
	private void createCollectionContactData(final Collection<ContactData> collectionContactData, final Long idCompany) {
		if(collectionContactData != null){
			for(final ContactData contactData : collectionContactData) {
				contactData.setIdCompany(idCompany);
				this.domainContactData.create(contactData);
			}
			
		}
	}

	/**
	 * @param repositoryCompany the repositoryCompany to set
	 */
	public void setRepositoryCompany(IRepositoryEntity<Company> repositoryCompany) {
		this.repositoryCompany = repositoryCompany;
	}

	/**
	 * @param repositoryActivityEconomicCompany the repositoryActivityEconomicCompany to set
	 */
	public void setRepositoryActivityEconomicCompany(IRepositoryEntity<ActivityEconomicCompany> repositoryActivityEconomicCompany) {
		this.repositoryActivityEconomicCompany = repositoryActivityEconomicCompany;
	}

	/**
	 * @param domainDocument the domainDocument to set
	 */
	public void setDomainDocument(IDomainEntity<Document> domainDocument) {
		this.domainDocument = domainDocument;
	}

	/**
	 * @param repositoryScheduleWork the repositoryScheduleWork to set
	 */
	public void setRepositoryScheduleWork(IRepositoryEntity<ScheduleWork> repositoryScheduleWork) {
		this.repositoryScheduleWork = repositoryScheduleWork;
	}

	/**
	 * @param domainContactData the domainContactData to set
	 */
	public void setDomainContactData(IDomainEntity<ContactData> domainContactData) {
		this.domainContactData = domainContactData;
	}
}
