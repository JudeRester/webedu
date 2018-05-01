package com.edu.bbs.dto;

import java.sql.Date;

public class BbsDTO {

	private int bNum; //게시글 번호
	private String bTitle; //게시글 제목
	private String bId; //작성자 아이디
	private String bName; //작성자 이름
	private String bContent; //내용
	private String bIndent; //답글 들여쓰기
	private Date bCDate; //작성일
	private Date bUDate; //수정일
	private int bHit; //조회수
	private int bGroup; //답글 그룹
	private int bStep; //답글 단계
	private int pPage;
	private int nPage;
	
	public int getnPage() {
		return nPage;
	}

	public void setnPage(int nPage) {
		this.nPage = nPage;
	}

	public int getpPage() {
		return pPage;
	}

	public void setpPage(int pPage) {
		this.pPage = pPage;
	}

	public BbsDTO() {}
	
	public BbsDTO(int bNum, String bTitle, String bId, String bName, String bContent, String bIndent, Date bCDate,
			Date bUDate, int bHit, int bGroup, int bStep) {
		super();
		this.bNum = bNum;
		this.bTitle = bTitle;
		this.bId = bId;
		this.bName = bName;
		this.bContent = bContent;
		this.bIndent = bIndent;
		this.bCDate = bCDate;
		this.bUDate = bUDate;
		this.bHit = bHit;
		this.bGroup = bGroup;
		this.bStep = bStep;
	}
	
	public int getbNum() {
		return bNum;
	}
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbId() {
		return bId;
	}
	public void setbId(String bId) {
		this.bId = bId;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public String getbIndent() {
		return bIndent;
	}
	public void setbIndent(String bIndent) {
		this.bIndent = bIndent;
	}
	public Date getbCDate() {
		return bCDate;
	}
	public void setbCDate(Date bCDate) {
		this.bCDate = bCDate;
	}
	public Date getbUDate() {
		return bUDate;
	}
	public void setbUDate(Date bUDate) {
		this.bUDate = bUDate;
	}
	public int getbHit() {
		return bHit;
	}
	public void setbHit(int bHit) {
		this.bHit = bHit;
	}
	public int getbGroup() {
		return bGroup;
	}
	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}
	public int getbStep() {
		return bStep;
	}
	public void setbStep(int bStep) {
		this.bStep = bStep;
	}

	
}
