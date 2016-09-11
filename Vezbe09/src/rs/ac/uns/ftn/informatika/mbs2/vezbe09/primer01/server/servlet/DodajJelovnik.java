package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;
import java.util.HashSet;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelovnik;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Manager;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.JelovnikDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;

/**
 * Klasa koja omogucava dodavanje menija u resotoran
 * @author 
 *
 */
public class DodajJelovnik extends HttpServlet {

	private static final long serialVersionUID = -180559693072702521L;

	@EJB
	RestoranDaoLocal restoranDao;
	
	@EJB
	JelovnikDaoLocal jelovnikDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		if(session.getAttribute("menadzer")!=null){
			Manager m=(Manager)session.getAttribute("menadzer");
			Restoran r = m.getRestoran();
			session.setAttribute("restoran", r);
			getServletContext().getRequestDispatcher("/dodavanjeJelovnika.jsp").forward(req, resp);
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession session =req.getSession();
		if(session.getAttribute("menadzer")!= null){
			
			Manager mng = (Manager) session.getAttribute("menadzer");
			Restoran  r = mng.getRestoran();
			String jelovnikIme = null;
			
			if(req.getParameter("jelovnikIme")!=null && !req.getParameter("jelovnikIme").equals(""))
				jelovnikIme = req.getParameter("jelovnikIme");
			
			Jelovnik j= new Jelovnik();
			j.setNaziv(jelovnikIme);
	
			
			
			
			try {
				if(!jelovnikDao.findAll().contains(j)){
					jelovnikDao.persist(j);
					restoranDao.dodajJelovnikURestoran(r, j);
					HashSet<Jelovnik> jelovnici = restoranDao.ucitajJelovnike(r);
					session.setAttribute("restoran", r);
					session.setAttribute("jelovnici", jelovnici);
					getServletContext().getRequestDispatcher("/jelovnici.jsp").forward(req, resp);
				}
				
			} catch (Exception e) {
				resp.sendRedirect("http://localhost:8080/Vezbe09/jelovnici.jsp?Nijeuspelo");
			}
				
		}

		
		
	}
}
