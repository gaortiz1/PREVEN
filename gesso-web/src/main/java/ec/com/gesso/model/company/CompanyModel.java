/**
 * 
 */
package ec.com.gesso.model.company;

import java.io.Serializable;

import ec.com.gesso.model.activity.ActivityEconomicModel;
import ec.com.gesso.model.contactdata.AddressModel;
import ec.com.gesso.model.contactdata.EmailModel;
import ec.com.gesso.model.contactdata.PhoneModel;

/**
 * @author Gabriel
 *
 */
public class CompanyModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nombreGrupoEmpresarial;
	private String razonSocial;
	private String ruc;
	private String nombreComercial;
	
	private ActivityEconomicModel actividadComercialPrincipal;
	private ActivityEconomicModel actividadComercialSecuandaria;
	private String typesCompanies;
	private String typeProductiveSector;
	
	private PhoneModel telefono;
	private PhoneModel celular;
	private AddressModel direccion;
	private EmailModel email;
	
	private Long idGeopoliticalDivisionCountry;
	private Long idGeopoliticalDivisionProvince;
	private Long idGeopoliticalDivisionCity;
	
	private String[] schedulesWork;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nombreGrupoEmpresarial
	 */
	public String getNombreGrupoEmpresarial() {
		return nombreGrupoEmpresarial;
	}

	/**
	 * @param nombreGrupoEmpresarial the nombreGrupoEmpresarial to set
	 */
	public void setNombreGrupoEmpresarial(String nombreGrupoEmpresarial) {
		this.nombreGrupoEmpresarial = nombreGrupoEmpresarial;
	}

	/**
	 * @return the razonSocial
	 */
	public String getRazonSocial() {
		return razonSocial;
	}

	/**
	 * @param razonSocial the razonSocial to set
	 */
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	/**
	 * @return the ruc
	 */
	public String getRuc() {
		return ruc;
	}

	/**
	 * @param ruc the ruc to set
	 */
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	/**
	 * @return the nombreComercial
	 */
	public String getNombreComercial() {
		return nombreComercial;
	}

	/**
	 * @param nombreComercial the nombreComercial to set
	 */
	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	/**
	 * @return the actividadComercialPrincipal
	 */
	public ActivityEconomicModel getActividadComercialPrincipal() {
		return actividadComercialPrincipal;
	}

	/**
	 * @param actividadComercialPrincipal the actividadComercialPrincipal to set
	 */
	public void setActividadComercialPrincipal(
			ActivityEconomicModel actividadComercialPrincipal) {
		this.actividadComercialPrincipal = actividadComercialPrincipal;
	}

	/**
	 * @return the actividadComercialSecuandaria
	 */
	public ActivityEconomicModel getActividadComercialSecuandaria() {
		return actividadComercialSecuandaria;
	}

	/**
	 * @param actividadComercialSecuandaria the actividadComercialSecuandaria to set
	 */
	public void setActividadComercialSecuandaria(
			ActivityEconomicModel actividadComercialSecuandaria) {
		this.actividadComercialSecuandaria = actividadComercialSecuandaria;
	}

	/**
	 * @return the typesCompanies
	 */
	public String getTypesCompanies() {
		return typesCompanies;
	}

	/**
	 * @param typesCompanies the typesCompanies to set
	 */
	public void setTypesCompanies(String typesCompanies) {
		this.typesCompanies = typesCompanies;
	}

	/**
	 * @return the typeProductiveSector
	 */
	public String getTypeProductiveSector() {
		return typeProductiveSector;
	}

	/**
	 * @param typeProductiveSector the typeProductiveSector to set
	 */
	public void setTypeProductiveSector(String typeProductiveSector) {
		this.typeProductiveSector = typeProductiveSector;
	}

	/**
	 * @return the telefono
	 */
	public PhoneModel getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(PhoneModel telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the celular
	 */
	public PhoneModel getCelular() {
		return celular;
	}

	/**
	 * @param celular the celular to set
	 */
	public void setCelular(PhoneModel celular) {
		this.celular = celular;
	}

	/**
	 * @return the direccion
	 */
	public AddressModel getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(AddressModel direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the email
	 */
	public EmailModel getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(EmailModel email) {
		this.email = email;
	}

	/**
	 * @return the idGeopoliticalDivisionCountry
	 */
	public Long getIdGeopoliticalDivisionCountry() {
		return idGeopoliticalDivisionCountry;
	}

	/**
	 * @param idGeopoliticalDivisionCountry the idGeopoliticalDivisionCountry to set
	 */
	public void setIdGeopoliticalDivisionCountry(Long idGeopoliticalDivisionCountry) {
		this.idGeopoliticalDivisionCountry = idGeopoliticalDivisionCountry;
	}

	/**
	 * @return the idGeopoliticalDivisionProvince
	 */
	public Long getIdGeopoliticalDivisionProvince() {
		return idGeopoliticalDivisionProvince;
	}

	/**
	 * @param idGeopoliticalDivisionProvince the idGeopoliticalDivisionProvince to set
	 */
	public void setIdGeopoliticalDivisionProvince(
			Long idGeopoliticalDivisionProvince) {
		this.idGeopoliticalDivisionProvince = idGeopoliticalDivisionProvince;
	}

	/**
	 * @return the idGeopoliticalDivisionCity
	 */
	public Long getIdGeopoliticalDivisionCity() {
		return idGeopoliticalDivisionCity;
	}

	/**
	 * @param idGeopoliticalDivisionCity the idGeopoliticalDivisionCity to set
	 */
	public void setIdGeopoliticalDivisionCity(Long idGeopoliticalDivisionCity) {
		this.idGeopoliticalDivisionCity = idGeopoliticalDivisionCity;
	}

	/**
	 * @return the schedulesWork
	 */
	public String[] getSchedulesWork() {
		return schedulesWork;
	}

	/**
	 * @param schedulesWork the schedulesWork to set
	 */
	public void setSchedulesWork(String[] schedulesWork) {
		this.schedulesWork = schedulesWork;
	}
}
