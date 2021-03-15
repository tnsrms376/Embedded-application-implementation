package project.apt.foryou;

public class MemberVO {
	private String memId;
	private String memPw;
	private String memName;
	private String memRegnum;
	private String memAddress;
	private String memMobile;
	
	
	MemberVO(){}
	
	MemberVO(String memId, String memPw, String memName, String memRegnum, String memAddress, String memMobile){
		this.memId = memId;
		this.memPw = memPw;
		this.memName = memName;
		this.memRegnum = memRegnum;
		this.memAddress = memAddress;
		this.memMobile = memMobile;
	}
	
	MemberVO(String memId, String memPw, String memName, String memAddress, String memMobile){
		this.memId = memId;
		this.memPw = memPw;
		this.memName = memName;
		this.memAddress = memAddress;
		this.memMobile = memMobile;
	}
	
	MemberVO(String memId, String memName, String memAddress, String memMobile){
		this.memId = memId;
		this.memName = memName;
		this.memAddress = memAddress;
		this.memMobile = memMobile;
	}
	
	public MemberVO(String id, String pw) {
		this.memId = id;
		this.memPw = pw;
	}
	
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPw() {
		return memPw;
	}
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
	
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemRegnum() {
		return memRegnum;
	}
	public void setMemRegnum(String memRegnum) {
		this.memRegnum = memRegnum;
	}
	public String getMemAddress() {
		return memAddress;
	}
	public void setMemAddress(String memAddress) {
		this.memAddress = memAddress;
	}
	public String getMemMobile() {
		return memMobile;
	}
	public void setMemMobile(String memMobile) {
		this.memMobile = memMobile;
	}
	
	public String toString() {
		return "[회원ID] " + memId + "  [이름] " + memName + "[주소] " + memAddress + "[번호] " + memMobile;
	}
	
}
