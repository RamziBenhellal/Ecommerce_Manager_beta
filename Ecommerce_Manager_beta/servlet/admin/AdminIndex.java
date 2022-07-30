package admin;

import java.io.IOException;
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


public class AdminIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public AdminIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null || admin.getPriority() < 3) {
			response.sendRedirect("/Ecommerce_Manager_beta/auth/login");
		} else {
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Admin.class)
					.addAnnotatedClass(Mail.class)
					.buildSessionFactory();
			Session session = factory.getCurrentSession();
			try {
				
				session.beginTransaction();
				 
				List<Admin> admins = session.createQuery("from Admin").getResultList();
				
				request.setAttribute("admins",admins);
				session.getTransaction().commit();
				 

			} catch (Exception e) {
				request.setAttribute("error", e.getMessage());
			} finally {
				session.close();
				this.getServletContext().getRequestDispatcher("/WEB-INF/admin/index.jsp").forward(request, response);

			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
