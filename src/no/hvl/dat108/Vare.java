package no.hvl.dat108;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "handleliste", name = "vare")
public class Vare {

	@Id
	private String navn;
	private int status;
	private String farge;

	private String bilde;

	// private String bra = "#24FF12";
	// private String middels = "#FFF700";
	// private String dårlig = "#FF0000";

	public Vare(String navn, int status, String farge, String bilde) {
		this.navn = navn;
		this.status = status;
		this.farge = farge;
		this.bilde = bilde;
	}

	public Vare() {

	}

	public void nedJuster() {

		if (status == 1 || status == 2) {
			status++;
			
		} else {
			status = 1;
		}

		endrefarge();
	}

	private void endrefarge() {
		if (status == 1) {
			farge = "#24FF12";
		} else if (status == 2) {
			farge = "#FFF700";
		} else {
			farge = "#FF0000";
		}

	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getBilde() {
		return bilde;
	}

	public void setBilde(String bilde) {
		this.bilde = bilde;
	}

	public String getFarge() {
		return farge;
	}

	public void setFarge(String farge) {
		this.farge = farge;
	}

	public void nedjusterNestenTomVare() {
		status = 1;
		endrefarge();
		
	}

}
