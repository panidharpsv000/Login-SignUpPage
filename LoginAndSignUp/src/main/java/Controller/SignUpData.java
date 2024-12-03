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
@WebServlet("/signUpPage")
public class SignUpData extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int id=Integer.parseInt(request.getParameter("id"));
		 String name=request.getParameter("name");
		 String pass=request.getParameter("password");
		 ModelObject m1=new ModelObject();
		 m1.setId(id);
		 m1.setPassword(pass);
		 m1.setName(name);
		 HttpSession session=request.getSession();
		 loginDAO l1=new loginDAO();
		 l1.addData(m1);
		 session.setAttribute("id", id);
		 response.sendRedirect("welcome.jsp");
	}

}
