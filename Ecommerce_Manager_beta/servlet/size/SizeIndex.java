package size;

import java.io.IOException;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Address;
import model.Admin;
import model.Article;
import model.Cart;
import model.Category;
import model.Client;
import model.Color;
import model.Image;
import model.Order;
import model.Product;
import model.Size;
import model.User;

/**
 * Servlet implementation class Index
 */
public class SizeIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SizeIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin admin = (Admin) request.getSession().getAttribute("admin"); 
		if(admin == null || admin.getPriority() < 2 ) {
			response.sendRedirect("/Ecommerce_Manager_beta/auth/login");
		}
		else {
		
		SessionFactory factory = new Configuration() 
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Product.class)
				 .addAnnotatedClass(Category.class)
				 .addAnnotatedClass(Address.class)
				 .addAnnotatedClass(Client.class)
				 .addAnnotatedClass(Color.class)
				 .addAnnotatedClass(Size.class)
				 .addAnnotatedClass(Order.class)
				 .addAnnotatedClass(Cart.class)
				 .addAnnotatedClass(Article.class)
				 .addAnnotatedClass(Image.class)
				 .addAnnotatedClass(User.class)
				 .buildSessionFactory(); 
		 Session session = factory.getCurrentSession();
		 

		try {
			
			 session.beginTransaction();
			 
			List<Size> sizes = session.createQuery("from Size").getResultList(); 
			 request.setAttribute("sizes",sizes);
			  
			 session.getTransaction().commit();
			 

		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		} finally {
			session.close();
			this.getServletContext().getRequestDispatcher("/WEB-INF/size/index.jsp").forward(request, response);

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