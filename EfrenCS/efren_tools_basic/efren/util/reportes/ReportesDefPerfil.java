package efren.util.reportes;

import java.io.Serializable;

import efren.util.entidades.EntityObject;

public class ReportesDefPerfil extends EntityObject implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 6369049723386022011L;
	private long reportesDefOid;
	private String nombreReporte;
	private long perfilOid;
	private String nombrePerfil;

	public ReportesDefPerfil() {
		super();
	}

	public long getReportesDefOid() {
		return reportesDefOid;
	}

	public void setReportesDefOid(long reportesDefOid) {
		this.reportesDefOid = reportesDefOid;
	}

	public long getPerfilOid() {
		return perfilOid;
	}

	public void setPerfilOid(long perfilOid) {
		this.perfilOid = perfilOid;
	}

	public String getNombreReporte() {
		return nombreReporte;
	}

	public void setNombreReporte(String nombreReporte) {
		this.nombreReporte = nombreReporte;
	}

	public String getNombrePerfil() {
		return nombrePerfil;
	}

	public void setNombrePerfil(String nombrePerfil) {
		this.nombrePerfil = nombrePerfil;
	}

}