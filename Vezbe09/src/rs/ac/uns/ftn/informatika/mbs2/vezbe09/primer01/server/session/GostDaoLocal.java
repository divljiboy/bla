package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;



import java.util.HashSet;
import java.util.Set;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;


/**
 * @author 
 *
 */
public interface GostDaoLocal extends GenericDaoLocal<Gost, Integer> {

	 Gost findGostSaKorisnickimImenomILozinkom(String korisnickoIme,String lozinka);

	Set<Gost> findPrijatelje(Gost g);
	void brisanjePrijatelja(Gost g, Gost g1);
	void registraj(Gost g);
	
	Set<Gost> findAllKojiMuNisuPrijatelji(Gost g);
	
	void dodajPrijatelja(Gost g,Gost g1);

	Set<Gost> findImeiPrezime(String imeIliPrezime,Gost g);
}
