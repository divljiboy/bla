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
 * Klasa namenjena da podrzi pretragu jela koja nisu u jelovniku
 * @author 
 *
 */
public class PretragaJela extends HttpServlet {

	private static final long serialVersionUID = 6704688265102669654L;

	@EJB
	JeloDaoLocal jeloDao;
	
	@EJB
	JelovnikDaoLocal jelovnikDao;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession session =req.getSession();
		if(session.getAttribute("menadzer")!= null){
			String jelovnik_id = req.getParameter("id");
			Jelovnik j = jelovnikDao.findById(Integer.parseInt(jelovnik_id));
			HashSet<Jelo> pq = jeloDao.findJelaKojaNisuNaJelovniku(j);
			System.out.println(pq.size());
			session.setAttribute("jela", pq);
			session.setAttribute("jeloNaJelovniku",j);
			getServletContext().getRequestDispatcher("/dodavanjeJelaMenadzer.jsp").forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//Ovde ide pretraga
		super.doPost(req, resp);
	}
}
