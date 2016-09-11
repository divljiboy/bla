package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Local;
import javax.ejb.Stateless;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Utisak;

@Stateless
@Local(UtisakDaoLocal.class)
public class UtisakDaoBean extends GenericDaoBean<Utisak, Integer> implements UtisakDaoLocal {

	@Override
	public Set<Utisak> getUtisciodKorisnika(Gost g) {
		List<Utisak> lista = findAll();
		Gost gost = em.merge(g);
		
		Set<Utisak> rezervacije = new HashSet<Utisak>();
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getGost().equals(gost)) {
				
					rezervacije.add(lista.get(i));
					
			}
		}
		return rezervacije;
	}

}
