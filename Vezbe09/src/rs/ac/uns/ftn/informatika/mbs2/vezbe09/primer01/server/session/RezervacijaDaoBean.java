package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Local;
import javax.ejb.Stateless;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Rezervacija;

@Stateless
@Local(RezervacijaDaoLocal.class)
public class RezervacijaDaoBean extends GenericDaoBean<Rezervacija, Integer> implements RezervacijaDaoLocal {

	@Override
	public Set<Rezervacija> getRezervacijeodKorisnika(Gost g) {
		List<Rezervacija> lista = findAll();
		Gost gost = em.merge(g);
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();

		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());

		Set<Rezervacija> rezervacije = new HashSet<Rezervacija>();
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getGost().equals(gost)) {
				if (lista.get(i).getOd().after(currentTimestamp)) {
					rezervacije.add(lista.get(i));
				}
			}
			else if(lista.get(i).getPrijatelji().contains(gost)){
					if (lista.get(i).getOd().after(currentTimestamp)) {
						rezervacije.add(lista.get(i));
					}
				}
			
		}
		return rezervacije;
	}

	@Override
	public Set<Rezervacija> getPoseteodKorisnika(Gost g) {
		List<Rezervacija> lista = findAll();
		Gost gost = em.merge(g);
		Calendar calendar = Calendar.getInstance();

		java.util.Date now = calendar.getTime();

		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());

		Set<Rezervacija> rezervacije = new HashSet<Rezervacija>();
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getGost().equals(gost)) {
				if (lista.get(i).getDoo().before(currentTimestamp)) {
					rezervacije.add(lista.get(i));
				}
			}
			
			else if(lista.get(i).getPrijatelji().contains(gost)){
				if (lista.get(i).getDoo().before(currentTimestamp)) {
					rezervacije.add(lista.get(i));
					System.out.println("usao u rezervacije");
				}
			}
		}
		return rezervacije;
	}

	@Override
	public void dodajPrijateljaZaRezerv(Rezervacija r, Gost g2) {

	Rezervacija rezervacija = em.merge(r);
		Gost gost2 = em.merge(g2);
		
		rezervacija.addPrijatelj(gost2);
		em.persist(rezervacija);
		
		
	}

}
