/**
 * 
 */
package ec.com.gesso.domain.impl;

import java.util.Collection;

import ec.com.gesso.domain.IDomainEntity;
import ec.com.gesso.model.entity.ActivityEconomicCompany;
import ec.com.gesso.model.entity.Company;
import ec.com.gesso.model.entity.ContactData;
import ec.com.gesso.model.entity.Document;
import ec.com.gesso.model.entity.ScheduleWork;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class DomainCompany extends BaseDomainEntity<Company> {
	
	private IDomainEntity<ActivityEconomicCompany> domainActivityEconomicCompany;
	private IDomainEntity<ScheduleWork> domainScheduleWork;
	private IDomainEntity<ContactData> domainContactData;
	private IDomainEntity<Document> domainDocument;
	
	/*
	 * (non-Javadoc)
	 * @see ec.com.gesso.domain.IDomainEntity#register(java.io.Serializable)
	 */
	public Company register(final Company company) {
		
		this.validarCompany(company);
		
		if (company.getId() == null) {
			company.setState(Boolean.TRUE);
			this.repositoryEntity.create(company);
		} else{
			this.repositoryEntity.edit(company);
		}
		
		this.registerCollectionDocument(company.getDocumentCollection(), company.getId());
		
		this.registerCollectionScheduleWork(company.getScheduleWorkCollection(), company.getId());
		
		this.registerCollectionActivityEconomicCompany(company.getActivityEconomicCompanyCollection(), company.getId());
		
		this.registerCollectionContactData(company.getContactDataCollection(), company.getId());
		
		return company;
	}
	
	private void validarCompany(final Company company){
		
		if (null == company) {
			throw new ValidationEntity("No se puede insert un valor null");
		}
		if (null == company.getName()) {
			throw new ValidationEntity("El campo name es null");
		}
		
		if (null == company.getIdTypeCompany()) {
			throw new ValidationEntity("El campo TypeCompany es null");
		}
		
		if (null == company.getIdProductiveSector()) {
			throw new ValidationEntity("El campo ProductiveSector es null");
		}
	}
	
	private void registerCollectionDocument(final Collection<Document> collectionDocuments, final Long idCompany) {
		if(collectionDocuments != null) {
			for(final Document document : collectionDocuments){
				document.setIdCompany(idCompany);
				this.domainDocument.register(document);
			}
		}
	}
	
	private void registerCollectionScheduleWork(final Collection<ScheduleWork> collectionScheduleWorks, final Long idCompany) {
		if(collectionScheduleWorks != null) {
			for(final ScheduleWork scheduleWork : collectionScheduleWorks) {
				
				if(scheduleWork.getIdScheduleWork() != null) {
					scheduleWork.getIdScheduleWork().setIdCompany(idCompany);
				}
				
				this.domainScheduleWork.register(scheduleWork);
			}
		}
	}
	
	private void registerCollectionActivityEconomicCompany(final Collection<ActivityEconomicCompany> collectionActivityEconomicCompany, final Long idCompany) {
		if(collectionActivityEconomicCompany != null) {
			for(final ActivityEconomicCompany activityEconomicCompany : collectionActivityEconomicCompany){
				activityEconomicCompany.setIdCompany(idCompany);
				this.domainActivityEconomicCompany.register(activityEconomicCompany);	
			}
		}
	}
	
	private void registerCollectionContactData(final Collection<ContactData> collectionContactData, final Long idCompany) {
		if(collectionContactData != null){
			for(final ContactData contactData : collectionContactData) {
				contactData.setIdCompany(idCompany);
				this.domainContactData.register(contactData);
			}
			
		}
	}

	/**
	 * @param domainActivityEconomicCompany the domainActivityEconomicCompany to set
	 */
	public final void setDomainActivityEconomicCompany(final IDomainEntity<ActivityEconomicCompany> domainActivityEconomicCompany) {
		this.domainActivityEconomicCompany = domainActivityEconomicCompany;
	}

	/**
	 * @param domainScheduleWork the domainScheduleWork to set
	 */
	public final void setDomainScheduleWork(final IDomainEntity<ScheduleWork> domainScheduleWork) {
		this.domainScheduleWork = domainScheduleWork;
	}

	/**
	 * @param domainContactData the domainContactData to set
	 */
	public final void setDomainContactData(final IDomainEntity<ContactData> domainContactData) {
		this.domainContactData = domainContactData;
	}

	/**
	 * @param domainDocument the domainDocument to set
	 */
	public final void setDomainDocument(final IDomainEntity<Document> domainDocument) {
		this.domainDocument = domainDocument;
	}
}
