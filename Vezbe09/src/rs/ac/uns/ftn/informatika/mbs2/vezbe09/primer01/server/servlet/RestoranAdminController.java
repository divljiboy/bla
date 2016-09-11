package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;

/**
 * 
 * @author 
 *
 */

public class RestoranAdminController extends HttpServlet {

	private static final long serialVersionUID = 7968662134167742857L;

	
	@EJB
	RestoranDaoLocal restoranDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String restoran_i = req.getParameter("id");
		Integer restoran_id = Integer.parseInt(restoran_i);
		
		HttpSession session = req.getSession();
		
		
		Restoran restoran = restoranDao.findById(restoran_id);
		
		restoranDao.remove(restoran);
		
		session.setAttribute("restorani2", restoranDao.findAll());			
		getServletContext().getRequestDispatcher("/restorani.jsp").forward(req, resp);		
		

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		

	

	}
	
}
