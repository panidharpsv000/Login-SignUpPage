package Controller;

import java.io.IOException;

import ModelObject.ModelObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import loginDAO.loginDAO;
@WebServlet("/loginPage")
public class CheckLoggedInData extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  int id=Integer.parseInt(request.getParameter("id"));
		  String password=request.getParameter("password");
		  ModelObject m1=new ModelObject();
		  m1.setId(id);
		  m1.setPassword(password);
		  loginDAO l1=new loginDAO();
		  HttpSession session=request.getSession();
		  if(l1.checkExists(m1))
		  {
			  session.setAttribute("id", id);
			  response.sendRedirect("welcome.jsp");
		  }
		  else
		  {
			  response.sendRedirect("login.html");
		  }
	}

}
