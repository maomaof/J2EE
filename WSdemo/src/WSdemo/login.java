package WSdemo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login.ws")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public boolean loginStatus=false;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if ("admin".equals(username) && "admin".equals(password)) {
			loginStatus = true;
			response.getWriter().append("Login Successful");
			response.setStatus(200);
		}
		else {
			loginStatus = false;
			response.getWriter().append("Login Failed");
			response.setStatus(400);
		}
	}

}
