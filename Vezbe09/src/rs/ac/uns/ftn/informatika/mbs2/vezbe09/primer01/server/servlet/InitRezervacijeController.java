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
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RezervacijaDaoBean;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RezervacijaDaoLocal;

public class InitRezervacijeController extends HttpServlet {

	/**
	 * 
	 * 
	 */
	@EJB
	RezervacijaDaoLocal	 rezervacijadao;

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		if (session.getAttribute("gost") != null) {
			Gost gost = (Gost) session.getAttribute("gost");
			Set<Rezervacija> bla =rezervacijadao.getRezervacijeodKorisnika(gost);
			
			session.setAttribute("mojerezervacije",(bla==null)?"nematerezervaciju":bla);

			getServletContext().getRequestDispatcher("/mojerezervacije.jsp").forward(req, resp);
		}

	}

}
