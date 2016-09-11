package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Rezervacija;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.GostDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RezervacijaDaoLocal;

public class PotvrdaRezervacije extends HttpServlet {
	/**
	 * 
	 */

	@EJB
	RezervacijaDaoLocal rezervacijaDao;
	@EJB
	GostDaoLocal gostDao;

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer idrez = Integer.valueOf(req.getParameter("idrez"));

		Integer idkor = Integer.valueOf(req.getParameter("idkor"));

		Gost g = null;
		Rezervacija r = null;

		if (idrez != null && idkor != null) {

			r = rezervacijaDao.findById(idrez);
			g = gostDao.findById(idkor);

		}

		req.setAttribute("potvrdarez", r);
		req.setAttribute("potvrdagost", g);

		getServletContext().getRequestDispatcher("/potvrdarez.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idrez=Integer.valueOf((String) req.getParameter("idrez"));
		Integer idgost=Integer.valueOf((String) req.getParameter("idgost"));
			System.out.println("Usao sam u rezervaciju");
			String act = req.getParameter("button");
			if (act.equals("OK")) {

				if(idrez!=null && idgost!=null){
					Gost g=gostDao.findById(idgost);
					Rezervacija r= rezervacijaDao.findById(idrez);
					
				rezervacijaDao.dodajPrijateljaZaRezerv(r,g);
				
				getServletContext().getRequestDispatcher("/potvrdno.jsp").forward(req, resp);
				}
				
				
			} else if (act.equals("CANCEL")) {
				getServletContext().getRequestDispatcher("/odbijanje.jsp").forward(req, resp);
				
			} 
			
	}

}
