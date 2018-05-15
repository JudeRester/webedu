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
		if(request.getParameter("currpage")==null || request.getParameter("currpage")=="") {
			currpage=1;
		}else {
			currpage = Integer.parseInt(request.getParameter("currpage"));
		}
		BbsDAO bbsdao = BbsDAOimpl.getInstance();
		int totalrec = bbsdao.totalrec();
		PageCriteria pc = new PageCriteria(currpage, totalrec);
		ArrayList<BbsDTO> alist = bbsdao.list(pc.getStartrec(),pc.getLastrec());
		request.setAttribute("list", alist);
		request.setAttribute("pc", pc);
	}
}
