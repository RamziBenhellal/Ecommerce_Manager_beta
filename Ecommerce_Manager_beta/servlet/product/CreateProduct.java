package product;


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


public class CreateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CreateProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	
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
			 
			List<Category> categories = session.createQuery("from Category").getResultList(); 
			 request.setAttribute("categories",categories);
			  
			  
			 session.getTransaction().commit();

		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		} finally {
			session.close();
			this.getServletContext().getRequestDispatcher("/WEB-INF/product/create.jsp").forward(request, response);
		}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			String name = request.getParameter("name");
			String mark = request.getParameter("mark");
			String description = request.getParameter("description");
			Double price = Double.parseDouble(request.getParameter("price"));
			Long quantity = (long) 0;
			
			session.beginTransaction();
			Category category = session.get(Category.class,Integer.parseInt(request.getParameter("category")));

			Product tmpProduct = new Product(name,mark,description,price,quantity,category,LocalDateTime.now());
			
			  
			session.save(tmpProduct);
			
			
			
			
			session.getTransaction().commit();
			 

		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		} finally {
			session.close();
			response.sendRedirect("/Ecommerce_Manager_beta/product/index");

		}
		}
	}

}
