package met.web.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import met.web.app.*;

@javax.servlet.annotation.WebServlet({"/login", "/logout"})
public class AuthenticationServlet extends HttpServlet{

    @Override
	    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
			String uname = request.getParameter("txtUname");
			String pwd = request.getParameter("txtPwd");
			if ((uname == null) || (pwd == null)){
				response.sendRedirect("customer.jspx");
				return;
			}
			HttpSession session = request.getSession(true);
			CustomerBean bean = (CustomerBean)session.getAttribute("customer");
			if (bean==null){
			   bean = new CustomerBean();
			   session.setAttribute("customer", bean);
			}
			try{
					if (bean.authenticate(uname, pwd)){
						response.sendRedirect("order.jspx");		
					}else{
						response.sendRedirect("customer.jspx?failed=true");
					}
			}catch(Exception ex){
					response.sendError(500,ex.getMessage());
			}

        }

     @Override
	     public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
	         HttpSession session = request.getSession(false);
	         if(session != null)
	         session.invalidate();
	         RequestDispatcher rd = request.getRequestDispatcher("/product.jspx");
	         rd.forward(request, response);
	    }

}
