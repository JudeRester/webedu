package com.edu.bbs.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dto.BbsDTO;

public class BbsModifyCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BbsDAO bdao = BbsDAO.getInstance();
		BbsDTO bdto = bdao.modify(Integer.parseInt(request.getParameter("bNum")));
		request.setAttribute("bdto", bdto);
	}
}
