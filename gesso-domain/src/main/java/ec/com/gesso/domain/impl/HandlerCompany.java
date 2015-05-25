/**
 * 
 */
package ec.com.gesso.domain.impl;

import java.util.Collection;

import ec.com.gesso.domain.IHandlerEntity;
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
public class HandlerCompany extends BaseHandlerEntity<Company> {
	
	private IHandlerEntity<ActivityEconomicCompany> handlerActivityEconomicCompany;
	private IHandlerEntity<ScheduleWork> handlerScheduleWork;
	private IHandlerEntity<ContactData> handlerContactData;
	private IHandlerEntity<Document> handlerDocument;
	
	/*
	 * (non-Javadoc)
	 * @see ec.com.gesso.domain.IHandlerEntity#register(java.io.Serializable)
	 */
	public Company register(final Company company) {
		
		this.validarCompany(company);
		
		if (company.getId() == null) {
			company.setState(Boolean.TRUE);
			this.repositoryEntity.add(company);
		} else{
			this.repositoryEntity.update(company);
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
			for(final Document documentTest : collectionDocuments){
				documentTest.setIdCompany(idCompany);
				this.handlerDocument.register(documentTest);
			}
		}
	}
	
	private void registerCollectionScheduleWork(final Collection<ScheduleWork> collectionScheduleWorks, final Long idCompany) {
		if(collectionScheduleWorks != null) {
			for(final ScheduleWork scheduleWork : collectionScheduleWorks) {
				
				if(scheduleWork.getIdScheduleWork() != null) {
					scheduleWork.getIdScheduleWork().setIdCompany(idCompany);
				}
				
				this.handlerScheduleWork.register(scheduleWork);
			}
		}
	}
	
	private void registerCollectionActivityEconomicCompany(final Collection<ActivityEconomicCompany> collectionActivityEconomicCompany, final Long idCompany) {
		if(collectionActivityEconomicCompany != null) {
			for(final ActivityEconomicCompany activityEconomicCompanyTest : collectionActivityEconomicCompany){
				activityEconomicCompanyTest.setIdCompany(idCompany);
				this.handlerActivityEconomicCompany.register(activityEconomicCompanyTest);	
			}
		}
	}
	
	private void registerCollectionContactData(final Collection<ContactData> collectionContactData, final Long idCompany) {
		if(collectionContactData != null){
			for(final ContactData contactData : collectionContactData) {
				contactData.setIdCompany(idCompany);
				this.handlerContactData.register(contactData);
			}
			
		}
	}

	/**
	 * @param handlerActivityEconomicCompany the handlerActivityEconomicCompany to set
	 */
	public void setHandlerActivityEconomicCompany(IHandlerEntity<ActivityEconomicCompany> handlerActivityEconomicCompany) {
		this.handlerActivityEconomicCompany = handlerActivityEconomicCompany;
	}

	/**
	 * @param handlerScheduleWork the handlerScheduleWork to set
	 */
	public void setHandlerScheduleWork(IHandlerEntity<ScheduleWork> handlerScheduleWork) {
		this.handlerScheduleWork = handlerScheduleWork;
	}

	/**
	 * @param handlerContactData the handlerContactData to set
	 */
	public void setHandlerContactData(IHandlerEntity<ContactData> handlerContactData) {
		this.handlerContactData = handlerContactData;
	}

	/**
	 * @param handlerDocument the handlerDocument to set
	 */
	public void setHandlerDocument(IHandlerEntity<Document> handlerDocument) {
		this.handlerDocument = handlerDocument;
	}
}
