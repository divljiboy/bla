package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.HashSet;

import javax.ejb.Local;
import javax.ejb.Stateless;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelo;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelovnik;

/**
 * 
 * @author 
 *
 */
@Stateless
@Local(JelovnikDaoLocal.class)
public class JelovnikDaoBean extends GenericDaoBean<Jelovnik, Integer> implements
		JelovnikDaoLocal {


	
    @Override
    public HashSet<Jelo> ucitajJela(Jelovnik k){
        Jelovnik kor = em.merge(k);
        return (HashSet<Jelo>) kor.getJela();
    }
    public HashSet<Jelo> noviJelovnik(Jelovnik k, Jelo j){
    	Jelovnik jelovnik = em.merge(k);
    	Jelo jelo = em.merge(j);
    	jelovnik.removeJelo(jelo);
    	return (HashSet<Jelo>) jelovnik.getJela();
    }
	@Override
	public HashSet<Jelo> addJeloNaJelovnik(Jelovnik k, Jelo j) {
		Jelovnik jelovnik1 = em.merge(k);
		HashSet<Jelo> jela = (HashSet<Jelo>) jelovnik1.getJela();
		jela.add(j);
		return jela;
	}

    

	
	
}
