package com.edu.bbs.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dao.BbsDAOimpl;
import com.edu.bbs.dto.BbsDTO;

public class BbsReplyacCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BbsDTO bdto = new BbsDTO();
		BbsDAO bdao = BbsDAOimpl.getInstance();
		bdto.setbTitle(request.getParameter("bTitle"));
		bdto.setbName(request.getParameter("bName"));
		bdto.setbContent(request.getParameter("bContent"));
		bdto.setbGroup(Integer.parseInt(request.getParameter("bGroup")));
		bdto.setbIndent(Integer.parseInt(request.getParameter("bIndent"))+1);
		request.setAttribute("bNum", bdao.reply(bdto));
	}

}
