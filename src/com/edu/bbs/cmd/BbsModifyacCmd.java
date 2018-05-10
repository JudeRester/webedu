package com.edu.bbs.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dao.BbsDAOimpl;
import com.edu.bbs.dto.BbsDTO;

public class BbsModifyacCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BbsDTO bbsdto = new BbsDTO();
		
		bbsdto.setbTitle(request.getParameter("bTitle"));
		bbsdto.setbName(request.getParameter("bName"));
		bbsdto.setbContent(request.getParameter("bContent"));
		bbsdto.setbNum(Integer.parseInt(request.getParameter("bNum")));
		BbsDAO bdao = BbsDAOimpl.getInstance();
		request.setAttribute("bNum",bdao.modify_ac(bbsdto));
	}
}
