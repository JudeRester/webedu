package com.edu.bbs.dao;

import java.util.ArrayList;

import com.edu.bbs.dto.BbsDTO;

public interface BbsDAO {

	int write(BbsDTO bbsdto);

	ArrayList<BbsDTO> list(int a, int b);

	BbsDTO view(int bNum);

	BbsDTO modify(int num);

	int modify_ac(BbsDTO bdto);

	int delete(int bNum);

	BbsDTO preinfo(int bNum);

	int reply(BbsDTO bbsdto);

	int totalrec();

	ArrayList<BbsDTO> list(int a, int b, String keyword, String col);

	int totalrec(String col, String keyword);

}