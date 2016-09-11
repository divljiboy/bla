package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author 
 *
 */

@Entity
@Table(name = "restoran")
@NamedQuery(name="findMeniuRestoranu" , query = "SELECT jelovnik_id from ra_32_2011.restoran_jelovnik r WHERE r.restoran_id like 3")
public class Restoran implements Serializable{

	private static final long serialVersionUID = -384592856314428303L;

	public Restoran() {
	}

	public Restoran(String naziv, String opis) {
		this.naziv = naziv;
		this.opis = opis;

	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "restoran_id", unique = true, nullable = false)
	private int id;

	@Column(name = "restoran_naziv", unique = false, nullable = false)
	private String naziv;

	@Column(name = "restoran_opis", unique = false, nullable = true)
	private String opis;


	
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "restoran")
	private Set<Manager> menadzeri = new HashSet<Manager>();
	
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "restoran")
	private Set<Rezervacija>  rezervacije = new HashSet<Rezervacija>();

	@ManyToMany
	@JoinTable(name = "restoran_jelovnik", joinColumns = @JoinColumn(name = "restoran_id", referencedColumnName = "restoran_id"), inverseJoinColumns = @JoinColumn(name = "jelovnik_id", referencedColumnName = "jelovnik_id"))
	private Set<Jelovnik> jelovnik = new HashSet<Jelovnik>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}






	public void setMenadzer(HashSet<Manager> menadzeri) {
		this.menadzeri = menadzeri;
	}
	
	

//	public Collection<Sto> getStolovi(){
//		if(stolovi == null)
//			stolovi = new HashSet<Sto>();
//		return stolovi;
//	}
	
	
	//public Collection<Jelovnik> getJelovnici(){
	//	if(this.jelovnik == null){
	//		this.jelovnik = new HashSet<Jelovnik>();
	//	}
	//	return this.jelovnik;
	//}
	
	

	public HashSet<Jelovnik> getJelovnik() {
		return (HashSet<Jelovnik>) jelovnik;
	}

	public void setJelovnik(HashSet<Jelovnik> jelovnik) {
		this.jelovnik = jelovnik;
	}
	public Collection<Manager> getMenadzeri(){
		if(menadzeri == null){
			menadzeri = new HashSet<Manager>();
		}
		return menadzeri;
	}
	
	
	
	public Iterator<Jelovnik> getIteratorJelovnik(){
		if(jelovnik == null){
			jelovnik = new HashSet<Jelovnik>();
		}
		return jelovnik.iterator();
	}
	
	
	public Iterator<Manager> getIteratorMenadzer(){
		if(menadzeri == null){
			menadzeri = new HashSet<Manager>();
		}
		return menadzeri.iterator();
	}
	
	
	
	/*public void addSto(Sto sto){
		System.out.println("Stolovi od restorana pre"+stolovi.size());
		
		if(sto == null)
			return;
		if(stolovi == null)
			stolovi = new HashSet<Sto>();
		if(!stolovi.contains(sto))
			stolovi.add(sto);
		System.out.println("Stolovi od restorana posle"+stolovi.size());
		
	}
	*/
	
	public void addJelovnik(Jelovnik jelovnik){
		if(jelovnik == null)
			return;
		if(this.jelovnik == null)
			this.jelovnik = new HashSet<Jelovnik>();
		if(!this.jelovnik.contains(jelovnik)){
			this.jelovnik.add(jelovnik);
		}
	}
	
	public void addMenadzer(Manager menadzer){
		if(menadzer ==null)
			return;
		if(menadzeri == null)
			menadzeri = new HashSet<Manager>();
		if(!menadzeri.contains(menadzer))
				menadzeri.add(menadzer);
	}
	
	/*public void removeSto(Sto sto){
		if(sto == null)
			return;
		if(stolovi != null)
			if(stolovi.contains(sto))
				stolovi.remove(sto);
			
	}*/
	
	public void removeJelovnik(Jelovnik jelovnik){
		if(jelovnik ==null)
			return;
		if(this.jelovnik!=null)
			if(this.jelovnik.contains(jelovnik))
				this.jelovnik.remove(jelovnik);
	}
	
	public Set<Rezervacija> getRezervacije() {
		return rezervacije;
	}

	public void setRezervacije(Set<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}

	public void setMenadzeri(Set<Manager> menadzeri) {
		this.menadzeri = menadzeri;
	}

	public void setJelovnik(Set<Jelovnik> jelovnik) {
		this.jelovnik = jelovnik;
	}

	public void removeMenadzer(Manager menadzer){
		if(menadzer == null)
			return;
		if(menadzeri!=null)
			if(menadzeri.contains(menadzer))
				menadzeri.remove(menadzer);
	}
	
	
	/*public void removeAllStolovi(){
		System.out.println("Pre brisanja svih stolova"+stolovi.size());
		if(stolovi!=null)
			stolovi.clear();
		System.out.println("Posle brisanja svih stolova"+stolovi.size());
		
	}*/
	
	public void removeAllJelovnici(){
		if(jelovnik!=null)
			jelovnik.clear();
	}
	
	public void removeAllMenadzeri(){
		if(menadzeri!=null)
			menadzeri.clear();
	}
	
	
	

}
