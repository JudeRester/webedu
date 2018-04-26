package com.edu.bbs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.cmd.BCommand;
/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
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
				
				break;
		//글쓰기 등록
			case "/bbs/write.do" :
				command = new BbsWriteCmd();
				command.execute(request, response);
				viewPage = "list.do";
				break;
			case "bbs/list.do" :
				command = new BbsListCmd();
				command.execute(request, response);
				viewPage = "/bbs/list.jsp";
				break;
			default :
				break;
		}

		RequestDispatcher dispat = request.getRequestDispatcher(viewPage);
		dispat.forward(request, response);
	}
}
