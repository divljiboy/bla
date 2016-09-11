package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author 
 *
 */

@Entity
@Table(name="manager")
@NamedQuery(name = "findMenadzerSaKorisnickimImenomILozinkom", query = "SELECT k FROM Manager k WHERE k.username like :korisnickoIme AND k.password LIKE :lozinka")
public class Manager extends User{

	private static final long serialVersionUID = -8213271469967659550L;

	public Manager(){
		super();
	}
	
	
	@OneToOne()
	@JoinColumn(name = "restoran_id" ,referencedColumnName="restoran_id", nullable = false)
	public Restoran restoran;

	public Restoran getRestoran() {
		return restoran;
	}

	public void setRestoran(Restoran restoran) {
		this.restoran = restoran;
	}
	
	

}
