package com.edu.bbs;

public class PageCriteria {
	private int totalrec;		//총 게시글 수
	private int lastpage; 		//마지막 페이지
	private int currpage; 		//현재 페이지
	private int pagenum; 		//페이지번호
	private int showamount=10;  //표시할 게시글 수
	private int startpage;		//단위시작페이지
	private int endpage;		//단위마지막페이지
	private boolean pre;		//이전페이지 여부
	
	private boolean next;		//다음 페이지 여부
	
	
	public PageCriteria(int currpage, int totalrec) {
		this.totalrec = totalrec;
		this.currpage = currpage;
		init();
	}
	
	private void init() {
		if(totalrec%showamount > 0) {
			lastpage = totalrec / showamount +1;
		}else {
			lastpage = totalrec / showamount;
		}
		startpage = (currpage-1)/showamount*showamount+1;
		endpage = startpage + showamount -1;
		if(currpage>lastpage) {
			currpage=lastpage;
		}
		if(endpage>lastpage) {
			endpage = lastpage;
		}
		pre = startpage ==1 ? false : true;
		next = endpage == lastpage ? false : true;
	}
	//페이지 첫 글
	public int getStartrec() {
		return (currpage-1)*showamount+1;
	}	
	//페이지 마지막 글
	public int getLastrec() {
		return getStartrec()+showamount-1;
	}
	public boolean isPre() {
		return pre;
	}

	public void setPre(boolean pre) {
		this.pre = pre;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}
	public int getStartpage() {
		return startpage;
	}

	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}

	public int getEndpage() {
		return endpage;
	}

	public void setEndpage(int endpage) {
		this.endpage = endpage;
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
}
