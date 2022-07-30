package admin;

import java.io.IOException;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ecommerce_manager.AES;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Admin;
import model.Mail;


public class EditAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public EditAdmin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			response.sendRedirect("/Ecommerce_Manager-beta/auth/login");
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/admin/edit.jsp").forward(request, response);
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			response.sendRedirect("/Ecommerce_Manager_beta/auth/login");
		} else {

			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Admin.class)
					.addAnnotatedClass(Mail.class).buildSessionFactory();
			Session session = factory.getCurrentSession();
			try {
				session.beginTransaction();
				
				String oldPassword = request.getParameter("old_password");
				String password = request.getParameter("password");
				String confirm_password = request.getParameter("password2");

				String hash = AES.decrypt(admin.getPassword(), "secret");
				
				if(oldPassword.equals(hash)) {
					if(password.length() < 8 ) {
						request.setAttribute("error", "Password is less than 8 character ");
						this.getServletContext().getRequestDispatcher("/WEB-INF/admin/edit.jsp").forward(request, response);
					}
					else {
						if(!password.equals(confirm_password)) {
					
						request.setAttribute("error", "Passwords are not match ");
						this.getServletContext().getRequestDispatcher("/WEB-INF/admin/edit.jsp").forward(request, response);
					}
					else {
						String hash2 = AES.encrypt(password, "secret");
						admin.setPassword(hash2);
						session.update(admin);
						
					}
				}
				}
				else{
					request.setAttribute("error", "Old password is incorrect");
					this.getServletContext().getRequestDispatcher("/WEB-INF/admin/edit.jsp").forward(request, response);
				}


				session.getTransaction().commit();

			} catch (Exception e) {
				request.setAttribute("error", e.getMessage());
			} finally {
				session.close();
				request.setAttribute("success", "Password updated");
				this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);			}

		}
	
	}
}