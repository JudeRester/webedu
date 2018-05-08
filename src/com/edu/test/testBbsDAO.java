package com.edu.test;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dto.BbsDTO;

class testBbsDAO {

	@Test
	void test() {
		BbsDAO bdao = BbsDAO.getInstance();
		ArrayList<BbsDTO> alist = bdao.list(1,10);
		for(BbsDTO bdto : alist) {
			System.out.println(bdto);
		}
	}
}