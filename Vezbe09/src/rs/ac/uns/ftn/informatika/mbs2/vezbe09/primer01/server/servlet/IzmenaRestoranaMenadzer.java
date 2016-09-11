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
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;


public class IzmenaRestoranaMenadzer extends HttpServlet {

	private static final long serialVersionUID = 5255148579211271331L;

	@EJB
	RestoranDaoLocal restoranDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		if( session.getAttribute("menadzer")!=null){
		Manager m=(Manager)session.getAttribute("menadzer");
		Restoran r = m.getRestoran();
		HashSet<Jelovnik> jelovnici = restoranDao.ucitajJelovnike(r);
		session.setAttribute("restoran", r);
		session.setAttribute("jelovnici", jelovnici);
		getServletContext().getRequestDispatcher("/editRestoran.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession session = req.getSession();
		if(session.getAttribute("menadzer")!=null){
			

			String restoranIme = null;
			String restoranOpis = null;
			
			
			if(req.getParameter("restoranIme")!=null && !req.getParameter("restoranIme").equals(""))
					restoranIme =req.getParameter("restoranIme");
			
			if(req.getParameter("restoranOpis")!=null && !req.getParameter("restoranOpis").equals(""))
				restoranOpis = req.getParameter("restoranOpis");
			
			try {
				Manager m=(Manager)session.getAttribute("menadzer");
				Restoran r = m.getRestoran();
				r.setNaziv(restoranIme);
				r.setOpis(restoranOpis);
				restoranDao.merge(r);
			
				Restoran rest = m.getRestoran();
				session.setAttribute("restoran", rest);
				getServletContext().getRequestDispatcher("/restorani.jsp").forward(req, resp);
							
			} catch (Exception e) {
				resp.sendRedirect("http://localhost:8080/Vezbe09/restorani.jsp?Nijeuspelo");
			}
			
	}
		
	}
}
