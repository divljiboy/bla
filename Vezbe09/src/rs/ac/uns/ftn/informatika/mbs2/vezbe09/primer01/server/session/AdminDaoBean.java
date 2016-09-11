package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Admin;

/**
 * 
 * @author 
 *
 */
@Stateless
@Local(AdminDaoLocal.class)
public class AdminDaoBean extends GenericDaoBean<Admin, Integer> implements
		AdminDaoLocal {

	@Override
	public Admin findAdminSaKorisnickimImenomILozinkom(String korisnickoIme,
			String lozinka) {
		Query q = em.createNamedQuery("findAdminSaKorisnickimImenomILozinkom");
		
		q.setParameter("korisnickoIme", korisnickoIme);
		q.setParameter("lozinka", lozinka);
		Admin result = (Admin) q.getSingleResult();
		return result;
	}

}
