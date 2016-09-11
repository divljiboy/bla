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
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.GostDaoLocal;

/**
 * 
 * @author 
 *
 */

public class PrijateljiController extends HttpServlet {

	private static final long serialVersionUID = 8223585225422301298L;

	@EJB
	GostDaoLocal gostDao;

	protected void doGet(javax.servlet.http.HttpServletRequest req,
			javax.servlet.http.HttpServletResponse resp)
			throws javax.servlet.ServletException, java.io.IOException {

		HttpSession session = req.getSession();
		if (session.getAttribute("gost") != null) {
			Gost gost = (Gost) session.getAttribute("gost");
			Set<Gost> prijateji = gostDao.findPrijatelje(gost);
			Set<Gost> nisuprijatelji=gostDao.findAllKojiMuNisuPrijatelji(gost);
			session.setAttribute("prijatelji", prijateji);
			session.setAttribute("nisuprijatelji", nisuprijatelji);
			
			getServletContext().getRequestDispatcher("/prijatelji.jsp")
					.forward(req, resp);
		}
		
	};

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
