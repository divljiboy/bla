package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.ManagerDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;

public class InitMenadzerController extends HttpServlet {

	private static final long serialVersionUID = -7486843953779568543L;

	@EJB
	ManagerDaoLocal manDao;
	@EJB
	RestoranDaoLocal restoranDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		if(session.getAttribute("admin")!=null){
			session.setAttribute("menadzeriSistema", manDao.findAll());
			session.setAttribute("restorani", restoranDao.findAll());
			
			getServletContext().getRequestDispatcher("/menadzeri.jsp").forward(req, resp);
		}
		
	}
}
