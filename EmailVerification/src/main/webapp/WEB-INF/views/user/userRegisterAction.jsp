<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.junhee.email.model.UserVO" %>
<%@ page import="com.junhee.email.user.IUserMapper" %>
<%@ page import="com.junhee.email.util.SHA256" %>
<%@ page import="java.io.PrintWriter" %> <!-- 특정 스크립트 구문 출력 -->

<%

	String userId = null;
	String userPw = null;
	String userEmail = null;
	if(request.getParameter("userId") != null){
		userId = request.getParameter("userId");
	}
	if(request.getParameter("userPw") != null){
		userPw = request.getParameter("userPw");
	}
	if(request.getParameter("userEmail") != null){
		userEmail = request.getParameter("userEmail");
	}
	
	if(userId == null || userPw == null || userEmail == null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('입력이 안 된 사항이 있습니다.');");
		script.println("history.back();");
		script.println("</script>");
		script.close();
		return;
	}

%>