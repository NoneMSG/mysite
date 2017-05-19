package com.jx372.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jx372.mysite.vo.UserVo;
import com.jx372.web.action.Action;
import com.jx372.web.util.WebUtils;

public class LogOutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		
		if(session==null){
			WebUtils.redirect("/mysite/main", request, response);
			return;
		}
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		
		if(authUser == null){
			WebUtils.redirect("/mysite/main", request, response);
			return;
		}
		//	로그아웃 처리
		if(session !=null && session.getAttribute("authUser")!=null){
			session.removeAttribute("authUser");
			session.invalidate();
		}	
		WebUtils.redirect("/mysite/main", request, response);
	}

}
