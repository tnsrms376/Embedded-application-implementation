package project.apt.foryou;

public class SubscriptionVO {
	private String subNum;
	private String memId;
	private String subDate;
	private int subDeposit;
	private int subCount;

	SubscriptionVO() {
	}

	SubscriptionVO(String memId, int subDeposit, int subCount) {
		this.memId = memId;
		this.subDeposit = subDeposit;
		this.subCount = subCount;
	}

	SubscriptionVO(String subNum, String memId, String subDate, int subDeposit, int subCount) {
		this.subNum = subNum;
		this.memId = memId;
		this.subDate = subDate;
		this.subDeposit = subDeposit;
		this.subCount = subCount;
	}

	// ***수민추가 201227
	@Override
	public String toString() {
		return "No. : " + subNum + "\t" + "ID : " + memId + "\t" + "DATE : " + subDate + "\t" + "Dep : " + subDeposit
				+ "\t" + "Count : " + subCount;
	}

	public String getSubNum() {
		return subNum;
	}

	public void setSubNum(String subNum) {
		this.subNum = subNum;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getSubDate() {
		return subDate;
	}

	public void setSubDate(String subDate) {
		this.subDate = subDate;
	}

	public int getSubDeposit() {
		return subDeposit;
	}

	public void setSubDeposit(int subDeposit) {
		this.subDeposit = subDeposit;
	}

	public int getSubCount() {
		return subCount;
	}

	public void setSubCount(int subCount) {
		this.subCount = subCount;
	}

}
