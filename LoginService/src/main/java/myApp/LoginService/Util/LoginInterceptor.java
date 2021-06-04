package myApp.LoginService.Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import myApp.LoginService.Service.LoginService;
@Component
public class LoginInterceptor implements HandlerInterceptor   {

	
   @Autowired
   LoginService ls;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
		String name= request.getParameter("uname");
		String passWord= request.getParameter("pwd");
		
		boolean  b= ls.ValidateUser(name,passWord);
		
		if(b==true) {
			
			request.getSession().setAttribute("name", name);
			request.getSession().setAttribute("pwd", passWord);
			
			return true;
		}
		else {
			
			response.sendRedirect(request.getContextPath()+"/errorLogin");
		
			return false;
		}
			
		
		
		
		
	}
	
	
	

}
