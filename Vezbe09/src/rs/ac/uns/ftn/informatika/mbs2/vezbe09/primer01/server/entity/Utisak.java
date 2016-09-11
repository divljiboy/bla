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
@Table(name = "utisak")
public class Utisak  implements Serializable{
	
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "utisak_id", unique = true, nullable = false)
	private int id;

	

	@Column(name = "utisak_opis", unique = false, nullable = true)
	private String opis;
	@Column(name = "utisak_ocena", unique = false, nullable = true)
	private float ocena;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "utisak_gost_id", nullable = false)
	private Gost gost;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "utisak_rezervacija_id", nullable = false)
	private Rezervacija rezervacija;

	public Utisak(String opis, float ocena, Gost gost, Rezervacija rezervacija) {
		super();
		this.opis = opis;
		this.ocena = ocena;
		this.gost = gost;
		this.rezervacija = rezervacija;
	}

	public Utisak() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public float getOcena() {
		return ocena;
	}

	public void setOcena(float ocena) {
		this.ocena = ocena;
	}

	public Gost getGost() {
		return gost;
	}

	public void setGost(Gost gost) {
		this.gost = gost;
	}

	public Rezervacija getRezervacija() {
		return rezervacija;
	}

	public void setRezervacija(Rezervacija rezervacija) {
		this.rezervacija = rezervacija;
	}


	

}
