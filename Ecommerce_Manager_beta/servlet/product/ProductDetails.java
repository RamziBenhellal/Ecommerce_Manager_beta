package product;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
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


public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ProductDetails() {
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
			int id = Integer.parseInt(request.getParameter("id")); 
			Product product = session.get(Product.class, id);
			List<Article> articles = product.getArticles();
			List<Size> sizes = session.createQuery("from Size").getResultList(); 
			List<Color> colors = session.createQuery("from Color").getResultList();
			List<String> images = new ArrayList<>() ;
			product.getImages().forEach(img ->{
				images.add(Base64.getEncoder().encodeToString(img.getImage()));
			});
			 
			request.setAttribute("articles",articles);
			request.setAttribute("product",product);
			request.setAttribute("sizes",sizes);
			request.setAttribute("colors",colors);
			request.setAttribute("images",images );
			
			System.out.println(articles.size());
			  
			 session.getTransaction().commit();
			 

		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		} finally {
			session.close();
			this.getServletContext().getRequestDispatcher("/WEB-INF/product/details.jsp").forward(request, response);

		}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
		 
		 Integer id = Integer.parseInt(request.getParameter("id"));
		try {
			if ("delete".equals(request.getParameter("action"))) {
				session.beginTransaction();
				Product product = session.get(Product.class,id);			
				session.delete(product);
				session.getTransaction().commit();
				
			}
			else {
			Double price = Double.parseDouble(request.getParameter("price"));
			Long quantity = Long.parseLong(request.getParameter("quantity"));
			
			session.beginTransaction();
			Product product = session.get(Product.class,Integer.parseInt(request.getParameter("id")));
			Size size = session.get(Size.class,Integer.parseInt(request.getParameter("size")));
			Color color = session.get(Color.class,Integer.parseInt(request.getParameter("color")));
			
			if(price == 0.0)
				price = product.getPrice();


			Article tmpArticle = new Article(price,quantity,product,size,color,LocalDateTime.now());
			product.setQuantity(product.getQuantity()+ quantity);
			
			
			
			session.save(tmpArticle);
			session.update(product);
			session.getTransaction().commit();
			}

		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		} finally {
			
			session.close();
			response.sendRedirect("/Ecommerce_Manager_beta/product/details?id="+id);
		}
		}
	}
	
	

}
