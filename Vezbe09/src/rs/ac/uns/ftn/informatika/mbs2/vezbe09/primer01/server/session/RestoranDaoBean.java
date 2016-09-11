package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelovnik;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Sto;
/**
 * 
 * @author 
 *
 */
@Stateless
@Local(RestoranDaoLocal.class)
public class RestoranDaoBean extends GenericDaoBean<Restoran, Integer> implements
		RestoranDaoLocal {

	
    @Override
    public HashSet<Jelovnik> ucitajJelovnike(Restoran k){
        Restoran kor = em.merge(k);
        return (HashSet<Jelovnik>) kor.getJelovnik();
    }

	@Override
	public HashSet<Jelovnik> obrisiJelovnike(Restoran r, Jelovnik j) {
		Restoran restoran = em.merge(r);
		Jelovnik jelovnik = em.merge(j);
		restoran.removeJelovnik(jelovnik);
		return restoran.getJelovnik();
	}

	@Override
	public HashSet<Jelovnik> dodajJelovnikURestoran(Restoran r, Jelovnik j) {
		Restoran restoran = em.merge(r);
		Jelovnik k = em.merge(j);
		restoran.addJelovnik(k);
		return restoran.getJelovnik();
	}

	/*@Override
	public void addSto(Restoran restoran, Sto  sto) {
		Restoran r = em.merge(restoran);
		HashSet<Sto> stolovi = (HashSet<Sto>) r.getStolovi();
		if(!stolovi.contains(sto))
			System.out.println("Dodat sto");
			stolovi.add(sto);
			
	}*/

	@Override
	public List<Restoran> pretragaRestorana(String s) {
		List<Restoran> result = new ArrayList<Restoran>();
		for(Restoran r : findAll()){
			if(r.getNaziv().contains(s) || r.getOpis().contains(s))
				result.add(r);
		}
		return result;
	}

	/*@Override
	public void obrisiStolove(Restoran r) {
		Restoran restoran = em.merge(r);
		restoran.getStolovi().clear();
		em.persist(restoran);
		
	}
*/


	
}
