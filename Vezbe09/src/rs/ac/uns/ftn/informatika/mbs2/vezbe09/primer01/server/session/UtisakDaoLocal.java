package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.Set;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Utisak;

public interface UtisakDaoLocal  extends GenericDaoLocal<Utisak, Integer>{

	Set<Utisak> getUtisciodKorisnika(Gost gost);

}
