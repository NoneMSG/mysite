package com.jx372.web.action;


import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//인터페이스
public interface Action {
	//함수를 통해서 데이터를 전송/수신 받을 수 있도록 한다. 주로 전송만 사용됨
	public void execute(
			HttpServletRequest request,
			HttpServletResponse response)
			throws IOException, ServletException;
	
}
