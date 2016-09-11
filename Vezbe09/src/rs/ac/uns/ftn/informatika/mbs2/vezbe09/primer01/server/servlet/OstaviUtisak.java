package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Rezervacija;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Utisak;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RezervacijaDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.UtisakDaoLocal;

public class OstaviUtisak extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	RezervacijaDaoLocal rezervacijaDao;

	@EJB
	UtisakDaoLocal utisakDao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = req.getSession();
		if (session.getAttribute("gost") != null) {
			Gost gost = (Gost) session.getAttribute("gost");
			Rezervacija r = rezervacijaDao.findById(Integer.valueOf(req.getParameter("id")));
			Set<Rezervacija> lista = new HashSet<Rezervacija>();
			lista.add(r);

			req.setAttribute("trenutnarezervacija", lista);

			getServletContext().getRequestDispatcher("/noviutisak.jsp").forward(req, resp);
		}

	};

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		if (session.getAttribute("gost") != null) {
			Gost gost = (Gost) session.getAttribute("gost");
			Rezervacija r = rezervacijaDao.findById(Integer.valueOf(req.getParameter("rezsto")));
			String utisak = req.getParameter("utisak");
			Integer ocena = Integer.valueOf(req.getParameter("radios"));
			Utisak u = new Utisak(utisak, ocena, gost, r);
			
			
			utisakDao.merge(u);
			
			

			Set<Rezervacija> bla = rezervacijaDao.getPoseteodKorisnika(gost);

			session.setAttribute("mojeposete", (bla == null) ? "nemateposete" : bla);
			Set<Utisak> utisci =utisakDao.getUtisciodKorisnika(gost);

			session.setAttribute("mojiutisci", (bla == null) ? "nemateutiske" : utisci);


			getServletContext().getRequestDispatcher("/mojeposete.jsp").forward(req, resp);
		}

	};

}
