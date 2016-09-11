package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.HashSet;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelo;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelovnik;

/**
 * 
 * @author 
 *
 */

@Stateless
@Local(JeloDaoLocal.class)
public class JeloDaoBean extends GenericDaoBean<Jelo, Integer> implements
		JeloDaoLocal {

	@Override
	public List<Jelo> findJelasaJelovnika(int jelovnik_id) {
		Query q = em.createNamedQuery("findJelasaJelovnika");
		q.setParameter("k", jelovnik_id);
		@SuppressWarnings("unchecked")
		List<Jelo> result = q.getResultList();
		return result;
	}

	@Override
	public HashSet<Jelo> findJelaKojaNisuNaJelovniku(Jelovnik j) {
		Jelovnik jelovnik = em.merge(j);
		HashSet<Jelo> jelaNaMeniju = (HashSet<Jelo>) jelovnik.getJela();
		HashSet<Jelo> jela = new HashSet<Jelo>();
		for(Jelo jl : findAll()){
			if(!jelaNaMeniju.contains(jl)){
				jela.add(jl);
			}
		}
		return jela;
	}
	




}
