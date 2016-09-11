package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.servlet;

import java.io.IOException;
import java.util.Properties;

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

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session.GostDaoLocal;

/**
 * 
 * @author
 *
 */

public class RegisterGostController extends HttpServlet {
	final String emailaa = "oberon933@gmail.com";
	final String passwordaaa = "ivan1993";

	private static final long serialVersionUID = -8188291444621503421L;

	@EJB
	private GostDaoLocal gostDao;

	@SuppressWarnings("static-access")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String username = null;
		String password = null;
		String password2 = null;

		if ((req.getParameter("korisnickoIme") != null)
				&& !"".equals(req.getParameter("korisnickoIme"))) {
			username = req.getParameter("korisnickoIme");
		}

		if ((req.getParameter("lozinka") != null)
				&& !"".equals(req.getParameter("lozinka"))) {
			password = req.getParameter("lozinka");
		}

		if ((req.getParameter("lozinka2") != null)
				&& !"".equals(req.getParameter("lozinka2"))) {
			password2 = req.getParameter("lozinka2");
		}

		Gost gost = null;
			



		
		if(password!=null && password2!=null && password.equals(password2) && username!=null){
			gost = new Gost();
			gost.setFirstName("user");
			gost.setLastName("user");
			gost.setUsername(username);
			gost.setPassword(password);
		}
		//
	
		   Properties props = new Properties();
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");

	        Session session = Session.getInstance(props,
	          new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(emailaa,passwordaaa);
	            }
	          });

	        try {

	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(emailaa));
	            message.setRecipients(Message.RecipientType.TO,
	                InternetAddress.parse("ivan93.ns@hotmail.com"));
	            message.setSubject("Aktivacija akaunta");
	            message.setText("Aktivaciju registracije mozete izvrsiti na sledecem linku: "+ "http://localhost:8080/Vezbe09/RegistracijaMejlom?username="+username+"&password="+password);

	            Transport.send(message);

	         
	        } catch (MessagingException e) {
	            throw new RuntimeException(e);
	        }
		
		
		getServletContext().getRequestDispatcher("/loginKorisnik.jsp").forward(req, resp);
		
		
				
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
