package article;

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

/**
 * Servlet implementation class Edit
 */
public class EditArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditArticle() {
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
			
			int id = Integer.parseInt(request.getParameter("id")); 
			Article article = session.get(Article.class, id);
			
			List<Size> sizes =  session.createQuery("from Size").getResultList(); 
			List<Color> colors = session.createQuery("from Color").getResultList();
			
			request.setAttribute("article",article);
			request.setAttribute("sizes",sizes); 
			request.setAttribute("colors",colors);
			 
			session.getTransaction().commit();

		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		} finally {
			session.close();
			this.getServletContext().getRequestDispatcher("/WEB-INF/article/edit.jsp").forward(request, response);
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
		 int id = Integer.parseInt(request.getParameter("id")); 

		try {
			Long quantity = Long.parseLong(request.getParameter("quantity"));			
			Double price = Double.parseDouble(request.getParameter("price"));
			
			
			
			
			
			session.beginTransaction();
			
			
			Article article = session.get(Article.class, id);
			Product p = session.get(Product.class,article.getProduct().getId());

			if(price == 0)
				price = article.getProduct().getPrice();
			
			Size size = session.get(Size.class,Integer.parseInt(request.getParameter("size")));
			Color color = session.get(Color.class,Integer.parseInt(request.getParameter("color")));

			
			article.setPrice(price);
			article.setQuantity(quantity);
			article.setSize(size);
			article.setColor(color);
			article.setUpdatedAt(LocalDateTime.now());
			session.update(article);
			
			Long q = (long) 0;
			for (int i = 0; i < p.getArticles().size();i++) {
				q += p.getArticles().get(i).getQuantity();
				
			}
			
			p.setQuantity(q);
			
			
			 
			session.update(p);
			session.getTransaction().commit();
			
			
			
			

		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			
		} finally {
			session.close();
			response.sendRedirect("/Ecommerce_Manager_beta/article/details?id="+id);

		}
		}
	}

}
