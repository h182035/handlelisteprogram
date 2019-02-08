package no.hvl.dat108;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class VareEAO {
	@PersistenceContext(name = "varePU")
	private EntityManager em;

	public void leggTil(Vare p) {

		em.persist(p);

	}

	public void oppdaterDB(Vare e) {

		em.merge(e);

	}

	public List<Vare> getAlle() {
		List<Vare> varer = null;

		varer = em.createQuery("SELECT p FROM Vare p order by p.navn", Vare.class).getResultList();

		return varer;
	}

	public List<Vare> getTomt() {
		List<Vare> varer = em.createQuery("SELECT p FROM Vare p where p.status = 3 order by p.navn", Vare.class)
				.getResultList();
		return varer;
	}

	public void nedjuster(String navnpavare) {
		List<Vare> liste = getAlle();
		try {
			boolean funnet = false;
			Vare vare = null;
			for (int i = 0; i < liste.size() && !funnet; i++) {
				if (liste.get(i).getNavn().equals(navnpavare)) {
					funnet = true;
					vare = liste.get(i);
				}
			}
			vare.nedJuster();
			oppdaterDB(vare);
		} catch (NullPointerException e) {
			System.out.println("nullpointer");
		}

	}

	public List<Vare> getNestenTomt() {
		List<Vare> varer = em.createQuery("SELECT p FROM Vare p where p.status = 2 order by p.navn", Vare.class)
				.getResultList();
		return varer;
	}

	public void nedjusterNestenTomVare(String navnpavare2) {
		List<Vare> liste = getAlle();
		try {
			boolean funnet = false;
			Vare vare = null;
			for (int i = 0; i < liste.size() && !funnet; i++) {
				if (liste.get(i).getNavn().equals(navnpavare2)) {
					funnet = true;
					vare = liste.get(i);
				}
			}
			vare.nedjusterNestenTomVare();
			oppdaterDB(vare);
		} catch (NullPointerException e) {
			System.out.println("nullpointer");
		}

	}

	public void slett(String navn) {
		List<Vare> liste = getAlle();
		try {
			boolean funnet = false;
			Vare vare = null;
			for (int i = 0; i < liste.size() && !funnet; i++) {
				if (liste.get(i).getNavn().equals(navn)) {
					funnet = true;
					vare = liste.get(i);
				}
			}
			em.remove(vare);
		} catch (NullPointerException e) {
			System.out.println("nullpointer");
		}

	}

	public boolean handter(String navnpavare) {
		List<Vare> liste = getAlle();
		for (Vare a : liste) {
			if (a.getNavn().equals(navnpavare)) {
				a.nedJuster();
				return true;
			}
		}
		return false;
	}

}
