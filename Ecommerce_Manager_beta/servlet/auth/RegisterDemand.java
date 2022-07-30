package auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Admin;
import model.Mail;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class RegisterDemand
 */
public class RegisterDemand extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterDemand() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/auth/register_demand.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory factory = new Configuration() 
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Admin.class)
				 .addAnnotatedClass(Mail.class)
				 .buildSessionFactory(); 
		 Session session = factory.getCurrentSession();
		 

		try {
			
			String email = request.getParameter("email");
			Integer priority = Integer.parseInt(request.getParameter("priority"));
			
			session.beginTransaction();
			
			String role = ( priority == 1) ? "Order manager" : ( (priority == 2) ? "Marketing Manager" : "Administrator" );
			String subject = "Add a user as "+ role;
			String txt = " send a request to be added as "+ role + "\n" + "Email: "+email;
			
			List<Admin> admins = session.createQuery("from Admin WHERE priority = 3").getResultList();
			
			admins.forEach(a ->{
				Mail tmpMail = new Mail(null,a,subject,txt,LocalDateTime.now());
				session.save(tmpMail);
			});
			
			 session.getTransaction().commit();
			 

		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		} finally {
			session.close();
			request.setAttribute("message", "Your request should be processed within 1 business day");
			this.getServletContext().getRequestDispatcher("/WEB-INF/messages.jsp").forward(request, response);

		}

	}

}
