package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.io.Console;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;

/**
 * 
 * @author 
 *
 */

@Stateless
@Local(GostDaoLocal.class)
public class GostDaoBean extends GenericDaoBean<Gost, Integer> implements GostDaoLocal {

	@Override
	public Gost findGostSaKorisnickimImenomILozinkom(String korisnickoIme, String lozinka) {
		Query q = em.createNamedQuery("findGostSaKorisnickimImenomILozinkom");
		q.setParameter("korisnickoIme", korisnickoIme);
		q.setParameter("lozinka", lozinka);
		Gost result = (Gost) q.getSingleResult();
		return result;
	}

	@Override
	public Set<Gost> findPrijatelje(Gost g) {

		Gost gst = em.merge(g);
		Set<Gost> prijatelji = gst.getPrijatelji();
		return (Set<Gost>) prijatelji;
	}

	@Override
	public Set<Gost> findAllKojiMuNisuPrijatelji(Gost g) {

		Gost gost = em.merge(g);
		Set<Gost> prijatelji = (HashSet<Gost>) gost.getPrijatelji();
		
		Set<Gost> nisuprijatelji = new HashSet<Gost>();

		for (Gost gst : findAll()) {
			if (!prijatelji.contains(gst)) {
				if (!gst.equals(gost))
					nisuprijatelji.add(gst);
			}
		}
		return nisuprijatelji;
	}

	@Override
	public void dodajPrijatelja(Gost g, Gost g1) {
		Gost gost = em.merge(g);
		Gost gost2 = em.merge(g1);
		gost.dodajPrijateljaa(gost2);

		em.persist(gost);

	}

	@Override
	public void brisanjePrijatelja(Gost g, Gost g1) {
		Gost gost = em.merge(g);
		Gost gost2 = em.merge(g1);
		gost.izbrisiPrijateljaa(gost2);

		em.persist(gost);

	}

	@Override
	public void registraj(Gost g) {
		if (!findAll().contains(g))
			em.persist(g);
	}

	@Override
	public Set<Gost> findImeiPrezime(String imeIliPrezimem,Gost g) {

		Gost gost = em.merge(g);
		
		Set<Gost> nisuprijatelji = findAllKojiMuNisuPrijatelji(gost);
		Set<Gost> lista =new  HashSet<Gost>();

		for (Gost gst : nisuprijatelji) {
			if (gst.getFirstName().contains(imeIliPrezimem)|| gst.getLastName().contains(imeIliPrezimem)) {
				lista.add(gst);
			}
		}
		return lista;
	}

}
