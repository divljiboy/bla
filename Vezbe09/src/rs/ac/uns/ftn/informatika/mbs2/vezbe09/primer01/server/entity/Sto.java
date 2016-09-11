package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "sto")
public class Sto  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sto_id", unique = true, nullable = false)
	private int id;

	

	@Column(name = "broj_stola", unique = false, nullable = false)
	private int broj;

	@Column(name = "pozicija_stola", unique = false, nullable = false)
	private int pozicija;
	
    @ManyToOne(targetEntity=Restoran.class, fetch = FetchType.LAZY)
    @JoinColumn(name="restoranId",referencedColumnName="restoran_id")
    private Restoran  restoran;
	
	
	
	

	public Restoran getRestoran() {
		return restoran;
	}

	public void setRestoran(Restoran restoran) {
		this.restoran = restoran;
	}

	public Sto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Sto(int br, int pozicija,Restoran r) {
		this.broj = br;
		this.pozicija = pozicija;
		this.restoran=r;
		
		prikaz(br,pozicija,r);
	}

	
	public int getPozicija() {
		return pozicija;
	}

	public void setPozicija(int pozicija) {
		this.pozicija = pozicija;
	}

	

	public int getBroj() {
		return broj;
	}

	public void setBroj(int broj) {
		this.broj = broj;
	}

	

public void prikaz(int a,int b,Restoran r){
	System.out.println("U restoranu"+r.getNaziv()+"Redni broj"+a+"Njegova pozicija"+b);
}

	
	

}
