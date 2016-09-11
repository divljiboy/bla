package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.Set;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Sto;

public interface StoDaoLocal extends GenericDaoLocal<Sto, Integer> {

	Set<Sto> getStoloviodRestorana(Restoran r);
}
