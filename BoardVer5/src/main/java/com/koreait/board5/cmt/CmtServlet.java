package com.koreait.board5.cmt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board5.MyUtils;

@WebServlet("/board/cmt")
public class CmtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		int icmt = MyUtils.getParamInt("icmt", request);
		int iuser = MyUtils.getLoginUserPk(request);
		
		CmtVO param = new CmtVO();
		param.setIcmt(icmt);
		param.setIuser(iuser);
		
		CmtDAO.delCmt(param);
		
		response.sendRedirect("detail?iboard=" + iboard);
	}
	
	//insert, update 같이 사용할꺼임
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int icmt = MyUtils.getParamInt("icmt", request);
		int iboard = MyUtils.getParamInt("iboard", request);
		String cmt = request.getParameter("cmt");		
		int iuser = MyUtils.getLoginUserPk(request);
		
		CmtVO param = new CmtVO();		
		param.setCmt(cmt);
		param.setIuser(iuser);
		
		if(icmt != 0) { //수정
			param.setIcmt(icmt);
			CmtDAO.updCmt(param);
		} else { //등록
			param.setIboard(iboard);
			CmtDAO.insCmt(param);
		}		
		
		response.sendRedirect("detail?iboard="+iboard);
	}
}






