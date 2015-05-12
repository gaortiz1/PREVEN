package ec.com.gesso.controller.administration;

import java.util.Collection;

import ec.com.gesso.model.entity.Catalog;
import ec.com.gesso.model.entity.CountryDto;
import ec.com.gesso.model.entity.Person;
import ec.com.gesso.model.entity.Process;

public class PersonAdministrationModel {
	private Collection<CountryDto> country ;	
	private Collection<Catalog> levelVulnerability ;
	private Collection<Catalog> lstProfesion ;
	private Collection<Process> lstProcess ;
	private Person person;
	
	public PersonAdministrationModel() {}
	
	public Collection<CountryDto> getCountry() {
		return country;
	}
	public void setCountry(Collection<CountryDto> country) {
		this.country = country;
	}
	public Collection<Catalog> getLevelVulnerability() {
		return levelVulnerability;
	}
	public void setLevelVulnerability(Collection<Catalog> levelVulnerability) {
		this.levelVulnerability = levelVulnerability;
	}
	public Collection<Catalog> getLstProfesion() {
		return lstProfesion;
	}
	public void setLstProfesion(Collection<Catalog> lstProfesion) {
		this.lstProfesion = lstProfesion;
	}
	public Collection<Process> getLstProcess() {
		return lstProcess;
	}
	public void setLstProcess(Collection<Process> lstProcess) {
		this.lstProcess = lstProcess;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}

	
	
}
