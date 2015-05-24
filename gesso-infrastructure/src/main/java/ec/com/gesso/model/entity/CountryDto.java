package ec.com.gesso.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "pais")
public class CountryDto implements Serializable{
    @Id
    @Basic(optional = false)
    @Column(name = "paiscodigo")
    private String paiscodigo;
    @Basic(optional = false)
    @Column(name = "paisnombre")
    private String paisnombre;
    @Basic(optional = false)
    @Column(name = "paiscontinente")
    private String paiscontinente;
    @Basic(optional = false)
    @Column(name = "paisregion")
    private String paisregion;
    @Basic(optional = false)
    @Column(name = "paisarea")
    private double paisarea;
    @Column(name = "paisindependencia")
    private Short paisindependencia;
    @Basic(optional = false)
    @Column(name = "paispoblacion")
    private int paispoblacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "paisexpectativadevida")
    private Double paisexpectativadevida;
    @Column(name = "paisproductointernobruto")
    private Double paisproductointernobruto;
    @Column(name = "paisproductointernobrutoantiguo")
    private Double paisproductointernobrutoantiguo;
    @Basic(optional = false)
    @Column(name = "paisnombrelocal")
    private String paisnombrelocal;
    @Basic(optional = false)
    @Column(name = "paisgobierno")
    private String paisgobierno;
    @Column(name = "paisjefedeestado")
    private String paisjefedeestado;
    @Column(name = "paiscapital")
    private Integer paiscapital;
    @Basic(optional = false)
    @Column(name = "paiscodigo2")
    private String paiscodigo2;

    public CountryDto() {
	}

    public CountryDto(String paiscodigo) {
        this.paiscodigo = paiscodigo;
    }

    public CountryDto(String paiscodigo, String paisnombre, String paiscontinente, String paisregion, double paisarea, int paispoblacion, String paisnombrelocal, String paisgobierno, String paiscodigo2) {
        this.paiscodigo = paiscodigo;
        this.paisnombre = paisnombre;
        this.paiscontinente = paiscontinente;
        this.paisregion = paisregion;
        this.paisarea = paisarea;
        this.paispoblacion = paispoblacion;
        this.paisnombrelocal = paisnombrelocal;
        this.paisgobierno = paisgobierno;
        this.paiscodigo2 = paiscodigo2;
    }

    public String getPaiscodigo() {
        return paiscodigo;
    }

    public void setPaiscodigo(String paiscodigo) {
        this.paiscodigo = paiscodigo;
    }

    public String getPaisnombre() {
        return paisnombre;
    }

    public void setPaisnombre(String paisnombre) {
        this.paisnombre = paisnombre;
    }

    public String getPaiscontinente() {
        return paiscontinente;
    }

    public void setPaiscontinente(String paiscontinente) {
        this.paiscontinente = paiscontinente;
    }

    public String getPaisregion() {
        return paisregion;
    }

    public void setPaisregion(String paisregion) {
        this.paisregion = paisregion;
    }

    public double getPaisarea() {
        return paisarea;
    }

    public void setPaisarea(double paisarea) {
        this.paisarea = paisarea;
    }

    public Short getPaisindependencia() {
        return paisindependencia;
    }

    public void setPaisindependencia(Short paisindependencia) {
        this.paisindependencia = paisindependencia;
    }

    public int getPaispoblacion() {
        return paispoblacion;
    }

    public void setPaispoblacion(int paispoblacion) {
        this.paispoblacion = paispoblacion;
    }

    public Double getPaisexpectativadevida() {
        return paisexpectativadevida;
    }

    public void setPaisexpectativadevida(Double paisexpectativadevida) {
        this.paisexpectativadevida = paisexpectativadevida;
    }

    public Double getPaisproductointernobruto() {
        return paisproductointernobruto;
    }

    public void setPaisproductointernobruto(Double paisproductointernobruto) {
        this.paisproductointernobruto = paisproductointernobruto;
    }

    public Double getPaisproductointernobrutoantiguo() {
        return paisproductointernobrutoantiguo;
    }

    public void setPaisproductointernobrutoantiguo(Double paisproductointernobrutoantiguo) {
        this.paisproductointernobrutoantiguo = paisproductointernobrutoantiguo;
    }

    public String getPaisnombrelocal() {
        return paisnombrelocal;
    }

    public void setPaisnombrelocal(String paisnombrelocal) {
        this.paisnombrelocal = paisnombrelocal;
    }

    public String getPaisgobierno() {
        return paisgobierno;
    }

    public void setPaisgobierno(String paisgobierno) {
        this.paisgobierno = paisgobierno;
    }

    public String getPaisjefedeestado() {
        return paisjefedeestado;
    }

    public void setPaisjefedeestado(String paisjefedeestado) {
        this.paisjefedeestado = paisjefedeestado;
    }

    public Integer getPaiscapital() {
        return paiscapital;
    }

    public void setPaiscapital(Integer paiscapital) {
        this.paiscapital = paiscapital;
    }

    public String getPaiscodigo2() {
        return paiscodigo2;
    }

    public void setPaiscodigo2(String paiscodigo2) {
        this.paiscodigo2 = paiscodigo2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paiscodigo != null ? paiscodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CountryDto)) {
            return false;
        }
        CountryDto other = (CountryDto) object;
        if ((this.paiscodigo == null && other.paiscodigo != null) || (this.paiscodigo != null && !this.paiscodigo.equals(other.paiscodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.gesso.security.domain.model.security.dto.Pais[ paiscodigo=" + paiscodigo + " ]";
    }
}
