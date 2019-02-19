package kr.or.ddit.board.model;

public class BoardVo {
	private String board_no; // 게시판번호
	private String board_nm; // 게시판이름
	private String use_flag; // 사용여부
	
	public String getBoard_no() {
		return board_no;
	}
	public void setBoard_no(String board_no) {
		this.board_no = board_no;
	}
	public String getBoard_nm() {
		return board_nm;
	}
	public void setBoard_nm(String board_nm) {
		this.board_nm = board_nm;
	}
	public String getUse_flag() {
		return use_flag;
	}
	public void setUse_flag(String use_flag) {
		this.use_flag = use_flag;
	}
	
	@Override
	public String toString() {
		return "BoardVo [board_no=" + board_no + ", board_nm=" + board_nm
				+ ", use_flag=" + use_flag + "]";
	}
	
	
}
