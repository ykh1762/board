package kr.or.ddit.post.model;

public class PostVo {
	private String post_no;
	private String parent_post_no;
	private String userid;
	private String title;
	private String content;
	private String reg_dt;
	private String delete_flag;
	private String board_no;
	private String gn;
	private String editTitle;
	private String post_level;
	
	public String getPost_no() {
		return post_no;
	}
	public void setPost_no(String post_no) {
		this.post_no = post_no;
	}
	public String getParent_post_no() {
		return parent_post_no;
	}
	public void setParent_post_no(String parent_post_no) {
		this.parent_post_no = parent_post_no;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}
	public String getDelete_flag() {
		return delete_flag;
	}
	public void setDelete_flag(String delete_flag) {
		this.delete_flag = delete_flag;
	}
	public String getBoard_no() {
		return board_no;
	}
	public void setBoard_no(String board_no) {
		this.board_no = board_no;
	}
	public String getGn() {
		return gn;
	}
	public void setGn(String gn) {
		this.gn = gn;
	}
	public String getEditTitle() {
		return editTitle;
	}
	public void setEditTitle(String editTitle) {
		this.editTitle = editTitle;
	}
	public String getPost_level() {
		return post_level;
	}
	public void setPost_level(String post_level) {
		this.post_level = post_level;
	}
	
	@Override
	public String toString() {
		return "PostVo [post_no=" + post_no + ", parent_post_no="
				+ parent_post_no + ", userid=" + userid + ", title=" + title
				+ ", content=" + content + ", reg_dt=" + reg_dt
				+ ", delete_flag=" + delete_flag + ", board_no=" + board_no
				+ ", gn=" + gn + ", editTitle=" + editTitle + ", post_level="
				+ post_level + "]";
	}
	

	

}
