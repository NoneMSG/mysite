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

public class ModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//1. 인증여부
				HttpSession session = request.getSession();
				if(session == null){
					WebUtils.redirect("/mysite/user?a=loginform", request, response);
					return;
				}
				//문자열 약속이 필요
				UserVo authUser = (UserVo)session.getAttribute("authUser");
				if(authUser == null){
					WebUtils.redirect("/mysite/user?a=loginform", request, response);
					return;
				}
				
				Long no = authUser.getNo();
				String name = request.getParameter("name");
				String passwd = request.getParameter("password");
				String gender = request.getParameter("gender");
				
				UserVo vo = new UserVo();
				
				vo.setName(name);
				vo.setPasswd(passwd);
				vo.setGender(gender);
				vo.setNo(no);
				new UserDao().update(vo);
				WebUtils.redirect("/mysite/user?a=loginform", request, response);
	}

}
