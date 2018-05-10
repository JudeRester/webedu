package com.edu.bbs.cmd;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dao.BbsDAOimpl;
import com.edu.bbs.dto.BbsDTO;

public class BbsListCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BbsDAO bbsdao = BbsDAOimpl.getInstance();
		ArrayList<BbsDTO> alist = bbsdao.list(1,10);
		request.setAttribute("list", alist);
	}
}
