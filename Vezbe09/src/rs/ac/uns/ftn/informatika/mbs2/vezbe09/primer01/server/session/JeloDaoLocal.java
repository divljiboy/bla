package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.HashSet;
import java.util.List;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelo;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelovnik;

/**
 * 
 * @author 
 *
 */

public interface JeloDaoLocal extends GenericDaoLocal<Jelo, Integer> {

	List<Jelo> findJelasaJelovnika(int jelovnik_id);
	public HashSet<Jelo> findJelaKojaNisuNaJelovniku(Jelovnik j);
}
