package dto;

/**
 * 댓글 정보를 담는 데이터 전달 객체(DTO)입니다.
 * DB의 board_comment 테이블의 데이터와 대응됩니다.
 */
public class BoardCommentDTO {
	private int cno;          // 댓글 고유 번호
	private String content;   // 댓글 내용
	private String cdate;     // 작성일
	private int mno;          // 작성자 회원 번호
	private int bno;          // 게시글 번호
	private int clike;        // 좋아요 수
	private int chate;        // 싫어요 수
	private String nickName;  // 작성자 닉네임 (조회용)

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public BoardCommentDTO() {
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCdate() {
		return cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public int getClike() {
		return clike;
	}

	public void setClike(int clike) {
		this.clike = clike;
	}

	public int getChate() {
		return chate;
	}

	public void setChate(int chate) {
		this.chate = chate;
	}

	@Override
	public String toString() {
		return "BoardCommentDTO [cno=" + cno + ", content=" + content + ", cdate=" + cdate + ", mno=" + mno + ", bno="
				+ bno + ", clike=" + clike + ", chate=" + chate + ", nickName=" + nickName + "]";
	}
}
