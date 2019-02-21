package kr.or.ddit.attach_file.model;

public class Attach_fileVo {
	private String file_no;
	private String post_no;
	private String filename;
	private String realfilename;
	private String insertflag;
	
	@Override
	public String toString() {
		return "Attach_fileVo [file_no=" + file_no + ", post_no=" + post_no
				+ ", filename=" + filename + ", realfilename=" + realfilename
				+ ", insertflag=" + insertflag + "]";
	}

	public String getInsertflag() {
		return insertflag;
	}

	public void setInsertflag(String insertflag) {
		this.insertflag = insertflag;
	}

	public String getFile_no() {
		return file_no;
	}

	public void setFile_no(String file_no) {
		this.file_no = file_no;
	}

	public String getPost_no() {
		return post_no;
	}

	public void setPost_no(String post_no) {
		this.post_no = post_no;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getRealfilename() {
		return realfilename;
	}

	public void setRealfilename(String realfilename) {
		this.realfilename = realfilename;
	}
	
}
