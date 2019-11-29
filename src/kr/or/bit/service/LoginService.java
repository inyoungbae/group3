/*추가(양찬식)*/
package kr.or.bit.service;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemberDao;

public class LoginService implements Action{

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws NamingException {
      //1. 데이터 받기
      String id = request.getParameter("id");
      String pwd = request.getParameter("pwd");
            
      //2. 데이터 확인
      System.out.println(id + " / " + pwd);
      
      //3. 처리
      MemberDao memberdao = new MemberDao();
      int isLogin = memberdao.Login(id, pwd);
         
      String board_msg = "";
      String board_url = "";
         
      if(isLogin==1) { //id와 pwd가 맞으면..
         //세션 가져와서 login 정보 저장
         HttpSession session = request.getSession();
         session.setAttribute("id",id);
         System.out.println("아이디는 ? "+id);
         session.setAttribute("grade", isLogin);
         System.out.println("등급은 ? "+isLogin);
         board_msg = "로그인 성공";
         board_url = request.getContextPath()+"/GoMain.do";
      }else if(isLogin==2) {
    	  HttpSession session = request.getSession();
          session.setAttribute("id",id);
          session.setAttribute("grade", isLogin);
          board_msg = "로그인 성공";
          board_url = request.getContextPath()+"/GoMain.do";
      }else {
         board_msg = "로그인 실패, 다시 시도해 주세요.";
         board_url = "LogIn.do";
      }
      
      //4. 결과저장
      request.setAttribute("board_msg",board_msg);
      request.setAttribute("board_url",board_url);
      
      //5. 객체생성
      ActionForward forward = new ActionForward();
      forward.setPath("/WEB-INF/redirect.jsp");
      
      return forward;
            
            
            
      
   }
   
   
}
