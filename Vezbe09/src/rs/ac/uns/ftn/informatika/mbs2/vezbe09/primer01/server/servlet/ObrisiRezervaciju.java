package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Rezervacija;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RezervacijaDaoLocal;

public class ObrisiRezervaciju extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	RezervacijaDaoLocal rezervacijaDao;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("gost")!=null){
			String rezervacija = req.getParameter("id");
			Gost gost = (Gost) session.getAttribute("gost");
			
			Rezervacija rez = rezervacijaDao.findById(Integer.parseInt(rezervacija));
			rezervacijaDao.remove(rez);
			
			session.setAttribute("mojerezervacije", rezervacijaDao.getRezervacijeodKorisnika(gost));
			getServletContext().getRequestDispatcher("/mojerezervacije.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
