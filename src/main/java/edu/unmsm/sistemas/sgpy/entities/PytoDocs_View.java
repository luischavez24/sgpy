package edu.unmsm.sistemas.sgpy.entities;

import java.util.Date;

public class PytoDocs_View extends PytoDocs{
	private String desFase;
	private String desNivel;
	private String desTDoc;
	private String desentreg;
	
	public PytoDocs_View(int codPyto, int corrdocs, Date fecIni, Date fecFin, double costoEst, String verDoc,
			String vigente, String desFase, String desNivel, String desTDoc, String desentreg) {
		
		super(codPyto, corrdocs, fecIni, fecFin, costoEst, verDoc, vigente);
		this.desFase = desFase;
		this.desNivel = desNivel;
		this.desTDoc = desTDoc;
		this.desentreg = desentreg;
	}

	public String getDesFase() {
		return desFase;
	}

	public void setDesFase(String desFase) {
		this.desFase = desFase;
	}

	public String getDesNivel() {
		return desNivel;
	}

	public void setDesNivel(String desNivel) {
		this.desNivel = desNivel;
	}

	public String getDesTDoc() {
		return desTDoc;
	}

	public void setDesTDoc(String desTDoc) {
		this.desTDoc = desTDoc;
	}

	public String getDesentreg() {
		return desentreg;
	}

	public void setDesentreg(String desentreg) {
		this.desentreg = desentreg;
	}

	@Override
	public String toString() {
		return "PytoDocs_View [desFase=" + desFase + ", desNivel=" + desNivel + ", desTDoc=" + desTDoc + ", desentreg="
				+ desentreg + "]";
	}
	
	
	
}

