package met.web.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@javax.servlet.annotation.WebServlet({"/register"})
public class RegisterServlet extends HttpServlet{

    @Override
	    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
			HttpSession session = request.getSession();
			String id = request.getParameter("custId");	
			String pwd = request.getParameter("password");	
			String email = request.getParameter("email");	
			double credit = Double.parseDouble(request.getParameter("credit"));
			CustomerBean bean = new CustomerBean();	
			bean.setCustId(id);
			bean.setPassword(pwd);
			bean.setEmail(email);
			bean.setCredit(credit);
			try{
			
		  		if (bean.Register()){
					response.sendRedirect("customer.jspx?failed=false");
					return;
				}else{
					response.sendRedirect("register.jspx?failed=true");
					return;
				}
			   }catch(Exception ex){
						response.sendError(500,ex.getMessage());
				}

        }

}
