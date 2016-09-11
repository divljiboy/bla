package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Manager;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;

/**
 * 
 * @author 
 *
 */
public class KonfiguracijaMesta extends HttpServlet {

	private static final long serialVersionUID = -768414798218043830L;

	@EJB
	RestoranDaoLocal restoranDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("menadzer")!=null){
			Manager m = (Manager) session.getAttribute("menadzer");
			session.setAttribute("restoran", m.getRestoran());
			getServletContext().getRequestDispatcher("/konfiguracijaMesta.jsp").forward(req, resp);
		}
	}
	
	
}
