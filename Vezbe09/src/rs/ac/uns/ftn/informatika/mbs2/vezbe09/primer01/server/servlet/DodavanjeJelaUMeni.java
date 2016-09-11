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
 * Klasa koja omogucava dodavanje jela u jelovnik
 * @author 
 *
 */
public class DodavanjeJelaUMeni extends HttpServlet {

	private static final long serialVersionUID = -59590444506082963L;
	
	@EJB
	JelovnikDaoLocal jelovnikDao;
	
	@EJB
	JeloDaoLocal jeloDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		if(session.getAttribute("menadzer")!=null){
		
		String jelovnik_id = req.getParameter("jelovnik");
		Jelovnik jelovnik = jelovnikDao.findById(Integer.parseInt(jelovnik_id));
		
		String jelo_id = req.getParameter("id");
		Jelo jelo = jeloDao.findById(Integer.parseInt(jelo_id));
		
		HashSet<Jelo> jela = jelovnikDao.addJeloNaJelovnik(jelovnik, jelo);
		
		session.setAttribute("jela", jela);
		session.setAttribute("jeloNaJelovniku", jelovnik);	
		getServletContext().getRequestDispatcher("/izmenaMenijaMenadzer.jsp").forward(req, resp);
		}
		
	}

}
