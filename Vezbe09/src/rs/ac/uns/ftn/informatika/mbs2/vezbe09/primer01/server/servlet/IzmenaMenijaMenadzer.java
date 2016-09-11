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
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.JelovnikDaoLocal;
/**
 * 
 * @author 
 *
 */
public class IzmenaMenijaMenadzer extends HttpServlet {

	private static final long serialVersionUID = -4897048122384422164L;

	@EJB
	JelovnikDaoLocal jelovnikDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		if(session.getAttribute("menadzer")!=null){

			String jelovnik_id = req.getParameter("id");
			Jelovnik j = jelovnikDao.findById(Integer.parseInt(jelovnik_id));
			
			HashSet<Jelo> jela = jelovnikDao.ucitajJela(j);
			session.setAttribute("jela", jela);
			session.setAttribute("jeloNaJelovniku", j);
			getServletContext().getRequestDispatcher("/izmenaMenijaMenadzer.jsp").forward(req, resp);
		}
	}
}
