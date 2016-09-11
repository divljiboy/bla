package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.Set;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Rezervacija;

public interface RezervacijaDaoLocal extends GenericDaoLocal<Rezervacija, Integer> {

	public Set<Rezervacija> getRezervacijeodKorisnika(Gost g);
	public Set<Rezervacija> getPoseteodKorisnika(Gost g);
	public void dodajPrijateljaZaRezerv(Rezervacija r,Gost g1);
	

}
