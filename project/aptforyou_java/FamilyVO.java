package project.apt.foryou; 

public class FamilyVO {
	private String memId;
	private String famName;
	private String newName;
	private String famRegnum;
	private String famSex;
	private String famRelation;
	
	//수민 ===== 1226 13:34
	private int famCount;
	
	public int getFamCount() {
		return famCount;
	}

	public void setFamCount(int famCount) {
		this.famCount = famCount;
	}
	//----- 1226 13:34

	FamilyVO() {
	}

	FamilyVO(String memId, String famName, String newName, String famRegnum, String famSex, String famRelation) {
		this.memId = memId;
		this.famName = famName;
		this.newName = newName;
		this.famRegnum = famRegnum;
		this.famSex = famSex;
		this.famRelation = famRelation;
	}
	
	FamilyVO(String memId, String famName, String famSex, String famRelation) {
		this.memId = memId;
		this.famName = famName;
		this.famSex = famSex;
		this.famRelation = famRelation;
	}
	
	FamilyVO(String memId, String famName, String famRegnum, String famSex, String famRelation) {
		this.memId = memId;
		this.famName = famName;
		this.famRegnum =famRegnum;
		this.famSex = famSex;
		this.famRelation = famRelation;
	}
	
	//수민 201224 19:22 추가
	FamilyVO(String memId, int famCount){
		this.memId = memId;
		this.famCount = famCount;
	}//---수민

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getFamName() {
		return famName;
	}

	public void setFamName(String famName) {
		this.famName = famName;
	}
	
	
	public String getnewName() {
		return newName;
	}

	public void setName(String newName) {
		this.newName = newName;
	}

	public String getFamRegnum() {
		return famRegnum;
	}

	public void setFamRegnum(String famRegnum) {
		this.famRegnum = famRegnum;
	}

	public String getFamSex() {
		return famSex;
	}

	public void setFamSex(String famSex) {
		this.famSex = famSex;
	}

	public String getFamRelation() {
		return famRelation;
	}

	public void setFamRelation(String famRelation) {
		this.famRelation = famRelation;
	}

}
