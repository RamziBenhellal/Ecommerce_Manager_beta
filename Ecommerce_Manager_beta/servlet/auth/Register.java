package auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Admin;
import model.Mail;

import java.io.IOException;
import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ecommerce_manager.AES;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin admin = (Admin) request.getSession().getAttribute("admin"); 
		if(admin == null || admin.getPriority() != 3 ) {
			response.sendRedirect("/Ecommerce_Manager_beta_beta/auth/login");
		}
		else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/auth/register.jsp").forward(request, response);
	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin admin = (Admin) request.getSession().getAttribute("admin"); 
		if(admin == null || admin.getPriority() != 3 ) {
			response.sendRedirect("/Ecommerce_Manager_beta/auth/login");
		}
		else {
		
		SessionFactory factory = new Configuration() 
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Admin.class)
				 .addAnnotatedClass(Mail.class)
				 .buildSessionFactory(); 
		 Session session = factory.getCurrentSession();
		 

		try {
			
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String confirm_password = request.getParameter("confirm_password");
			Integer priority = Integer.parseInt(request.getParameter("priority"));
			
			session.beginTransaction();
			
			
			
			if(!session.createQuery("from Admin a where a.email = '"+email+"'").getResultList().isEmpty()){
				request.setAttribute("error", "Admin is already exist");
				this.getServletContext().getRequestDispatcher("/WEB-INF/auth/register.jsp").forward(request, response);
			}
			else {
				if(password.length() < 8 ) {
					request.setAttribute("error", "Password is less than 8 character ");
					this.getServletContext().getRequestDispatcher("/WEB-INF/auth/register.jsp").forward(request, response);
				}
				else {
					if(!password.equals(confirm_password)) {
				
					request.setAttribute("error", "Passwords are not match ");
					this.getServletContext().getRequestDispatcher("/WEB-INF/auth/register.jsp").forward(request, response);
				}
				else {
					String hash = AES.encrypt(password, "secret");
					Admin tmpAdmin = new Admin(email, hash, priority, LocalDateTime.now());
					session.save(tmpAdmin);
					response.sendRedirect("/Ecommerce_Manager_beta");
				}
				}	
			}

			 session.getTransaction().commit();
			 

		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		} finally {
			session.close();

		}
		}
	}

}
