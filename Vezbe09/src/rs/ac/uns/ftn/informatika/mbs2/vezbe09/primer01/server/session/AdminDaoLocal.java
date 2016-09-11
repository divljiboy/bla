package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Admin;

/**
 * 
 * @author 
 *
 */
public interface AdminDaoLocal extends GenericDaoLocal<Admin, Integer> {

	Admin findAdminSaKorisnickimImenomILozinkom(String korisnickoIme, String lozinka);
		
}
