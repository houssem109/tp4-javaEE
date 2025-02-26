package web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;
<<<<<<< HEAD
import dao.IPcDao;
import dao.PcDaoImpl;
import pc.entities.Pc;

@WebServlet(name = "cs", urlPatterns = { "/controleur", "*.do" })
public class ControleurServlet extends HttpServlet {
	IPcDao PcMetier;

	@Override
	public void init() throws ServletException {
		PcMetier = new PcDaoImpl();
=======
import dao.IProduitDao;
import dao.ProduitDaoImpl;
import metier.entities.Produit;

@WebServlet(name = "cs", urlPatterns = { "/controleur", "*.do" })
public class ControleurServlet extends HttpServlet {
	IProduitDao metier;

	@Override
	public void init() throws ServletException {
		metier = new ProduitDaoImpl();
>>>>>>> 53407e9 ( tp4 complet)
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/index.do")) {
<<<<<<< HEAD
			request.getRequestDispatcher("pcs.jsp").forward(request, response);
		} else if (path.equals("/chercher.do")) {
			String motCle = request.getParameter("motCle");
			PcModele model = new PcModele();
			model.setMotCle(motCle);
			List<Pc> prods = PcMetier.pcsParMC(motCle);
			model.setPcs(prods);
			request.setAttribute("model", model);
			request.getRequestDispatcher("pcs.jsp").forward(request, response);

		} else if (path.equals("/saisie.do")) {
			request.getRequestDispatcher("saisiePc.jsp").forward(request, response);
			
		} else if (path.equals("/save.do") && request.getMethod().equals("POST")) {
			String nom = request.getParameter("nom");
			double prix = Double.parseDouble(request.getParameter("prix"));
			Pc p = PcMetier.save(new Pc(nom, prix));
			request.setAttribute("pc", p);
=======
			request.getRequestDispatcher("produits.jsp").forward(request, response);
		} else if (path.equals("/chercher.do")) {
			String motCle = request.getParameter("motCle");
			ProduitModele model = new ProduitModele();
			model.setMotCle(motCle);
			List<Produit> prods = metier.produitsParMC(motCle);
			model.setProduits(prods);
			request.setAttribute("model", model);
			request.getRequestDispatcher("produits.jsp").forward(request, response);

		} else if (path.equals("/saisie.do")) {
			request.getRequestDispatcher("saisieProduit.jsp").forward(request, response);
		} else if (path.equals("/save.do") && request.getMethod().equals("POST")) {
			String nom = request.getParameter("nom");
			double prix = Double.parseDouble(request.getParameter("prix"));
			Produit p = metier.save(new Produit(nom, prix));
			request.setAttribute("produit", p);
>>>>>>> 53407e9 ( tp4 complet)

			//request.getRequestDispatcher("confirmation.jsp").forward(request, response);
			response.sendRedirect("chercher.do?motCle=");
		} else if (path.equals("/supprimer.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
<<<<<<< HEAD
			PcMetier.deletePc(id);
			response.sendRedirect("chercher.do?motCle=");

		

		} else if (path.equals("/editer.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Pc p = PcMetier.getPc(id);
			request.setAttribute("pc", p);
			request.getRequestDispatcher("editerPc.jsp").forward(request, response);
=======
			metier.deleteProduit(id);
			response.sendRedirect("chercher.do?motCle=");

		} else if (path.equals("/supprimer.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			metier.deleteProduit(id);
			response.sendRedirect("chercher.do?motCle=");

		} else if (path.equals("/editer.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Produit p = metier.getProduit(id);
			request.setAttribute("produit", p);
			request.getRequestDispatcher("editerProduit.jsp").forward(request, response);
>>>>>>> 53407e9 ( tp4 complet)
			
		} else if (path.equals("/update.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			String nom = request.getParameter("nom");
			double prix = Double.parseDouble(request.getParameter("prix"));
<<<<<<< HEAD
			Pc p = new Pc();
			p.setIdPc(id);
			p.setNomPc(nom);
			p.setPrix(prix);
			PcMetier.updatePc(p);
			request.setAttribute("pc", p);
=======
			Produit p = new Produit();
			p.setIdProduit(id);
			p.setNomProduit(nom);
			p.setPrix(prix);
			metier.updateProduit(p);
			request.setAttribute("produit", p);
>>>>>>> 53407e9 ( tp4 complet)
			//request.getRequestDispatcher("confirmation.jsp").forward(request, response);
			response.sendRedirect("chercher.do?motCle=");
		}

		else {
			response.sendError(Response.SC_NOT_FOUND);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}