package project.apt.foryou;
//package apt;

import java.util.Comparator;

public class ApplicationVO implements Comparator<ApplicationVO> { // 수민 비교추가
	private int appNum;
	private String memName;
	private String aptName;
	private int aptId;
	private String memId;

	// 수민 추가 201225 12:55
	private int score;

	ApplicationVO() {
	}

	// ======진경
	ApplicationVO(int appNum, String memName, int aptId, String aptName, String memId) {
		this.appNum = appNum;
		this.memName = memName;
		this.aptId = aptId;
		this.aptName = aptName;
		this.memId = memId;
	}

	ApplicationVO(String memId, int score) {
		this.memId = memId;
		this.score = score;

	}

	// ======수민 score생성자 추가
	ApplicationVO(String memId, int score, int aptId) {
		this.memId = memId;
		this.score = score;
		this.aptId = aptId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	// -----------------수민 멤버생성자
	ApplicationVO(String memId, String memName) {
		this.memId = memId;
		this.memName = memName;
	}

	public int getAppNum() {
		return appNum;
	}

	public void setAppNum(int appNum) {
		this.appNum = appNum;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getAptName() {
		return aptName;
	}

	public void setAptName(String aptName) {
		this.aptName = aptName;
	}

	public int getAptId() {
		return aptId;
	}

	public void setAptId(int aptId) {
		this.aptId = aptId;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	// 수민 추가 ----- 201226
	// 점수 출력 내림차순
	@Override
	public int compare(ApplicationVO score1, ApplicationVO score2) {
		if (score1.score > score2.score)
			return -1;
		if (score1.score < score2.score)
			return 1;
		return 0;
	}

	ApplicationVO(int appNum, int aptId, String memId, String memName, String aptName, int score) {
		this.appNum = appNum;
		this.aptId = aptId;
		this.memId = memId;
		this.memName = memName;
		this.aptName = aptName;
		this.score = score;
	}

	// 수민 점수 예비추가 ---201226
	@Override
	public String toString() {
		return "[신청번호] " + appNum + "  [이름] " + memName + "  [아파트이름] " + aptName + "  [아파트ID] " + aptId + "  [회원ID] "
				+ memId;
	}

}
