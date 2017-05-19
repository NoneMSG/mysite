package com.jx372.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jx372.mysite.dao.UserDao;
import com.jx372.mysite.vo.UserVo;
import com.jx372.web.action.Action;
import com.jx372.web.util.WebUtils;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String email = request.getParameter("email");
		String passwd = request.getParameter("password");
		
		UserVo vo = new UserDao().get(email,passwd);
		if(vo==null){//인증실패
			//WebUtils.redirect("/mysite/user?a=loginform&result=fail", request, response);
			request.setAttribute("result", "fail");
			WebUtils.forward("/WEB-INF/views/user/loginform.jsp", request, response);
			//로직이 끝났으니까 코드를 종료시켜야 한다.
			return ;
		}
		//인증처리
		//seesion ID를 가져온다 없으면 만들어서 가져온다.
		HttpSession session = request.getSession(true);
		//session에 authUser의 정보 vo(객체)를 저장해놓는다.
		session.setAttribute("authUser", vo);
		
		//redirect to main
		WebUtils.redirect("/mysite/main", request, response);
	}

}
