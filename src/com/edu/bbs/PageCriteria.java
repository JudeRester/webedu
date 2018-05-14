package com.edu.bbs;

public class PageCriteria {
	private int totalrec;	//총 게시글 수
	private int lastpage; 	//마지막 페이지
	private int currpage; 	//현재 페이지
	private int pagenum; 	//페이지번호
	private int showamount=10; //표시할 게시글 수
	
	public PageCriteria(int totalrec) {
		this.totalrec = totalrec;
		init();
	}
	
	private void init() {
		if(totalrec%showamount > 0) {
			lastpage = totalrec / showamount +1;
		}else {
			lastpage = totalrec / showamount;
		}
		
	}
	
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public int getShowamount() {
		return showamount;
	}
	public void setShowamount(int showamount) {
		this.showamount = showamount;
	}
	public int getTotalrec() {
		return totalrec;
	}
	public void setTotalrec(int totalrec) {
		this.totalrec = totalrec;
	}
	public int getLastpage() {
		return lastpage;
	}
	public void setLastpage(int lsatpage) {
		this.lastpage = lsatpage;
	}
	public int getCurrpage() {
		return currpage;
	}
	public void setCurrpage(int currpage) {
		this.currpage = currpage;
	}
	//페이지 첫 글
	public int getStartrec() {
		return (pagenum-1)*showamount;
	}
	//페이지 마지막 글
	public int getLastrec() {
		return getStartrec()+showamount-1;
	}
	
	
}
