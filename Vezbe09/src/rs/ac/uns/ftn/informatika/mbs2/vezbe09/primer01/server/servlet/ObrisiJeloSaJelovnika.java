package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;
import java.util.HashSet;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelo;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelovnik;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.JeloDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.JelovnikDaoLocal;
/**
 * Klasa koja omogucava brisanje iz menija
 * @author 
 *
 */
public class ObrisiJeloSaJelovnika extends HttpServlet {

	private static final long serialVersionUID = -7631230345112089769L;

	@EJB
	JeloDaoLocal jeloDao;
	
	@EJB
	JelovnikDaoLocal jelovnikDao;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		if(session.getAttribute("menadzer")!=null){
			
			String jelo_id = req.getParameter("id");
			String jelovnik_id = req.getParameter("jelovnik");
			
			Jelo jeloZaBrisanje = jeloDao.findById(Integer.parseInt(jelo_id));
			Jelovnik j = jelovnikDao.findById(Integer.parseInt(jelovnik_id));
			
		//	jeloDao.remove(jeloZaBrisanje);
			
			j.removeJelo(jeloZaBrisanje);
			HashSet<Jelo> jela = jelovnikDao.noviJelovnik(j,jeloZaBrisanje);
			session.setAttribute("jela", jela);
			session.setAttribute("jeloNaJelovniku", j);
			getServletContext().getRequestDispatcher("/izmenaMenijaMenadzer.jsp").forward(req, resp);
		}
		
		
	}
}
