package kr.or.ddit.reply.model;

public class ReplyVo {
	private String reply_no;
	private String post_no;
	private String userid;
	private String content;
	private String reg_dt;
	private String delete_flag;
	
	public String getReply_no() {
		return reply_no;
	}
	public void setReply_no(String reply_no) {
		this.reply_no = reply_no;
	}
	public String getPost_no() {
		return post_no;
	}
	public void setPost_no(String post_no) {
		this.post_no = post_no;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	
	@Override
	public String toString() {
		return "ReplyVo [reply_no=" + reply_no + ", post_no=" + post_no
				+ ", userid=" + userid + ", content=" + content + ", reg_dt="
				+ reg_dt + ", delete_flag=" + delete_flag + "]";
	}
	
}
