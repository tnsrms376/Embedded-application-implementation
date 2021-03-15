package project.apt.foryou;

import java.util.Iterator;

public class WinnerVO {
	
	private int AppNum;
	private String MemId;
	private String MemName;
	private String AptName;
	
	WinnerVO(){}
	
	WinnerVO(int AppNum, String MemId, String MemName, String AptName){
		this.AppNum = AppNum;
		this.MemId = MemId;
		this.MemName = MemName;
		this.AptName = AptName;
		
	}
	
	
	
	@Override
	public String toString() {
		return "아이디 : " + MemId + "\t" +"이름 : " + MemName +"\t"+"아파트명 : "+AptName ;
	}

	public int getAppNum() {
		return AppNum;
	}
	public void setAppNum(int AppNum) {
		this.AppNum = AppNum;
	}
	public String getMemId() {
		return MemId;
	}
	public void setMemId(String memId) {
		this.MemId = memId;
	}
	public String getMemName() {
		return MemName;
	}
	public void setMemName(String memName) {
		this.MemName = memName;
	}
	public String getAptName() {
		return AptName;
	}
	public void setAptName(String aptName) {
		this.AptName = aptName;
	}
	public Iterator<WinnerVO> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	

}


