package project.apt.foryou;

public class CompanyVO {
	
	
	private String ComName;
	private int AptId;
	private String AptName;
	private String ComManager;
	private String ComMobile;
	private String AptSize;
	private int AptPrice;
	private String AptIndate;
	
	
	public CompanyVO(int AptId, String ComName, String AptName) {
		this.AptId = AptId;
		this.ComName = ComName;
		this.AptName = AptName;
	}
	

	public String getComName() {
		return ComName;
	}
	public void setComName(String comName) {
		this.ComName = comName;
	}
	public int getAptId() {
		return AptId;
	}
	public void setAptId(int aptId) {
		this.AptId = aptId;
	}
	public String getAptName() {
		return AptName;
	}
	public void setAptName(String aptName) {
		this.AptName = aptName;
	}
	public String getComManager() {
		return ComManager;
	}
	public void setComManager(String comManager) {
		this.ComManager = comManager;
	}
	public String getComMobile() {
		return ComMobile;
	}
	public void setComMobile(String comMobile) {
		this.ComMobile = comMobile;
	}
	public String getAptSize() {
		return AptSize;
	}
	public void setAptSize(String aptSize) {
		this.AptSize = aptSize;
	}
	public int getAptPrice() {
		return AptPrice;
	}
	public void setAptPrice(int aptPrice) {
		this.AptPrice = aptPrice;
	}
	public String getAptIndate() {
		return AptIndate;
	}
	public void setAptIndate(String aptIndate) {
		this.AptIndate = aptIndate;
	}


	
}
