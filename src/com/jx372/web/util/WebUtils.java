package com.jx372.web.util;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * web개발에 필요한 utils
 * */
public class WebUtils {
	public static void redirect(
			String url,
			HttpServletRequest request,
			HttpServletResponse response)throws IOException, ServletException{
		response.sendRedirect(url);
	}
	
	public static void forward(String path, 
			HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		
		RequestDispatcher rd = //내부에서 web info를 가는건 가능하다 외부에서 들어오는것은 차단
				request.getRequestDispatcher(path);
		//경로를 지정후 forward를 해준다
		rd.forward(request, response);
	}
}
