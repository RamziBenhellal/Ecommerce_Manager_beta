package image;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;



import org.apache.commons.io.IOUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
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

@MultipartConfig(maxFileSize = 1999999999)
public class AddImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
			String item = request.getParameter("item");
			session.beginTransaction();
			 if(item.equals("product")) {
			int id = Integer.parseInt(request.getParameter("id")); 
			Product product = session.get(Product.class, id);
			request.setAttribute("product",product);
			 }
			 else {
				 int id = Integer.parseInt(request.getParameter("id")); 
				 Article article = session.get(Article.class, id);
				 request.setAttribute("article",article);
			 }
			
			request.setAttribute("i",item);
			
			  
			 session.getTransaction().commit();

		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		} finally {
			session.close();
			this.getServletContext().getRequestDispatcher("/WEB-INF/image/add.jsp").forward(request, response);
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
		 int id = Integer.parseInt(request.getParameter("id"));
		 String item = request.getParameter("item");

		try {
			
			  
			  Part part = request.getPart("image");
			
			  InputStream is = part.getInputStream();
			  byte[] bytes = IOUtils.toByteArray(is);
			  
			  
			  session.beginTransaction();
			  if(item.equals("product")) {
				  Product product = session.get(Product.class, id);
				  Image tmpImg = new Image(bytes,product,LocalDateTime.now());
				  session.save(tmpImg);
			  }
			  
			  else {
				  Article article = session.get(Article.class, id);
				  Image tmpImg = new Image(bytes,article.getProduct(),article,LocalDateTime.now());
				  session.save(tmpImg);
			  }
			  
			  session.getTransaction().commit();
			 

		} catch (IOException e) {
			request.setAttribute("error", e.getMessage());
		} finally {
			session.close();
			if(item.equals("product")) {
			response.sendRedirect("/Ecommerce_Manager_beta/product/details?id="+id);
			}
			else {
			response.sendRedirect("/Ecommerce_Manager_beta/article/details?id="+id);
			}

		}
		}
	}

}
