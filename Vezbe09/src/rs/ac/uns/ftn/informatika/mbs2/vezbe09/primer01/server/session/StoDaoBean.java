package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Local;
import javax.ejb.Stateless;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Sto;

@Stateless
@Local(StoDaoLocal.class)
public class StoDaoBean extends GenericDaoBean<Sto, Integer> implements StoDaoLocal {

	@Override
	public Set<Sto> getStoloviodRestorana(Restoran r) {
		List<Sto> lista = findAll();
		Restoran restoran = em.merge(r);
		
		Set<Sto> stolovi = new HashSet<Sto>();
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getRestoran().equals(restoran)) {
				stolovi.add(lista.get(i));
			}
		}
		return stolovi;
	}

}
