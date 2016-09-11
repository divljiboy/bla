package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="admin")
@NamedQuery(name = "findAdminSaKorisnickimImenomILozinkom", query = "SELECT k FROM Admin k WHERE k.username like :korisnickoIme AND k.password LIKE :lozinka")
public class Admin extends User {

	private static final long serialVersionUID = -3148238141421474458L;

	public Admin(){
		super();
	}

}
