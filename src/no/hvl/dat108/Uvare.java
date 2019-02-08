package no.hvl.dat108;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "handleliste", name = "uvare")
public class Uvare {

	@Id
	private String navn;

	public Uvare(String navn) {
		this.navn = navn;

	}

	public Uvare() {

	}


	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

}
