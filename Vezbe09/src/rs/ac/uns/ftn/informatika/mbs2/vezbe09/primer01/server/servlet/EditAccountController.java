package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Admin;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Manager;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.AdminDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.GostDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.ManagerDaoLocal;
/**Klasa koja omogucava izmenu naloga.
 * Svi nalozi se menjaju unutar nje. U do Get se dobijaju podaci koji se prodjedjuju na editAccount.jsp.
 * A doPost metoda obradjuje vracane podatke
 * @author jelica
 *
 */
public class EditAccountController extends HttpServlet {

	private static final long serialVersionUID = 990134022583077306L;

	@EJB
	GostDaoLocal gostDao;

	@EJB
	AdminDaoLocal adminDao;

	@EJB
	ManagerDaoLocal managerDao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession session = req.getSession();
		Gost g = (Gost) session.getAttribute("gost");
		Admin a = (Admin) session.getAttribute("admin");
		Manager m = (Manager) session.getAttribute("menadzer");

		if (g != null) {
			String gost_i = req.getParameter("id");
			Integer gost_id = Integer.parseInt(gost_i);

			Gost gost = gostDao.findById(gost_id);
			req.setAttribute("editAccount", gost);
			getServletContext().getRequestDispatcher("/editAccount.jsp")
					.forward(req, resp);
		}

		if (a != null) {
			String admin_i = req.getParameter("id");
			Integer admin_id = Integer.parseInt(admin_i);

			Admin admin = adminDao.findById(admin_id);
			req.setAttribute("editAccount", admin);
			getServletContext().getRequestDispatcher("/editAccount.jsp")
					.forward(req, resp);

		}

		if (m != null) {
			String manager_i = req.getParameter("id");
			Integer manager_id = Integer.parseInt(manager_i);

			Manager manager = managerDao.findById(manager_id);
			req.setAttribute("editAccount", manager);
			getServletContext().getRequestDispatcher("/editAccount.jsp")
					.forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String ime = null;
		String prezime = null;
		String lozinka = null;

		
		if(req.getParameter("firstName")!=null && !req.getParameter("firstName").equals(""))
			ime = req.getParameter("firstName");
		
		if(req.getParameter("lastName")!=null && !req.getParameter("lastName").equals(""))
			prezime = req.getParameter("lastName");
		
		if(req.getParameter("password")!=null && !req.getParameter("password").equals(""))
			lozinka = req.getParameter("password");
		
		HttpSession session = req.getSession();
		Gost gost1 = (Gost) session.getAttribute("gost");
		Admin admin1 = (Admin) session.getAttribute("admin");
		Manager manager1 = (Manager) session.getAttribute("menadzer");
		
		if(gost1!=null){
			String i = req.getParameter("id");
			Integer id = Integer.parseInt(i);

			Gost gost = gostDao.findById(id);
			gost.setFirstName(ime);
			gost.setLastName(prezime);
			gost.setPassword(lozinka);


			gost1.setFirstName(ime);
			gost1.setLastName(prezime);
			gost1.setPassword(lozinka);

			gostDao.merge(gost);
			
		}
		
		if(admin1!=null){
		
			String i = req.getParameter("id");
			Integer id = Integer.parseInt(i);
			
			Admin admin = adminDao.findById(id);
			admin.setFirstName(ime);
			admin.setLastName(prezime);
			admin.setPassword(lozinka);
			
			
			admin1.setFirstName(ime);
			admin1.setLastName(prezime);
			admin1.setPassword(lozinka);
			adminDao.merge(admin);
		}
		
		if(manager1!=null){
			String i = req.getParameter("id");
			Integer id = Integer.parseInt(i);
			
			Manager manager = managerDao.findById(id);
			manager.setFirstName(ime);
			manager.setLastName(prezime);
			manager.setPassword(lozinka);
			
			
			manager1.setFirstName(ime);
			manager1.setLastName(prezime);
			manager1.setPassword(lozinka);
			managerDao.merge(manager);
		}

		getServletContext().getRequestDispatcher("/home.jsp")
				.forward(req, resp);

	}
}
