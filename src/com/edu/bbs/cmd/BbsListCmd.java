package com.edu.bbs.cmd;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.PageCriteria;
import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dao.BbsDAOimpl;
import com.edu.bbs.dto.BbsDTO;

public class BbsListCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int currpage=0;
		int totalrec = 0;
		String col = request.getParameter("col");
		String keyword = request.getParameter("keyword");
		PageCriteria pc;
		ArrayList<BbsDTO> alist;
		BbsDAO bbsdao = BbsDAOimpl.getInstance();
		if(request.getParameter("currpage")==null || request.getParameter("currpage")==" ") {
			currpage=1;
		}else {
			currpage = Integer.parseInt(request.getParameter("currpage"));
		}
		if(col == null || keyword.trim().equals(""))  {
			totalrec = bbsdao.totalrec();
			pc= new PageCriteria(currpage, totalrec);
			alist = bbsdao.list(pc.getStartrec(),pc.getLastrec());
			request.setAttribute("list", alist);
			request.setAttribute("pc", pc);
		}else {
			totalrec = bbsdao.totalrec(col, "%"+keyword+"%");
			pc = new PageCriteria(currpage, totalrec);
			alist = bbsdao.list(pc.getStartrec(), pc.getLastrec(), "%"+keyword+"%", col);
			request.setAttribute("list", alist);
			request.setAttribute("pc", pc);
			request.setAttribute("col", col);
			request.setAttribute("keyword", keyword);
		}
	}
}
