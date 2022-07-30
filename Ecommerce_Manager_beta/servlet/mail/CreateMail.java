package mail;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Admin;
import model.Mail;



public class CreateMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin admin = (Admin) request.getSession().getAttribute("admin"); 
		if(admin == null ) {
			response.sendRedirect("/Ecommerce_Manager_beta/auth/login");
		}
		else {
		
		try {
			this.getServletContext().getRequestDispatcher("/WEB-INF/mail/create.jsp").forward(request, response);

		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		} finally {

		}
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin admin = (Admin) request.getSession().getAttribute("admin"); 
		if(admin == null) {
			response.sendRedirect("/Ecommerce_Manager_beta/auth/login");
		}
		else {
		
		 SessionFactory factory = new Configuration() 
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Mail.class)
				 .addAnnotatedClass(Admin.class)
				 .buildSessionFactory(); 
		 Session session = factory.getCurrentSession();
		 

		try {
			
			String recipientMail = request.getParameter("recipient");
			String subject = request.getParameter("subject");
			String text = request.getParameter("text");
			System.out.println(recipientMail);
			
			session.beginTransaction();
			List<Admin> recipient = session.createQuery("from Admin where email = '"+recipientMail+"'").getResultList();
			System.out.println(recipient.get(0));
			Mail tmpMail = new Mail(admin,recipient.get(0),subject,text.replaceAll("\\<.*?\\>", ""),LocalDateTime.now());
			
			
			session.save(tmpMail); 
			session.getTransaction().commit();
			

		} catch (Exception e) {
			request.setAttribute("error", "The recipient does not exist");
			this.getServletContext().getRequestDispatcher("/WEB-INF/mail/create.jsp").forward(request, response);

		} finally {
			session.close();
			response.sendRedirect("/Ecommerce_Manager_beta/mail/index");

		}
	}

}
}
