package com.edu.bbs.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dao.BbsDAOimpl;

public class BbsDeleteCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		BbsDAO bdao = BbsDAOimpl.getInstance();
		bdao.delete(bNum);
	}
}
