package auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Admin;
import model.Mail;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ecommerce_manager.AES;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/auth/login.jsp").forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SessionFactory factory = new Configuration() 
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Admin.class)
				 .addAnnotatedClass(Mail.class)
				 .buildSessionFactory(); 
		 Session session = factory.getCurrentSession();
		 

		try {
			
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			
			session.beginTransaction();
			
			
			
			if(session.createQuery("from Admin a where a.email = '"+email+"'").getResultList().isEmpty()){
				request.setAttribute("error", "Admin dont exist");
				this.getServletContext().getRequestDispatcher("/WEB-INF/auth/login.jsp").forward(request, response);
			}
			else {
				
				    Admin admin = (Admin) session.createQuery("from Admin a where a.email = '"+email+"'").getResultList().get(0);
					String hash = AES.decrypt(admin.getPassword(), "secret");
					
					if(password.equals(hash)) {
						
					HttpSession pageSession = request.getSession();
					pageSession.setAttribute("admin", admin);
					session.getTransaction().commit();
					this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
				}
					else {
						request.setAttribute("error", "Password Incorrect ");
						this.getServletContext().getRequestDispatcher("/WEB-INF/auth/login.jsp").forward(request, response);
					}
					
			}

			 
			 

		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		} finally {
			session.close();
			

		}
	}

}
