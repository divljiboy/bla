package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Admin;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelo;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelovnik;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Manager;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Sto;

@Stateless
@Remote(Init.class)
public class InitBean implements Init {

	@PersistenceContext(unitName = "Vezbe09")
	EntityManager em;

	public void init() {

		Admin admin = new Admin();
		admin.setFirstName("Ivan");
		admin.setLastName("Divljak");
		admin.setUsername("a");
		admin.setPassword("a");
		em.persist(admin);

		Gost gost1 = new Gost();
		gost1.setFirstName("Mitar");
		gost1.setLastName("Mitrovic");
		gost1.setUsername("gost");
		gost1.setPassword("gost");
		em.persist(gost1);

		Gost gost2 = new Gost();
		gost2.setFirstName("Lola");
		gost2.setLastName("Bojic");
		gost2.setUsername("gost2");
		gost2.setPassword("gost2");
		em.persist(gost2);

		Gost gost3 = new Gost();
		gost3.setFirstName("Pera");
		gost3.setLastName("Peric");
		gost3.setUsername("gost3");
		gost3.setPassword("gost3");
		em.persist(gost3);

		Gost gost4 = new Gost();
		gost4.setFirstName("Boba");
		gost4.setLastName("Mikic");
		gost4.setUsername("gost4");
		gost4.setPassword("gost4");
		em.persist(gost4);

		Gost gost5 = new Gost();
		gost5.setFirstName("Zivoin");
		gost5.setLastName("Misic");
		gost5.setUsername("gost5");
		gost5.setPassword("gost5");
		em.persist(gost5);

		Gost gost6 = new Gost();
		gost6.setFirstName("Moma");
		gost6.setLastName("Mitkovic");
		gost6.setUsername("gost6");
		gost6.setPassword("gost6");
		em.persist(gost6);

		
		gost1.dodajPrijateljaa(gost2);
		gost1.dodajPrijateljaa(gost3);
		gost2.dodajPrijateljaa(gost4);
		gost4.dodajPrijateljaa(gost1);
		gost2.dodajPrijateljaa(gost6);

		Restoran restoran1 = new Restoran();
		restoran1.setNaziv("Plava Frajla");
		restoran1.setOpis("Domaca kuhinja");

		Restoran restoran2 = new Restoran();
		restoran2.setNaziv("Panceta");
		restoran2.setOpis("Mediteranska kuhinja");
		em.persist(restoran2);

		Restoran restoran3 = new Restoran();
		restoran3.setNaziv("Fontana");
		restoran3.setOpis("Morska");
		em.persist(restoran3);

		Manager manager = new Manager();
		manager.setFirstName("Zika");
		manager.setLastName("Petrovic");
		manager.setUsername("menadzer");
		manager.setPassword("menadzer");
		manager.setRestoran(restoran1);
		em.persist(manager);

		Manager manager1 = new Manager();
		manager1.setFirstName("Mika");
		manager1.setLastName("Mikic");
		manager1.setUsername("menadzer1");
		manager1.setPassword("menadzer1");
		manager1.setRestoran(restoran2);
		em.persist(manager1);

		Manager manager2 = new Manager();
		manager2.setFirstName("Pera");
		manager2.setLastName("Peric");
		manager2.setUsername("menadzer2");
		manager2.setPassword("menadzer2");
		manager2.setRestoran(restoran3);
		em.persist(manager2);

		Set<Manager> menadzeri1 = new HashSet<Manager>();
		menadzeri1.add(manager);

		Set<Manager> menadzeri2 = new HashSet<Manager>();
		menadzeri2.add(manager2);

		Set<Manager> menadzeri3 = new HashSet<Manager>();
		menadzeri3.add(manager1);
		Random re = new Random();

		for (int i = 0; i < 5; i++) {
			Sto s = new Sto();
			s.setBroj(i  +1);
			s.setPozicija(re.nextInt(17)+1);
			s.setRestoran(restoran2);
			em.persist(s);

			
		}
		em.persist(restoran1);


		Jelovnik jelovnik1 = new Jelovnik();
		jelovnik1.setNaziv("Meni1");
		em.persist(jelovnik1);

		Jelovnik jelovnik2 = new Jelovnik();
		jelovnik2.setNaziv("Meni2");
		em.persist(jelovnik2);

		Jelovnik jelovnik3 = new Jelovnik();
		jelovnik3.setNaziv("Meni3");
		em.persist(jelovnik3);

		HashSet<Jelovnik> meni = new HashSet<Jelovnik>();
		meni.add(jelovnik1);
		meni.add(jelovnik3);
		meni.add(jelovnik2);

		HashSet<Jelovnik> meni1 = new HashSet<Jelovnik>();
		meni1.add(jelovnik1);
		meni1.add(jelovnik2);

		HashSet<Jelovnik> meni2 = new HashSet<Jelovnik>();
		meni2.add(jelovnik2);

		Jelo jelo1 = new Jelo();
		jelo1.setNaziv("Sarmica od zelja");
		jelo1.setOpis("Sarma sa zeljem");
		jelo1.setCena(530.00);
		em.persist(jelo1);

		Jelo jelo2 = new Jelo();
		jelo2.setNaziv("Pasulj");
		jelo2.setOpis("Corbast pasulj");
		jelo2.setCena(300.00);
		em.persist(jelo2);

		Jelo jelo3 = new Jelo();
		jelo3.setNaziv("Taljata");
		jelo3.setOpis("Taljata");
		jelo3.setCena(890.00);
		em.persist(jelo3);

		Jelo jelo4 = new Jelo();
		jelo4.setNaziv("Kiseli krastavac");
		jelo4.setOpis("Kiseli krastavac");
		jelo4.setCena(150.00);
		em.persist(jelo4);

		Jelo jelo5 = new Jelo();
		jelo5.setNaziv("Orasnica");
		jelo5.setOpis("Orasnica");
		jelo5.setCena(120.00);
		em.persist(jelo5);

		Jelo jelo6 = new Jelo();
		jelo6.setNaziv("Strudla");
		jelo6.setOpis("Strudla");
		jelo6.setCena(160.00);
		em.persist(jelo6);

		Jelo jelo7 = new Jelo();
		jelo7.setNaziv("Teletina ispod saca");
		jelo7.setOpis("Teletina ispod saca");
		jelo7.setCena(2100.00);
		em.persist(jelo7);

		Jelo jelo8 = new Jelo();
		jelo8.setNaziv("Lignje na zaru");
		jelo8.setOpis("Lignje na zaru");
		jelo8.setCena(900.00);
		em.persist(jelo8);

		Jelo jelo9 = new Jelo();
		jelo9.setNaziv("Morovicki tanjir");
		jelo9.setOpis("Morovicki tanjir");
		jelo9.setCena(1099.00);
		em.persist(jelo9);

		Jelo jelo10 = new Jelo();
		jelo10.setNaziv("Domaca supa");
		jelo10.setOpis("Domaca supa");
		jelo10.setCena(250.00);
		em.persist(jelo10);

		restoran1.addJelovnik(jelovnik1);
		restoran1.addJelovnik(jelovnik3);
		restoran2.addJelovnik(jelovnik2);
		restoran3.addJelovnik(jelovnik3);

		jelovnik1.addJelo(jelo1);
		jelovnik1.addJelo(jelo2);
		jelovnik1.addJelo(jelo3);
		jelovnik2.addJelo(jelo4);
		jelovnik2.addJelo(jelo5);
		jelovnik2.addJelo(jelo6);
		jelovnik3.addJelo(jelo7);
		jelovnik3.addJelo(jelo8);
		jelovnik3.addJelo(jelo9);
		jelovnik3.addJelo(jelo10);

		
		
	}
}