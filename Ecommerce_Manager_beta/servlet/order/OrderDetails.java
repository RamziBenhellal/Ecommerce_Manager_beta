package order;

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


public class OrderDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDetails() {
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
			
		
			String id = request.getParameter("id");
			Order order = session.get(Order.class, id);
			List<Article> articles = order.getArticles();
			String [] paymentDetails = order.getPaymentDetails().split(",");
			System.out.println(articles.size());
			
		
			request.setAttribute("order",order); 
			request.setAttribute("articles",articles);
			request.setAttribute("paymentDetails",paymentDetails);
			  
			 session.getTransaction().commit();
			 

		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		} finally {
			session.close();
			this.getServletContext().getRequestDispatcher("/WEB-INF/order/details.jsp").forward(request, response);

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
