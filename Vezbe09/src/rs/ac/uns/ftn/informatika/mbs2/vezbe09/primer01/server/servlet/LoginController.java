package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.GostDaoLocal;

/**
 * 
 * @author 
 *
 */
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = -7345471861052209628L;
	
	@EJB
	private GostDaoLocal gostDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			String korisnickoIme = request.getParameter("korisnickoIme");
			String lozinka = request.getParameter("lozinka");
			
			if ((korisnickoIme == null) || (korisnickoIme.equals("")) || (lozinka == null) || (lozinka.equals(""))) {
				response.sendRedirect(response.encodeRedirectURL("./start.jsp"));
				return;
			}
			
			Gost gost = gostDao.findGostSaKorisnickimImenomILozinkom(korisnickoIme, lozinka);
					
			if (gost != null) {	
				HttpSession session1 = request.getSession(true);
				session1.invalidate();
				
				HttpSession session = request.getSession();
				session.setAttribute("gost", gost);
				getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
			}
			
		} catch (EJBException e) {
			if (e.getCause().getClass().equals(NoResultException.class)) {
				response.sendRedirect(response.encodeRedirectURL("./loginKorisnik.jsp"));
			} else {
				throw e;
			}
		} catch (ServletException e) {
			
			throw e;
		} catch (IOException e) {
			;
			throw e;
		}
	}

	protected void doPost(HttpServletRequest request, 	HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
