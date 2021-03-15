package project.apt.foryou;

public class ApartmentVO {

	public int AptId;
	private String AptName;
	private String AptAddr;
	private int AptCount;
	private String AptSize;
	private int AptPrice;
	private String AptIndate;
	private String ComName;
	
	
	ApartmentVO(){
		
	}
	
    ApartmentVO(int aptId, String aptName, String aptAddr, int aptCount, String aptSize, int aptPrice,
			String aptIndate, String comName) {
    	
		this.AptId = aptId;
		this.AptName = aptName;
		this.AptAddr = aptAddr;
		this.AptCount = aptCount;
		this.AptSize = aptSize;
		this.AptPrice = aptPrice;
		this.AptIndate = aptIndate;
		this.ComName = comName;
	}



	@Override
	public String toString() {
		return "[아파트ID] " + AptId + "[아파트명] " + AptName + "[아파트 주소] " + AptAddr + "[분양 호수] "
				+ AptCount + "[평수] " + AptSize + "[분양가] " + AptPrice + "[입주일] " + AptIndate
				+ "[건설사] " + ComName;
	}
	
	
	public ApartmentVO(int AptId) {}
	
	public ApartmentVO(String AptName, String AptAddr, int AptCount, String AptSize, int AptPrice,
			String AptIndate, String ComName) {
		this.AptName = AptName;
		this.AptAddr = AptAddr;
		this.AptCount = AptCount;
		this.AptSize = AptSize;
		this.AptPrice = AptPrice;
		this.AptIndate = AptIndate;
		this.ComName = ComName;
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

	public String getAptAddr() {
		return AptAddr;
	}

	public void setAptAddr(String aptAddr) {
		this.AptAddr = aptAddr;
	}

	public int getAptCount() {
		return AptCount;
	}

	public void setAptCount(int aptCount) {
		this.AptCount = aptCount;
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

	public String getComName() {
		return ComName;
	}

	public void setComName(String comName) {
		this.ComName = comName;
	}

}
