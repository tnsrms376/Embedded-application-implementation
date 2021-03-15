package project.apt.foryou;

import java.util.ArrayList;  // 진경

public class HouseVO { //수민 201224 20:40
	String memId;
	String houPdate;
	String houLocation;
	
	HouseVO(){}
	
	HouseVO(String memId, String houPdate, String houLocation){
		this.memId = memId;
		this.houPdate = houPdate;
		this.houLocation = houLocation;
	}
	
	HouseVO(String memId, String houPdate){
		this.memId = memId;
		this.houPdate = houPdate;
	}
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getHouPdate() {
		return houPdate;
	}
	public void setHouPdate(String houPdate) {
		this.houPdate = houPdate;
	}
	public String getHouLocation() {
		return houLocation;
	}
	public void setHouLocation(String houLocation) {
		this.houLocation = houLocation;
	}

	@Override
	public String toString() {
		return "[회원ID] " + memId + "  [주소] " + houPdate + "  [거주지] " + houLocation;
	}
	
}
