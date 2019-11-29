<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


    <%
	if(session.getAttribute("id") == null){
		//강제로 페이지 이동 
		out.print("<script>location.href='Login.jsp'</script>");
	}
    %>