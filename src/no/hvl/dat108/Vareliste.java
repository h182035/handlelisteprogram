package no.hvl.dat108;

import java.util.List;

public class Vareliste {
	private List<Vare> varer;
	
	public Vareliste() {
		
	}
	public void add(Vare e) {
		varer.add(e);
	}
	public Vare finnVareEtterNavn(String navn) {
		boolean funnet = false;
		Vare vare = null;
		for(int i = 0; i < varer.size() && !funnet; i++) {
			if(varer.get(i).getNavn().equals(navn)) {
				funnet = true;
				vare = varer.get(i);
			}
		}
		return vare;
	}
}
