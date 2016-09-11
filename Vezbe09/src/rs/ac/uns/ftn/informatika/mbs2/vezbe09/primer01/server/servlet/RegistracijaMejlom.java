package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.GostDaoLocal;

/**
 * 
 * @author 
 *
 */
public class RegistracijaMejlom extends HttpServlet {

	private static final long serialVersionUID = -7993312440735449249L;

	@EJB
	GostDaoLocal gostDao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = null;
		String password = null;

		if ((req.getParameter("username") != null)
				&& !"".equals(req.getParameter("username"))) {
			username = req.getParameter("username");
		}

		if ((req.getParameter("password") != null)
				&& !"".equals(req.getParameter("password"))) {
			password = req.getParameter("password");
		}
		Gost gost = null;
		if (password != null && username != null) {
			gost = new Gost();
			gost.setFirstName("user");
			gost.setLastName("user");
			gost.setUsername(username);
			gost.setPassword(password);

		}

		try {
			gostDao.registraj(gost);
			getServletContext().getRequestDispatcher("/loginKorisnik.jsp").forward(req, resp);
		} catch (Exception e) {
			resp.sendRedirect("http://localhost:8080/Vezbe09/registracija.jsp?Nijeuspelo");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
