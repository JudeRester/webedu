package com.edu.bbs.cmd;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dto.BbsDTO;

public class BbsBviewCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int a = Integer.parseInt(request.getParameter("bNum"));
		BbsDAO bbsdao = BbsDAO.getInstance();
		BbsDTO bdto = bbsdao.view(a);
		request.setAttribute("bdto", bdto);
	}

}
