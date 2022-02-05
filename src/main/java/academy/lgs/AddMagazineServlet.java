package academy.lgs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/addMagazines")
public class AddMagazineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MagazinesService magazinesService = MagazinesService.getMagazineService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("addMagazines.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		
		magazinesService.addMagazine(new Magazine(name,Integer.parseInt(price)));
		request.setAttribute("magazineName", name);	
		request.getRequestDispatcher("addMagazines.jsp").forward(request, response);
	}

}
