/**
 * 
 */
package ec.com.gesso.model;

import java.io.Serializable;

/**
 * @author Gabriel
 *
 */
public class CompanyModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombreGrupoEmpresarial;
	private String razonSocial;
	private String ruc;
	private String nombreComercial;
	private String actividadComercialPrincipal;
	private String actividadComercialSecuandaria;
	private String tipoEmpresa;
	private String telefono;
	private String celular;
	private String direccion;
	private String email;
	
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
	public String getActividadComercialPrincipal() {
		return actividadComercialPrincipal;
	}
	/**
	 * @param actividadComercialPrincipal the actividadComercialPrincipal to set
	 */
	public void setActividadComercialPrincipal(String actividadComercialPrincipal) {
		this.actividadComercialPrincipal = actividadComercialPrincipal;
	}
	/**
	 * @return the actividadComercialSecuandaria
	 */
	public String getActividadComercialSecuandaria() {
		return actividadComercialSecuandaria;
	}
	/**
	 * @param actividadComercialSecuandaria the actividadComercialSecuandaria to set
	 */
	public void setActividadComercialSecuandaria(
			String actividadComercialSecuandaria) {
		this.actividadComercialSecuandaria = actividadComercialSecuandaria;
	}
	/**
	 * @return the tipoEmpresa
	 */
	public String getTipoEmpresa() {
		return tipoEmpresa;
	}
	/**
	 * @param tipoEmpresa the tipoEmpresa to set
	 */
	public void setTipoEmpresa(String tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}
	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}
	/**
	 * @param celular the celular to set
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}