package project.apt.foryou;

public class PartnerVO {
	
	private String memId;
	private String parName;
	private String parRegnum;
	private String parSex;
	private String parRegdate;
	
	PartnerVO(){}
	
	
	PartnerVO(String memId, String parName, String parSex, String parRegdate){
		this.memId = memId;
		this.parName = parName;
		this.parSex = parSex;
		this.parRegdate = parRegdate;
	}
	
	PartnerVO(String memId, String parName, String parRegnum, String parSex, String parRegdate){
		this.memId = memId;
		this.parName = parName;
		this.parRegnum = parRegnum;
		this.parSex = parSex;
		this.parRegdate = parRegdate;
	}
	
	PartnerVO(String memId, String parRegdate){
		this.memId = memId;
		this.parRegdate = parRegdate;
	}
	
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getParName() {
		return parName;
	}
	public void setParName(String parName) {
		this.parName = parName;
	}
	public String getParRegnum() {
		return parRegnum;
	}
	public void setParRegnum(String parRegnum) {
		this.parRegnum = parRegnum;
	}
	public String getParSex() {
		return parSex;
	}
	public void setParSex(String parSex) {
		this.parSex = parSex;
	}
	public String getParRegdate() {
		return parRegdate;
	}
	public void setParRegdate(String parRegdate) {
		this.parRegdate = parRegdate;
	}

	@Override
	public String toString() {
		return "[회원ID] " + memId + "  [배우자 이름] " + parName + "  [주소] " + parRegnum + "  [성별] " + parSex + "  [혼인신고일자] " + parRegdate;
	}
	
	
}
