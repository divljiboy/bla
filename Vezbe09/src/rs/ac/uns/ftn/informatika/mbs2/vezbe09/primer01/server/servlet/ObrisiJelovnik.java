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
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.JelovnikDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;

/**
 * 
 * @author 
 *
 */
public class ObrisiJelovnik extends HttpServlet{

	private static final long serialVersionUID = -7802217537814750006L;

	@EJB
	RestoranDaoLocal restoranDao;
	
	@EJB
	JelovnikDaoLocal jelovnikDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		if(session.getAttribute("menadzer")!= null){
			Manager m=(Manager)session.getAttribute("menadzer");
			Restoran r = m.getRestoran();
			String jelovnik_id = req.getParameter("id");
			Jelovnik j = jelovnikDao.findById(Integer.parseInt(jelovnik_id));
			System.out.println(j.getNaziv());
			HashSet<Jelovnik> jelovnici = restoranDao.obrisiJelovnike(r,j);
			jelovnikDao.remove(j);
			session.setAttribute("restoran", r);
			session.setAttribute("jelovnici", jelovnici);
			getServletContext().getRequestDispatcher("/jelovnici.jsp").forward(req, resp);
		}
		
	}
	
}
