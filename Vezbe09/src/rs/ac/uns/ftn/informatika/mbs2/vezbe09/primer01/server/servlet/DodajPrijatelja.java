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
public class DodajPrijatelja extends HttpServlet {

	private static final long serialVersionUID = 257062789637837773L;

	@EJB
	GostDaoLocal gostDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("gost")!=null){
			Gost gost = (Gost) session.getAttribute("gost");
			
			String prijatelj_id = req.getParameter("id");
			Gost g = gostDao.findById(Integer.parseInt(prijatelj_id));
			gostDao.dodajPrijatelja(gost,g);
			
			Set<Gost> prijateji = gostDao.findPrijatelje(gost);
			Set<Gost> nisuprijateji = gostDao.findAllKojiMuNisuPrijatelji(gost);
			
			session.setAttribute("prijatelji", prijateji);
			session.setAttribute("nisuprijatelji", nisuprijateji);
			getServletContext().getRequestDispatcher("/prijatelji.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
