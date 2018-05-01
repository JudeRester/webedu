package com.edu.bbs.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.BbsDAO;

public class BbsDeleteCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		BbsDAO bdao = BbsDAO.getInstance();
		bdao.delete(bNum);
	}
}
