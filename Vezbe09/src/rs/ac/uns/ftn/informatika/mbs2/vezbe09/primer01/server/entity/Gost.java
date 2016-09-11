package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "gost")
@NamedQueries({
		@NamedQuery(name = "findGostSaKorisnickimImenomILozinkom", query = "SELECT k FROM Gost k WHERE k.username like :korisnickoIme AND k.password LIKE :lozinka"), })
public class Gost extends User {

	private static final long serialVersionUID = 4298151580183210814L;

	public Gost() {
		super();
	}

	@JoinTable(name = "prijateljstvo", joinColumns = {
			@JoinColumn(name = "seller", referencedColumnName = "user_id", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "buyer", referencedColumnName = "user_id", nullable = false) })
	@ManyToMany
	private Set<Gost> prijatelji=new HashSet<Gost>();
	
	
	
	

	public Set<Utisak> getUtisak() {
		return utisak;
	}

	public void setUtisak(Set<Utisak> utisak) {
		this.utisak = utisak;
	}

	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "gost")
	private Set<Utisak> utisak = new HashSet<Utisak>();
	
	

	public void dodajPrijateljaa(Gost g) {

		if (!prijatelji.contains(g)) {
			prijatelji.add(g);
		}

	}

	public void izbrisiPrijateljaa(Gost g) {

		if (prijatelji.contains(g)) {
			prijatelji.remove(g);
		}

	}

	public Set<Gost> getPrijatelji() {
		return prijatelji;
	}

	public void setPrijatelji(Set<Gost> prijatelji) {
		this.prijatelji = prijatelji;
	}

}
