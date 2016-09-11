package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.HashSet;
import java.util.List;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelovnik;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Sto;

public interface RestoranDaoLocal extends GenericDaoLocal<Restoran, Integer> {

    public HashSet<Jelovnik> ucitajJelovnike(Restoran k);
    public HashSet<Jelovnik> obrisiJelovnike(Restoran r, Jelovnik j);
    public HashSet<Jelovnik> dodajJelovnikURestoran(Restoran r, Jelovnik j);
	//public void addSto(Restoran restoran, Sto sto);
	public List<Restoran> pretragaRestorana(String s);
	//public void obrisiStolove(Restoran s);

}
