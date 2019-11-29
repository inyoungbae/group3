<!-- 수정 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%request.setCharacterEncoding("UTF-8"); %>
<body> 
  <c:set var="id" value="${sessionScope.id}"/> 
  <c:set var="grade" value="${sessionScope.grade}"/> 
    <!-- ***** Header Area Start ***** -->
    <header class="header_area" id="header">
        <div class="container-fluid h-100">
            <div class="row h-100">
                <div class="col-12 h-100">
                    <nav class="h-100 navbar navbar-expand-lg">
                        <a class="navbar-brand" href="index.jsp"><img src="img/core-img/15.png" alt=""></a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#dorneNav" aria-controls="dorneNav" aria-expanded="false" aria-label="Toggle navigation"><span class="fa fa-bars"></span></button>
                        <!-- Nav -->
                        <div class="collapse navbar-collapse" id="dorneNav">
                            <ul class="navbar-nav mr-auto" id="dorneMenu">
                                <li class="nav-item">
                                    <a class="nav-link" href="GoMain.do" style="font-size: 20px">Home</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="MainCampingview.do" style="font-size: 20px">Search</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="ReviewList.do?bcode=202&tcode=0&cp=1&ps=5" style="font-size: 20px">캠핑장 후기</a>
                                </li>
                                 <li class="nav-item">
                                     <a class="nav-link" href="TradeList.do?bcode=102" style="font-size: 20px">판매페이지</a>
                                </li>
                                <li class="nav-item">
                                <a class="nav-link" href="boardList.do?bcode=303&cp=1&ps=10&zcode=0" style="font-size: 20px">Notice</a>
                                </li>
                                <li class="nav-item">
                                <a class="nav-link" href="boardList.do?bcode=401&cp=1&ps=10&zcode=0" style="font-size: 20px">Q&A</a>
                                </li>
                                 <li>
                                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                 </li>
	                                <c:choose>
 	   								<c:when test="${id!=null && grade == '2'}">
 	   								<li class="nav-item">
 	   								<a class="nav-link" href="LogOut.do" style="font-size: 20px">Logout</a>
 	   								</li>
 	   								<li class="nav-item">
 	   								<a class="nav-link" href="GetMemberList.do" style="font-size: 20px">Memberlist</a>
 	   								</li>
	                                </c:when>  
	                                 <c:when test="${id!=null && grade == '1'}">
	                                 <li class="nav-item">
	                                 <a class="nav-link" href="LogOut.do" style="font-size: 20px">Logout</a>
	                                 </li>
	                                 <li class="nav-item">
	                                 <a class="nav-link" href="MyPage.do" style="font-size: 20px">Mypage</a>
	                                 </li>
                                    	</c:when> 
   										<c:otherwise>
   										<li class="nav-item">
   										<a class="nav-link" href="LogIn.do" style="font-size: 20px">Login</a>
   										</li>
   										<li class="nav-item">
   										<a class="nav-link" href="SignUp.do" style="font-size: 20px">Signup</a>
   										</li>
                              	</c:otherwise>
								</c:choose>
                         
                            </ul>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </header>
    <!-- ***** Header Area End ***** -->
</body>