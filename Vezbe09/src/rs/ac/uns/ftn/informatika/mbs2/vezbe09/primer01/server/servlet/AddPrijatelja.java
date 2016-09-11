package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;
import java.util.HashSet;
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
public class AddPrijatelja extends HttpServlet {

	private static final long serialVersionUID = -3035195588053095187L;

	@EJB
	GostDaoLocal gostDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		/*HttpSession session=req.getSession();
		
		if(session.getAttribute("gost")!=null){
			
			Gost g = (Gost) session.getAttribute("gost");
			Set<Gost> mogucaResenja = gostDao.findAllKojiMuNisuPrijatelji(g);
			session.setAttribute("nisuprijatelji", mogucaResenja);
			session.setAttribute("prijatelji", gostDao.findPrijatelje(g));
			getServletContext().getRequestDispatcher("/prijatelji.jsp").forward(req, resp);
			}*/
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		if(session.getAttribute("gost")!=null){
			
			Gost gost = (Gost) session.getAttribute("gost");
			String imeIliPrezime = req.getParameter("imePrezime");
			System.out.println(imeIliPrezime);
			
			Set<Gost> mogucaResenja = gostDao.findImeiPrezime(imeIliPrezime,gost);
			//	HashSet<Gost> mogucaResenja = gostDao.findAllKojiMuNisuPrijatelji(gost);
			req.setAttribute("nisuprijatelji", mogucaResenja);
			getServletContext().getRequestDispatcher("/prijatelji.jsp").forward(req, resp);
		}
	}

}
