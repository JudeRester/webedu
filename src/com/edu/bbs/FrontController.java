package com.edu.bbs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.cmd.BCommand;
import com.edu.bbs.cmd.BbsListCmd;
import com.edu.bbs.cmd.BbsWriteCmd;
/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet호출");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost호출");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo 호출!");
		request.setCharacterEncoding("UTF-8");
		BCommand command = null;
		String viewPage = null; //view 이동경로
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String cmd = uri.substring(conPath.length());
		
		System.out.println(uri);
		System.out.println(conPath);
		System.out.println(cmd);

		switch(cmd){
		//글쓰기 이름
			case "/bbs/write_view.do" :
				viewPage = "/bbs/write_form.jsp";
				System.out.println("1");
				break;
		//글쓰기 등록
			case "/bbs/write.do" :
				command = new BbsWriteCmd();
				command.execute(request, response);
				viewPage = "/bbs/list.do";
				System.out.println("2");
				break;
			case "/bbs/list.do" :
				command = new BbsListCmd();
				command.execute(request, response);
				viewPage = "/bbs/list.jsp";
				System.out.println("3");
				break;
			default :
				break;
		}
		System.out.println("4");
		RequestDispatcher dispat = request.getRequestDispatcher(viewPage);
		dispat.forward(request, response);
	}
	
}
