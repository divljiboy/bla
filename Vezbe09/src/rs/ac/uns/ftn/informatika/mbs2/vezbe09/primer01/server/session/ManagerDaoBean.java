package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Manager;

/**
 * 
 * @author 
 *
 */

@Stateless
@Local(ManagerDaoLocal.class)
public class ManagerDaoBean extends GenericDaoBean <Manager, Integer>implements ManagerDaoLocal {



	@Override
	public Manager findMenadzerSaKorisnickimImenomILozinkom(
			String korisnickoIme, String lozinka) {
		Query q = em.createNamedQuery("findMenadzerSaKorisnickimImenomILozinkom");
		q.setParameter("korisnickoIme", korisnickoIme);
		q.setParameter("lozinka", lozinka);
		Manager result = (Manager) q.getSingleResult();
		return result;
	}

}
