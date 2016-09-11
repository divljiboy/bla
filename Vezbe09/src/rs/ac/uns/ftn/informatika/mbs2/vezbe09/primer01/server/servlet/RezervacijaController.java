package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.ejb.EJB;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Rezervacija;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Sto;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.GostDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RestoranDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.RezervacijaDaoLocal;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.StoDaoLocal;

/**
 * 
 * @author
 *
 */
public class RezervacijaController extends HttpServlet {

	private static final long serialVersionUID = -280662383637566334L;
	final String emailaa = "oberon933@gmail.com";
	final String passwordaaa = "ivan1993";

	@EJB
	RestoranDaoLocal restoranDao;
	@EJB
	GostDaoLocal gostDao;

	@EJB
	StoDaoLocal stoDao;
	@EJB
	RezervacijaDaoLocal rezervacijaDao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session.getAttribute("gost") != null) {

			String restoran_i = req.getParameter("id");
			Integer restorani_id = Integer.parseInt(restoran_i);
			Gost gost = (Gost) session.getAttribute("gost");
			Set<Gost> prijatelji = (HashSet<Gost>) gostDao.findPrijatelje(gost);

			Restoran restoran = restoranDao.findById(restorani_id);
			req.setAttribute("restoranRezervacija", restoran);

			Set<Sto> sto = stoDao.getStoloviodRestorana(restoran);

			req.setAttribute("rezervacijasto", sto);
			req.setAttribute("prijatelji", prijatelji);
			getServletContext().getRequestDispatcher("/novarezervacija.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		if (session.getAttribute("gost") != null) {

			Restoran restoran = restoranDao.findById(Integer.valueOf(req.getParameter("restoran")));

			java.sql.Timestamp od;
			java.sql.Timestamp doo;
			java.util.Date datum = null;
			java.util.Date vreme = null;
			Calendar c = Calendar.getInstance();
			try {
				datum = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("datum"));
				vreme = new SimpleDateFormat("hh:mm").parse(req.getParameter("vreme"));
				datum = new Date(datum.getTime() + vreme.getTime());
				c.setTime(datum);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			od = new Timestamp(c.getTime().getTime());

			doo = new Timestamp(c.getTime().getTime() + 3600 * 1000 * Integer.valueOf(req.getParameter("trajanje")));

			Gost bla = (Gost) session.getAttribute("gost");

			Sto sto = stoDao.findById(Integer.valueOf(req.getParameter("rezsto")));
			String[] prijatelji = req.getParameterValues("prija");
			

			Rezervacija r = new Rezervacija(od, doo, restoran, bla, null, sto);
			List<Rezervacija> sverezervacije = rezervacijaDao.findAll();
			boolean flag = true;

			for (int i = 0; i < sverezervacije.size(); i++) {
				if (sverezervacije.get(i).getRestoran().getId() == restoran.getId()) {
					if (sverezervacije.get(i).getSto().getId() == sto.getId()) {
						if (!((od.before(sverezervacije.get(i).getOd()) && doo.before(sverezervacije.get(i).getOd()))
								|| (od.after(sverezervacije.get(i).getDoo())
										&& doo.after(sverezervacije.get(i).getDoo())))) {
							flag = false;
							resp.sendRedirect("http://localhost:8080/Vezbe09/rezervacija.jsp?Nijeuspelo");
							break;
						}
					}
				}

			}
			if (flag == true) {
				Rezervacija asd = rezervacijaDao.merge(r);
				
				List<Gost> gosti = new ArrayList<Gost>();
				for (int i = 0; i < prijatelji.length; i++) {
					Gost g = gostDao.findById(Integer.valueOf(prijatelji[i]));
					gosti.add(g);

				}

				Properties props = new Properties();
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.port", "587");

				Session session1 = Session.getInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(emailaa, passwordaaa);
					}
				});

				for(int i=0;i<gosti.size();i++){
				try {

					Message message = new MimeMessage(session1);
					message.setFrom(new InternetAddress(emailaa));
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("ivan93.ns@hotmail.com"));
					message.setSubject("Potvrda rezervacije");
					message.setText("Ovde mozete potvrditi dolazak na rezervaciju "
							+ "http://localhost:8080/Vezbe09/PotvrdaRezervacije?idrez=" + asd.getRezervacija_id() + "&idkor="
							+ gosti.get(i).getId());

					Transport.send(message);

				} catch (MessagingException e) {
					throw new RuntimeException(e);
				}}

				resp.sendRedirect("http://localhost:8080/Vezbe09/home.jsp");

			}

		}

	}
}
