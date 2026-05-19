
public class PaggingVO {
	// 전체 게시글 개수
	private int count;
	// 현재 페이지 번호
	private int currentPage;
	// 한 페이지당 출력할 게시글 개수
	private final int PAGE_CONTENT_COUNT = 30;
	// 게시판 하단에 나타낼 페이지 번호 개수
	private final int PAGE_GROUP_COUNT = 5;

	public PaggingVO(int count, int currentPage) {
		this.count = count;
		this.currentPage = currentPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	// 전체 페이지 개수 : 전체 게시글 개수 / 한페이지당 출력할 게시글 수 + (나머지가 0 아니면 1)
	public int getTotalPage() {
		return count / PAGE_CONTENT_COUNT + (count % PAGE_CONTENT_COUNT != 0 ? 1 : 0);
	}

	// 전체 페이지 그룹 개수 : 전체 페이지 개수 / 게시판 하단에 나타낼 페이지 번호 개수 + (나머지가 0 아니면 1)
	public int getTotalPageGroup() {
		return getTotalPage() / PAGE_GROUP_COUNT + (getTotalPage() % PAGE_GROUP_COUNT != 0 ? 1 : 0);
	}

	// 현재 페이지의 그룹번호
	public int getCurrentPageGroupNo() {
		return currentPage / PAGE_GROUP_COUNT + (currentPage % PAGE_GROUP_COUNT != 0 ? 1 : 0);
	}

	// 현재 페이지 그룹의 시작 페이지 번호
	public int getStartPageOfPageGroup() {
		return (getCurrentPageGroupNo()-1) * PAGE_GROUP_COUNT + 1;
	}

	// 현재 페이지 그룹의 마지막 페이지 번호
	public int getEndPageOfPageGroup() {
		return Math.min(getTotalPage(), getStartPageOfPageGroup()*PAGE_GROUP_COUNT);
	}

}





