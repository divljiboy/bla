package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.HashSet;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelo;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelovnik;

/**
 * 
 * @author 
 *
 */

public interface JelovnikDaoLocal extends GenericDaoLocal<Jelovnik, Integer> {

	public HashSet<Jelo> ucitajJela(Jelovnik k);
	public HashSet<Jelo> noviJelovnik(Jelovnik k, Jelo j);
	public HashSet<Jelo> addJeloNaJelovnik(Jelovnik k,Jelo j);
	
}
