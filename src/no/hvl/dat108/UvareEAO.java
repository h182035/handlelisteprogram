package no.hvl.dat108;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UvareEAO {
	@PersistenceContext(name = "varePU")
	private EntityManager em;

	public void leggTil(Uvare p) {
		em.persist(p);
	}
	public List<Uvare> getAlle(){
		List<Uvare> varer = em.createQuery("SELECT p FROM Uvare p order by p.navn", Uvare.class).getResultList();
		return varer;
	}
	public void slett(String navn) {
		List<Uvare> liste = getAlle();
		try {
			boolean funnet = false;
			Uvare vare = null;
			for(int i = 0; i < liste.size() && !funnet; i++) {
				if(liste.get(i).getNavn().equals(navn)) {
					funnet = true;
					vare = liste.get(i);
				}
			}
			em.remove(vare);
		}catch(NullPointerException e) {
			System.out.println("nullpointer");
		}
		
		
	}
	public void handter(String string) {
		
		
	}

}
