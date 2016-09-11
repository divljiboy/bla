package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Manager;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Sto;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.StoDaoLocal;

public class KonfiguracijaMesta1 extends HttpServlet {

	private static final long serialVersionUID = 8062238015408642108L;

	
	@EJB
	StoDaoLocal stoDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = req.getSession();
		Sto s = null;
		if (session.getAttribute("menadzer") != null) {
			Manager m = (Manager) session.getAttribute("menadzer");
			String[] results = req.getParameterValues("sto");
			Restoran r = m.getRestoran();
			stoDao.getStoloviodRestorana(r);
			for (int i = 0; i < results.length; i++) {
				s = new Sto(i + 1, Integer.valueOf(results[i]), r);
				
				stoDao.persist(s);
				

			}
			session.setAttribute("restoran", m.getRestoran());
			getServletContext().getRequestDispatcher("/home.jsp").forward(req, resp);
		}
	}
}
