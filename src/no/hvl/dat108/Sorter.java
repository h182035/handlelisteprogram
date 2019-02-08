package no.hvl.dat108;

import java.util.List;

public class Sorter {

	
	public static List<Vare> bubble(List<Vare> liste){
		boolean ferdig = false;
		Vare temp;
		
		while(!ferdig) {
			ferdig = true;
			for(int i = 0; i > liste.size(); i++) {
				if(liste.get(i).getNavn().charAt(0) > liste.get(i).getNavn().charAt(0)) {
					temp = liste.get(i+1);
					liste.set(i+1, liste.get(i));
					liste.set(i, temp);
					ferdig = false;
				}
			}
			
		}
		return liste;
		
		
		
	}
}
