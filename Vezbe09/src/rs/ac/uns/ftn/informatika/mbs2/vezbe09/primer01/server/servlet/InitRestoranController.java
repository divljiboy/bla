package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Manager;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;


/**
 * 
 * @author 
 */
public class InitRestoranController  extends HttpServlet{
	
	private static final long serialVersionUID = -3243697806677078116L;
	@EJB
	RestoranDaoLocal restoranDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("admin")!=null){
			session.setAttribute("restorani2", restoranDao.findAll());
			getServletContext().getRequestDispatcher("/restorani.jsp").forward(req, resp);
		}
		
		if(session.getAttribute("menadzer")!=null){
			Manager m=(Manager)session.getAttribute("menadzer");
			Restoran r = m.getRestoran();
			session.setAttribute("restoran", r);
			getServletContext().getRequestDispatcher("/restorani.jsp").forward(req, resp);
		}
		
		if(session.getAttribute("gost")!=null){
			session.setAttribute("restorani", restoranDao.findAll());
			getServletContext().getRequestDispatcher("/restorani.jsp").forward(req, resp);
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		if(session.getAttribute("gost")!=null){
			
			String ImeIliVrsta = req.getParameter("ImeIliVrsta");
			
			List<Restoran> restorani =  restoranDao.pretragaRestorana(ImeIliVrsta);
			session.setAttribute("restorani", restorani);
			getServletContext().getRequestDispatcher("/restorani.jsp").forward(req, resp);
		}
	}
	

}
