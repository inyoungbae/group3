package kr.or.bit.controller;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.or.bit.service.BoardDeleteService;
import kr.or.bit.service.BoardDetailService;
import kr.or.bit.service.BoardEditService;
import kr.or.bit.service.BoardListService;
import kr.or.bit.service.BoardWriteService;
import kr.or.bit.service.GotoWriteService;
import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.service.DetailCrossService;
import kr.or.bit.service.IdCheckService;
import kr.or.bit.service.ListCrossService;
import kr.or.bit.service.LoginService;
import kr.or.bit.service.LogoutService;
import kr.or.bit.service.MyInfoEditOkService;
import kr.or.bit.service.MyInfoEditService;
import kr.or.bit.service.MyZzimSearchService;
import kr.or.bit.service.SignUpService;
import kr.or.bit.service.ZzimListDeleteService;
import kr.or.bit.service.ZzimListInsertService;
import kr.or.bit.service.ZzimListService;
import kr.or.bit.service.idService;
import kr.or.bit.service.memberDeleteService;
import kr.or.bit.service.memberDetailService;
import kr.or.bit.service.memberEditOkService;
import kr.or.bit.service.memberEditService;
import kr.or.bit.service.memberListService;
import kr.or.bit.service.nameService;
import kr.or.bit.service.ReviewListService;
import kr.or.bit.service.ReviewSearchService;
import kr.or.bit.service.ReviewWriteService;
import kr.or.bit.service.MyPageReviewService;
import kr.or.bit.service.MyTradePageService;
import kr.or.bit.service.RecentReviewService;
import kr.or.bit.service.ReplyDeleteService;
import kr.or.bit.service.ReplyListService;
import kr.or.bit.service.ReplyWriteService;
import kr.or.bit.service.ReviewDeleteService;
import kr.or.bit.service.ReviewDetailService;
import kr.or.bit.service.ReviewEditOkService;
import kr.or.bit.service.ReviewEditService;
import kr.or.bit.service.SignUpService;
import kr.or.bit.service.ZzimListService;
import kr.or.bit.service.TradeDeleteService;
import kr.or.bit.service.TradeDetailService;
import kr.or.bit.service.TradeEditOkService;
import kr.or.bit.service.TradeEditService;
import kr.or.bit.service.TradeListService;
import kr.or.bit.service.TradeReplyDeleteService;
import kr.or.bit.service.TradeReplyListService;
import kr.or.bit.service.TradeReplyWriteService;
import kr.or.bit.service.TradeWriteService;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();

	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Action action = null;
		ActionForward forward = null;

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url_Command = requestURI.substring(contextPath.length());

		if (url_Command.equals("/MainCampingview.do")) { // Camping 검색 : main > list
			// UI처리
			forward = new ActionForward();
			forward.setPath("/WEB-INF/views/searchresult.jsp");
		} else if (url_Command.equals("/GoMain.do")) {
			forward = new ActionForward();
			forward.setPath("/index.jsp");
		}else if (url_Command.equals("/Notice.do")) {
			forward = new ActionForward();
			forward.setPath("/WEB-INF/views/qna303.jsp");
		}else if (url_Command.equals("/Qna.do")) {
			forward = new ActionForward();
			forward.setPath("/WEB-INF/views/qna401.jsp");
		} else if (url_Command.equals("/CampinglistCrossCK.do")) { // 캠핑 API list cross체크 처리
			// UI처리 + 로직처리
			action = new ListCrossService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("캠핑API 서비스 갔다왔어요. 지금은 CONTROLLER ");
		} else if (url_Command.equals("/CampingDetailCrossCK.do")) { // 캠핑 API detail cross체크 처리
			// UI처리 + 로직처리
			action = new DetailCrossService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("캠핑API 서비스 갔다왔어요. 지금은 CONTROLLER ");
		} else if (url_Command.equals("/SignUp.do")) { // 양찬식 함수에 else if문 추가
			forward = new ActionForward();
			forward.setPath("/WEB-INF/views/signUp.jsp");
		} else if (url_Command.equals("/SingUpOk.do")) {
			action = new SignUpService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				e.printStackTrace();
			}

		} else if (url_Command.equals("/LogIn.do")) {
			forward = new ActionForward();
			forward.setPath("/WEB-INF/views/logIn.jsp");
		} else if (url_Command.equals("/LoginOk.do")) {
			action = new LoginService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/LogOut.do")) {
			action = new LogoutService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/SignUpCom.do")) {
			forward = new ActionForward();
			forward.setPath("/WEB-INF/views/signUpOk.jsp");
		} else if (url_Command.equals("/SingUpOk.do")) { // else if문 추가
			action = new SignUpService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (url_Command.equals("/IdCheck.do")) {
			action = new IdCheckService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (url_Command.equals("/MemberList.do")) {
			forward = new ActionForward();
			forward.setPath("/WEB-INF/views/memberList.jsp");
		} else if (url_Command.equals("/GetMemberList.do")) {
			action = new memberListService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (url_Command.equals("/MemberDetail.do")) {
			action = new memberDetailService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (url_Command.equals("/MemberEdit.do")) {
			action = new memberEditService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (url_Command.equals("/MemberEditOk.do")) {
			action = new memberEditOkService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (url_Command.equals("/MemberDelete.do")) {
			action = new memberDeleteService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (url_Command.equals("/idsearch.do")) {
			action = new idService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (url_Command.equals("/namesearch.do")) {
			action = new nameService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (url_Command.equals("/ZzimListSearch.do")) { // 캠핑 API detail cross체크 처리
			// UI처리 + 로직처리
			action = new ZzimListService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("찜리스트 검색중");
		} else if (url_Command.equals("/MyZzimSearch.do")) { // 캠핑 API detail cross체크 처리
			// UI처리 + 로직처리
			action = new MyZzimSearchService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("찜리스트 검색중");
		} else if (url_Command.equals("/ZzimListInsert.do")) { // 캠핑 API detail cross체크 처리
			// UI처리 + 로직처리
			action = new ZzimListInsertService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("찜리스트 추가중");
		} else if (url_Command.equals("/ZzimListDelete.do")) { // 캠핑 API detail cross체크 처리
			// UI처리 + 로직처리
			action = new ZzimListDeleteService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("찜리스트 삭제중");
		} else if (url_Command.equals("/ReviewAdd.do")) { // @function : 후기글쓰기 @Date : 2019-11-24 @Author : 배인영
			// UI처리 + 로직처리
			System.out.println("여기오나요?");
			action = new ReviewWriteService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (url_Command.equals("/ReviewList.do")) { // @function : 후기리스트 @Date : 2019-11-24 @Author : 배인영
			// UI처리 + 로직처리
			action = new ReviewListService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (url_Command.equals("/ShowReviewWrite.do")) { // @function : 후기 글쓰기 페이지 view단 @Date : 2019-11-24
																// @Author : 배인영
			// UI처리
			forward = new ActionForward();
			forward.setPath("/WEB-INF/views/review_write.jsp");
		} else if (url_Command.equals("/ShowrReviewDetail.do")) {// @function : 후기 글쓰기 페이지 view단 @Date : 2019-11-24
																	// @Author : 배인영
			// UI처리 + 로직처리
			action = new ReviewListService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (url_Command.equals("/MyPage.do")) {
			// UI처리
			forward = new ActionForward();
			forward.setPath("/WEB-INF/views/mypage.jsp");
		} else if (url_Command.equals("/MyInfoEdit.do")) { // 캠핑 API detail cross체크 처리
			// UI처리 + 로직처리
			action = new MyInfoEditService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("멤버정보 수정중");
		} else if (url_Command.equals("/MyInfoEditOk.do")) { // 캠핑 API detail cross체크 처리
			// UI처리 + 로직처리
			action = new MyInfoEditOkService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("멤버정보 수정중");
		} else if (url_Command.equals("/ReviewAdd.do")) { // @function : 후기글쓰기 @Date : 2019-11-24 @Author : 배인영
			// UI처리 + 로직처리
			System.out.println("여기오나요?");
			action = new ReviewWriteService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/ReviewList.do")) { // @function : 후기리스트 @Date : 2019-11-24 @Author : 배인영
			// UI처리 + 로직처리
			action = new ReviewListService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/ShowReviewWrite.do")) { // @function : 후기 글쓰기 페이지 view단 @Date : 2019-11-24
																// @Author : 배인영
			// UI처리
			forward = new ActionForward();
			forward.setPath("/WEB-INF/views/review_write.jsp");
		} else if (url_Command.equals("/ShowReviewDetail.do")) {// @function : 후기 글쓰기 페이지 view단 @Date : 2019-11-24
																// @Author : 배인영
			// UI처리 + 로직처리
			action = new ReviewDetailService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/ReviewReplyAdd.do")) {// @function : 후기 댓글 추가 @Date : 2019-11-26 @Author : 배인영
			// UI처리 + 로직처리
			action = new ReplyWriteService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/ShowReviewReply.do")) {// @function : 후기 댓글 보여주세요 @Date : 2019-11-26 @Author :
																// 배인영
			// UI처리 + 로직처리
			action = new ReplyListService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/DeleteReviewReply.do")) { // @function : 후기 댓글 삭제 @Date : 2019-11-27 @Author :
																	// 배인영
			System.out.println("DeleteReviewReply컨트롤러오니?");
			action = new ReplyDeleteService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/ReviewEdit.do")) { // @function : 후기 수정(보여주는부분select) @Date : 2019-11-27 @Author
															// : 배인영
			action = new ReviewEditService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/ReviewEditOk.do")) { // @function : 후기 수정(처리하는부분update) @Date : 2019-11-27
																// @Author : 배인영
			action = new ReviewEditOkService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/ReviewDelete.do")) { // @function : 후기 삭제 @Date : 2019-11-27 @Author : 배인영
			action = new ReviewDeleteService();
			try {
				forward = action.execute(request, response);
				System.out.println("여기오니? ");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/RecentReview.do")) { // @function : 최근후기 5개 (메인에뿌릴것) @Date : 2019-11-27 @Author
																// : 배인영
			System.out.println("여기오니?최근후기");
			action = new RecentReviewService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		} else if (url_Command.equals("/MyPageReview.do")) {// @function : 최근후기 5개 (메인에뿌릴것) @Date : 2019-11-27 @Author :
															// 배인영
			action = new MyPageReviewService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (url_Command.equals("/TradeList.do")) { // 수연
			// 중고 거래 리스트
			action = new TradeListService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("TradeList 서비스 다녀왔어요 ");

		} else if (url_Command.equals("/TradeWrite.do")) { // 수연
			// 중고 거래 글쓰기
			action = new TradeWriteService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("TradeWrite 서비스 다녀왔어요 ");

		} else if (url_Command.equals("/TradeDetail.do")) { // 수연
			// 중고 거래 상세보기
			action = new TradeDetailService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("TradeDetail 서비스 다녀왔어요");

		} else if (url_Command.equals("/TradeEdit.do")) { // 수연
			// 중고 거래 수정하기
			action = new TradeEditService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("TradeEdit 서비스 다녀왔어요");

		} else if (url_Command.equals("/TradeEditOk.do")) { // 수연
			// 중고 거래 수정 오케이
			action = new TradeEditOkService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("TradeEditOk 서비스 다녀왔어요");

		} else if (url_Command.equals("/TradeDelete.do")) { // 수연
			// 중고 거래 삭제하기
			action = new TradeDeleteService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("TradeDelete 서비스 다녀왔어요");

		} else if (url_Command.equals("/TradeReplyWrite.do")) {// 수연
			// 중고 거래 리뷰 글쓰기
			action = new TradeReplyWriteService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (url_Command.equals("/TradeReplyList.do")) {// 수연
			// 중고 거래 리뷰 리스트
			action = new TradeReplyListService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (url_Command.equals("/TradeReplyDelete.do")) {// 수연
			// 중고거래 리뷰 삭제
			action = new TradeReplyDeleteService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (url_Command.equals("/TradeWriteView.do")) {
			forward = new ActionForward();
			forward.setPath("/WEB-INF/views/tradeWrite.jsp");
		} else if (url_Command.equals("/MyTrade.do")) { // 수연
			// UI처리

			forward = new ActionForward();
			forward.setPath("/mypage.jsp");

		} else if (url_Command.equals("/MyTradePage.do")) {// 수연
			action = new MyTradePageService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (url_Command.equals("/boardWrite.do")) { // 게시판 글쓰기
			action = new BoardWriteService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("보드라이트서비스 갔다 옴. 지금은 CONTROLLER ");
		} else if (url_Command.equals("/boardList.do")) { // 게시판 글쓴 뒤 다시 원래 그 게시판 가기
			// UI처리 + 로직처리
			action = new BoardListService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("보드리스트 서비스 갔다왔어요. 지금은 CONTROLLER ");
		} else if (url_Command.equals("/boardDetail.do")) { // 게시판 글쓴 뒤 다시 원래 그 게시판 가기
			// UI처리 + 로직처리
			action = new BoardDetailService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("보드 디테일 서비스 갔다왔어요. 지금은 CONTROLLER ");
		} else if (url_Command.equals("/boardEdit.do")) { // 게시판 글쓴 뒤 다시 원래 그 게시판 가기
			// UI처리 + 로직처리
			action = new BoardEditService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("보드 에딧 서비스 갔다왔어요. 지금은 CONTROLLER ");
		} else if (url_Command.equals("/boardDelete.do")) { // 게시판 글쓴 뒤 다시 원래 그 게시판 가기
			// UI처리 + 로직처리
			action = new BoardDeleteService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("보드 디테일 서비스 갔다왔어요. 지금은 CONTROLLER ");
		} else if (url_Command.equals("/gotoWrite.do")) { // 게시판 글쓴 뒤 다시 원래 그 게시판 가기
			action = new GotoWriteService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("글쓰러 갈라고 컨트롤러 들림 서비스 갔다왔어요. 지금은 CONTROLLER ");
		}else if(url_Command.equals("/ReviewSearch.do")) { // 후기게시판 제목으로 검색  - 인영
	    	System.out.println("여기는 서치 컨트롤러");
	           action = new ReviewSearchService();
	           try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		

		if (forward != null) {

			RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
			dis.forward(request, response);

		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}