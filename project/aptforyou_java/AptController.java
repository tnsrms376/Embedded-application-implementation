package project.apt.foryou;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class AptController {
	
	private static Scanner sc = new Scanner(System.in);

	public static Scanner inputKeyboard() {
		return sc;
	}

//------------------------------------------------------------------------------((소정)) 	

	// ==========김소정=================
	void memberInsert() { // 멤버 회원가입

		MemberVO mvo = new MemberVO();
		MemberDAO mdao = new MemberDAO();
		System.out.println("~~~ 추가할 정보를 입력해주세요 ~~~");
		
		System.out.println("▶ 아이디를 입력해주세요");
		String memId = sc.next();

		System.out.println("▶ 비밀번호를 입력해주세요");
		String memPw = sc.next();

		System.out.println("▶ 이름을 입력해주세요");
		String memName = sc.next();

		System.out.println("▶ 주민번호를 입력해주세요");
		String memRegnum = sc.next();

		System.out.println("▶ 주소를 입력해주세요");
		String memAddress = sc.next();

		System.out.println("▶ 핸드폰번호를 입력해주세요");
		String memMobile = sc.next();

		mvo = new MemberVO(memId, memPw, memName, memRegnum, memAddress, memMobile);
		mdao.memberJoin(mvo);

	}

	void partnerAdd() { // 신혼부부 추가

		PartnerVO pvo = new PartnerVO();
		PartnerDAO pdao = new PartnerDAO();
		System.out.println("~~~ 추가할 정보를 입력해주세요 ~~~");
		
		System.out.println("▶ 아이디를 입력해주세요");
		String memId = sc.next();

		System.out.println("▶ 배우자 이름을 입력해주세요");
		String parName = sc.next();

		System.out.println("▶ 배우자 주민번호를 입력해주세요");
		String parRegnum = sc.next();

		System.out.println("▶ 배우자 성별을 입력해주세요 ");
		String parSex = sc.next();

		System.out.println("▶ 혼인신고일을 입력해주세요");
		String parRegdate = sc.next();

		pvo = new PartnerVO(memId, parName, parRegnum, parSex, parRegdate);
		pdao.partnerAdd(pvo);

	}// partneradd end

	void familyAdd() { // 부양가족 추가
		FamilyVO fvo = new FamilyVO();
		FamilyDAO fdao = new FamilyDAO();
		System.out.println("~~~ 추가할 정보를 입력해주세요 ~~~");
		
		System.out.println("▶ 아이디를 입력해주세요");
		String memid = sc.next();

		System.out.println("▶ 가족의 이름을 입력해주세요");
		String fname = sc.next();

		System.out.println("▶ 가족의 주민번호를 입력해주세요");
		String fregnum = sc.next();

		System.out.println("▶ 가족의 성별을 입력해주세요");
		String fsex = sc.next();

		System.out.println("▶ 가족과의 관계를 입력해주세요");
		String frel = sc.next();

		fvo = new FamilyVO(memid, fname, fregnum, fsex, frel);
		fdao.familyAdd(fvo);

	}// familyadd end

	void houseAdd() { // 유주택자
		HouseVO hvo = new HouseVO();
		HouseDAO hdao = new HouseDAO();
		System.out.println("~~~ 추가할 정보를 입력해주세요 ~~~");
		
		System.out.println("▶ 아이디를 입력해주세요");
		String memid = sc.next();

		System.out.println("▶ 집 매입일을 입력해주세요");
		String hpdate = sc.next();

		System.out.println("▶ 지역을 입력해주세요");
		String loc = sc.next();

		hvo = new HouseVO(memid, hpdate, loc);
		hdao.houseAdd(hvo);

	}// HouseAdd end
	
	

	void Login() { // 로그인창
		MemberDAO dao = new MemberDAO();

		System.out.print("▶ 아이디 : ");
		String logid = sc.next();
		System.out.println();
		System.out.print("▶ 비밀번호 : ");
		String logpw = sc.next();

		MemberVO mvo = dao.Login(logid);

		if (logid.equals(mvo.getMemId()) && logpw.equals(mvo.getMemPw())) {
			System.out.println();
			System.out.println();
			System.out.println("******* 회원님 무료 입장 ******* ");
			System.out.println();
		} else {
			System.out.println("######## 회원 로그인 실패 ########");
			MemberView.showMenu();
			
		}
	}

	void logout() {
		System.out.println("로그아웃 되셨습니다.");
		System.out.println();
		System.out.println();
		MemberView.showMenu();
	}

//------------------------------------------------------------------------------((진경)) 	

	
	
	// 내 정보 수정
	public void updateMyinfo() {
		MemberDAO memDAO = new MemberDAO();
		ApplicationDAO appDAO = new ApplicationDAO();

		System.out.println("▶ 아이디를 입력해주세요 ");
		String id = sc.next();

		MemberVO member = memDAO.getMember(id); 		// 멤버 아이디 검사 
		ApplicationVO app = appDAO.getAppMember(id);	// 수정 cascade 
		
		if (id.equals(member.getMemId())) { // 입력한 아이디와 객체에서 가져온 아이디가 같으면 true
			System.out.println("▶ 수정할 이름을 입력해주세요 ");
			String name = sc.next();
			System.out.println("▶ 수정할 주소를 입력해주세요  ");
			String addr = sc.next();
			System.out.println();
			String mobile = checkMobileNumber(); // 휴대폰번호 검사 메서드

			//새로운 객체에 수정된 내용 저장 
			member = new MemberVO(id, name, addr, mobile);
			app = new ApplicationVO(id, name);
			memDAO.updateMyinfo(member, app);
			System.out.println("****** 성공적으로 변경되었습니다 ******");
			System.out.println();
		} else {
			System.out.println("###### 일치하는 ID의 내역이 존재하지 않습니다 ######");
		}
	}

	// 핸드폰번호 유효성 체크
	public String checkMobileNumber() {
		while (true) {
			System.out.println("▶ 수정할 핸드폰 번호를 입력해주세요 ");
			String mobile = sc.next();
			if (mobile.length() > 13 || mobile.length() < 13 || mobile.charAt(3) != '-' || mobile.charAt(8) != '-') {
				System.out.println("######## 다시 입력해주세요 ########");
				System.out.println("입력 형식은 '0000-00-00' 입니다. ");
			} else {
				return mobile;
			}
		}
	}

	// 가족 정보 수정
	public void updateFamilyInfo() {
		FamilyDAO dao = new FamilyDAO();

		System.out.println("▶ 아이디를 입력해주세요 ");
		String id = sc.next();
		System.out.println("▶ 가족의 이름을 입력해주세요 "); // 회원 1명당 여러 명의 가족이 존재하므로
		String famName = sc.next();
		FamilyVO family = dao.getMember(id, famName);

		if (id.equals(family.getMemId()) && famName.equals(family.getFamName())) {
			System.out.println("▶ 수정할 가족의 이름을 입력해주세요 ");
			String newName = sc.next();
			System.out.println("▶ 수정할 가족의 성별을 입력해주세요 ");
			String sex = sc.next();
			System.out.println("▶ 수정할 가족의 관계를 입력해주세요 ");
			String relation = sc.next();
			String regnum = "";

			family = new FamilyVO(id, famName, newName, regnum, sex, relation);
			dao.updateFamilyinfo(family);
			System.out.println("****** 성공적으로 변경되었습니다 ******");
			System.out.println();

		} else {
			System.out.println("###### 일치하는 ID의 내역이 존재하지 않습니다 ######");
		}
	}

	// 배우자 정보 수정
	public void updatePartnerInfo() {
		PartnerDAO dao = new PartnerDAO();

		System.out.println("▶ 아이디를 입력해주세요 ");
		String id = sc.next();
		PartnerVO partner = dao.getMember(id);

		if (id.equals(partner.getMemId())) {
			System.out.println("▶ 수정할 배우자의 이름을 입력해주세요 ");
			String name = sc.next();
			System.out.println("▶ 수정할 배우자의 성별을 입력해주세요 ");
			String sex = sc.next();
			String regdate = checkRegdate(); // 혼인 신고 날짜 확인 메서드

			partner = new PartnerVO(id, name, sex, regdate);
			dao.updatePartnerinfo(partner);
			System.out.println("****** 성공적으로 변경되었습니다 ******");
			System.out.println();

		} else {
			System.out.println("###### 일치하는 ID의 내역이 존재하지 않습니다 ######");
		}
	}

	// 혼인날짜 유효성 체크
	public String checkRegdate() {
		while (true) {
			System.out.println("▶ 수정할 혼인신고일을 입력해주세요 ");
			String regdate = sc.next();
			if (regdate.length() > 10 || regdate.length() < 10 || regdate.charAt(4) != '-'
					|| regdate.charAt(7) != '-') {
				System.out.println("######## 다시 입력해주세요 ########");
				System.out.println("입력 형식은 '0000-00-00' 입니다. ");
			} else {
				return regdate;

			}

		}
	}

	// 청약정보 수정
	public SubscriptionVO updateSubInfo() {
		SubscriptionDAO dao = new SubscriptionDAO();

		System.out.println("▶ 아이디를 입력해주세요 ");
		String id = sc.next();
		SubscriptionVO sub = dao.getSubMember(id);

		if (id.equals(sub.getMemId())) {
			String subNum = sub.getSubNum();
			String date = checkSubdate(); // 날짜 확인 메서드
			int deposit = checkDeposit(); // deposit 확인 메서드

			// 납입횟수를 계산하여 자동으로 수정해준다.
			LocalDate today = LocalDate.now();
			LocalDate startDate = LocalDate.parse(date);
			Period period = Period.between(startDate, today);
			int count = period.getMonths();

			sub = new SubscriptionVO(subNum, id, date, deposit, count);
			dao.updateSubInfo(sub);
			System.out.println("청약통장 정보는 개인정보 확인 후 변경됩니다.");
			System.out.println("********** 변경신청 완료! **********");
			System.out.println();
		} else {
			System.out.println("###### 일치하는 ID의 내역이 존재하지 않습니다 ######");
		}
		return sub;
	}

	// 청약날짜 유효성 체크
	public String checkSubdate() {
		while (true) {
			System.out.println("▶ 수정할 청약날짜를 입력해주세요 ");
			
			String subdate = sc.next();
			if (subdate.length() > 10 || subdate.length() < 10 || subdate.charAt(4) != '-'
					|| subdate.charAt(7) != '-') {
				System.out.println("######## 다시 입력해주세요 ########");
				System.out.println("입력 형식은 '0000-00-00' 입니다. ");
			} else {
				return subdate;
			}
		}
	}

	// deposit은 보통 매월 2만원에서 50만원 이내로 납입 가능.
	public int checkDeposit() {
		while (true) {
			System.out.println("▶ 수정할 청약예금을 입력해주세요 ");
			int deposit = sc.nextInt();
			if (deposit < 20000 || deposit > 500000) {
				System.out.println("### 2만원~50만원 사이의 금액을 입력해주세요 ###");

			} else {
				return deposit;
			}
		}
	}

	// 아파트 전체 조회
	public void showAllApt() {
		ApartmentDAO dao = new ApartmentDAO();

		Iterator<ApartmentVO> itr = dao.getAllApt().iterator(); // list가 리턴되므로 list의 iterator메서드 호출
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 아파트 전체 조회 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		while (itr.hasNext()) {
			System.out.println(itr.next());
			System.out.println();
			System.out.println();

		}
	}

	public void searchByArea() {
		ApartmentDAO dao = new ApartmentDAO();

		System.out.println("▶ 찾을 아파트의 지역을 입력해주세요 ");
		String area = sc.next();

		Iterator<ApartmentVO> itr = dao.searchByArea(area).iterator();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 아파트 지역별 조회 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		System.out.println();
		while (itr.hasNext()) {
			System.out.println(itr.next());
			System.out.println();
			System.out.println();
		}

	}

	public void searchByDate() {
		ApartmentDAO dao = new ApartmentDAO();

		System.out.println("▶ 찾을 아파트의 입주년도를 입력해주세요 ");
		String year = sc.next();

		Iterator<ApartmentVO> itr = dao.searchByDate(year).iterator();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 아파트 연도별 조회 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n");
		while (itr.hasNext()) {
			System.out.println(itr.next());
			System.out.println();
			System.out.println();
		}
	}

	// 아파트 분양 신청
	public void apply() {
		MemberDAO memDAO = new MemberDAO();
		MemberVO mem = new MemberVO();

		ApplicationDAO appDAO = new ApplicationDAO();
		ApplicationVO app = null;

		System.out.println("▶ 아이디를 입력해주세요 ");
		String memId = sc.next();

		mem = memDAO.getMember(memId); // 입력한 아이디의 회원 정보 가져오기
		if (memId.equals(mem.getMemId())) { // 그 회원의 id 가져와서 같은지 비교

			System.out.println("▶ 이름을 입력해주세요 ");
			String memName = sc.next();

			//신청서 테이블의 appNum = 신청서 번호, insert할 시에 자동으로 증가 
			int appNum = appDAO.countNum() + 1;
			String aptName = getAptName();
			int aptId = getAptId(aptName);

			app = new ApplicationVO(appNum, memName, aptId, aptName, memId);
			appDAO.apply(app);
			System.out.println("****** 성공적으로 변경되었습니다 ******");
			System.out.println();

		} else {
			System.out.println("###### 회원가입을 먼저 진행해주세요 ######");
		}
	}

	// 분양 가능한 아파트 이름 가져오기
	public String getAptName() {
		System.out.println("[1. e-편한세상 하늘채] [2. 롯데캐슬 엘클라씨]");
		int input = sc.nextInt();
		String aptName;
		if (input == 1) {
			aptName = "e-편한세상 하늘채";
			return aptName;
		} else {
			aptName = "롯데캐슬 엘클라씨";
			return aptName;
		}
	}

	// 분양 가능한 아파트 번호 가져오기
	public int getAptId(String aptName) {
		if (aptName.equals("e-편한세상 하늘채")) {
			return 1;
		}
		else
			return 39;
	}

	// 회원탈퇴
	public void remove() {
		MemberDAO dao = new MemberDAO();
		System.out.println("▶ 아이디를 입력해주세요 ");
		String id = sc.next();
		System.out.println("▶ 비밀번호를 입력해주세요 ");
		String pw = sc.next();
		System.out.println("▶ 탈퇴하시겠습니까? ");
		System.out.println("▶  Y/N");
		String answer = sc.next();

		MemberVO member = dao.getMember(id);
		if (answer.equals("y") && id.equals(member.getMemId()) && pw.equals(member.getMemPw())) {
			dao.remove(id);
			System.out.println("****** 탈퇴 성공 ******");
			MemberView.showMenu();
		} else {
			System.out.println("###### 아이디와 비밀번호를 확인해주세요 ######");
		}

	}

//------------------------------------------------------------------------------((순근)) 	

	// 새로운 아파트 등록
	public void createAptInfo() {
		ApartmentDAO dao = new ApartmentDAO();
		ApartmentVO avo = new ApartmentVO();

		int AptId = dao.countaptid() + 1;

		System.out.println("▶ 아파트명을 입력해주세요 ");
		String AptName = sc.next();

		System.out.println("▶ 아파트의 주소를 입력해주세요 ");
		String AptAddr = sc.next();

		System.out.println("▶ 분양 세대 수를 입력해주세요 ");
		int AptCount = sc.nextInt();

		System.out.println("▶ 아파트 넓이를 입력해주세요 ");
		String AptSize = sc.next();

		System.out.println("▶ 아파트 분양가를 입력해주세요 ");
		int AptPrice = sc.nextInt();

		System.out.println("▶ 입주 가능일을 입력해주세요 ");
		System.out.println("  입력 형식은 '0000-00-00' 입니다. ");
		String AptIndate = sc.next();

		System.out.println("▶ 시공사명을 입력해주세요 ");
		String ComName = sc.next();

		avo = new ApartmentVO(AptId, AptName, AptAddr, AptCount, AptSize, AptPrice, AptIndate, ComName);
		dao.CreateAptInfo(avo);
		System.out.println("****** 성공적으로 등록되었습니다 ******");
		System.out.println();
	}

	// 아파트 정보 수정
	public void updateAptInfo() {
		ApartmentDAO dao = new ApartmentDAO();
		System.out.print("▶ 수정할 아파트ID를 입력해주세요 ");
		int findAptNum = sc.nextInt();
		ApartmentVO avo = dao.getAptId(findAptNum);

		if (findAptNum == avo.getAptId()) {

			System.out.println("▶ 아파트명을 입력해주세요 ");
			String AptName = sc.next();

			System.out.println("▶ 아파트 주소를 입력해주세요 ");
			String AptAddr = sc.next();

			System.out.println("▶ 분양 세대 수를 입력해주세요 ");
			int AptCount = sc.nextInt();

			System.out.println("▶ 아파트 넓이를 입력해주세요 ");
			String AptSize = sc.next();

			System.out.println("▶ 아파트 분양가를 입력해주세요 ");
			int AptPrice = sc.nextInt();

			System.out.println("▶ 입주 가능일을 입력해주세요 ");
			System.out.println("  입력 형식은 '0000-00-00' 입니다. ");
			String AptIndate = sc.next();

			System.out.println("▶ 시공사명을 입력해주세요 ");
			String ComName = sc.next();

			avo = new ApartmentVO(findAptNum, AptName, AptAddr, AptCount, AptSize, AptPrice, AptIndate, ComName);
			dao.updateAptInfo(avo);
			System.out.println("****** 성공적으로 수정되었습니다 ******");
			System.out.println();
		} else {
			System.out.println("###### 일치하는 ID의 내역이 존재하지 않습니다 ######");
		}
	}

	// 기존 등록아파트 삭제
	public void deleteAptInfo() {
		ApartmentDAO dao = new ApartmentDAO();

		System.out.print("▶ 삭제할 아파트ID를 입력해주세요 ");
		int findAptNum = sc.nextInt();
		ApartmentVO avo = dao.getAptId(findAptNum);

		if (findAptNum == avo.getAptId()) {

			dao.DeleteAptInfo(avo);

			System.out.println("****** 성공적으로 삭제되었습니다 ******");
			System.out.println();
		} else {
			System.out.println("###### 일치하는 ID의 내역이 존재하지 않습니다 ######");
		}
	}


//------------------------------------------------------------------------------((수민)) 	

	public void getMember() {// 회원정보 찾기
		MemberDAO mdao = new MemberDAO();
		System.out.println("▶ 조회할 회원ID를 입력해 주세요"); 
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		String key = sc.next();
		System.out.println("[ID]" + key + "로 정보 검색");
		System.out.println("========================================================================");
		list.add(mdao.getMember(key));
		System.out.println("   데이터 수 " + list.size());
		for (MemberVO arr : list) {
			System.out.println(arr);
		}
	}

	public void getAllmember() { // 회원 전체 조회
		MemberDAO mdao = new MemberDAO();
		System.out.println("[전체] 회원 조회");
		System.out.println("========================================================================");
		List<MemberVO> list = mdao.getAllmember();
		for (MemberVO arr : list) {
			System.out.println(arr);
		}
	}

	public void getlocmember() { // 지역별 회원 조회
		MemberDAO mdao = new MemberDAO();
		System.out.println("▶  조회할 지역을 입력해주세요");
		String loc = sc.next();
		System.out.println("[지역]" + loc + "로 정보 검색");
		System.out.println("========================================================================");
		List<MemberVO> list = mdao.getlocation(loc);
		System.out.println("   데이터 수 " + list.size());
		for (MemberVO arr : list) {
			System.out.println(arr);
		}
	}

	public void getAllapp() { // 분양신청자전체 조회
		ApplicationDAO adao = new ApplicationDAO();
		System.out.println("[카테고리] 분양신청자 조회");
		System.out.println("========================================================================");
		List<ApplicationVO> list = adao.getAllapp();
		System.out.println("   데이터 수 " + list.size());
		for (ApplicationVO arr : list) {
			System.out.println(arr);
		}
	}

	public void getAllhouse() { // 주택보유자 조회
		HouseDAO hdao = new HouseDAO();
		System.out.println("[카테고리] 주택보유자 조회");
		System.out.println("========================================================================");
		List<HouseVO> list = hdao.getAllhouse();
		System.out.println("   데이터 수 " + list.size());
		for (HouseVO arr : list) {
			System.out.println(arr);
		}
	}

	public void getAllpar() { // 신혼부부 전체 조회
		PartnerDAO pdao = new PartnerDAO();
		System.out.println("[카테고리] 신혼부부 조회");
		System.out.println("========================================================================");
		List<PartnerVO> list = pdao.getAllpar();
		System.out.println("   데이터 수 " + list.size());
		for (PartnerVO arr : list) {
			System.out.println(arr);
		}
	}

	// ===수민 청약가입자 조회 20201227
	public void getAllsub() {// 청약가입자 조회
		SubscriptionDAO sdao = new SubscriptionDAO();
		System.out.println("[카테고리] 청약가입자 조회");
		System.out.println("========================================================================");
		List<SubscriptionVO> list = sdao.getAllsub();
		System.out.println("   데이터 수 " + list.size());
		for (SubscriptionVO arr : list) {
			System.out.println(arr);
		}
	}

	public void winChoice() { // 당첨자 선정 -- 실행파일
		ApplicationDAO adao = new ApplicationDAO();
		System.out.println("▶  당첨자 선정하고자 하는 아파트 ID를 입력해주세요");
		System.out.println("========================================================================");
		int num = sc.nextInt();
		System.out.println("[아파트 ID]" + num + " 당첨자 선정중");
		adao.UpdateAddscore();
		List<ApplicationVO> list = adao.getSelapp(num);
		System.out.println("~~~~~~~~~~~~~ l o a d i n g ~~~~~~~~~~~~~");
		getMemberList(list);
		hastfamily(list, num);
		hasSubscrip(list, num);
		hasPartner(list, num);
		getWinapp(num);
		adao.dropScore();
	}

	// ------아래파일들은 당첨자 선정안에서 실행메소드

	List<ApplicationVO> getMemberList(List<ApplicationVO> list) {// 신청자]무주택자 뽑기 //---깔끔하게 정리예정
		ApplicationDAO adao = new ApplicationDAO();
		HouseDAO hdao = new HouseDAO();
		List<HouseVO> hlist = hdao.getAllhouse();
		Set<String> arr = new HashSet<String>();

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < hlist.size(); j++) {
				ApplicationVO app = list.get(i);
				HouseVO hou = hlist.get(j);
				if (app.getMemId().equals(hou.getMemId())) {
					arr.add(app.getMemId());
				}
			}
		}
		List<String> eqlist = new ArrayList<String>(arr);
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < eqlist.size(); j++) {
				if (list.get(i).getMemId().equals(eqlist.get(j))) {
					list.remove(i);
				}
			}
		}
		return list;
	}

	public void getWinapp(int num) { // 당첨자 조회 ****수민 수정 201227
		ApplicationDAO adao = new ApplicationDAO();
		WinnerDAO wdao = new WinnerDAO();
		System.out.println("당첨자 발표");
		System.out.println("========================================================================");
		List<ApplicationVO> list = adao.getSelapp(num);
		Collections.sort(list, new ApplicationVO());
		for (int j = 0; j < list.size(); j++) {
			for (int i = j; i < 5 + j; i++) {
				System.out.println("[ 아파트 번호  ] " + list.get(i).getAptId() + "  [ 회원 ID ] " + list.get(i).getMemId()
						+ "  [ 점 수 ] " + list.get(i).getScore());
			}
			System.out.println();
			System.out.println("                    청약 담청을 축하드립니다~!");
			System.out.println("  " + list.get(j).getMemId() + " " + "님 청약 당첨을 취소하시겠습니까?");
			System.out.println("[1. 네, 취소하겠습니다.]" + "[2. 아니요, 취소하지 않겠습니다.]");
			int select = sc.nextInt();
			if (select != 1) {
				for (int i = j; i < 5 + j; i++) {
					wdao.insertWiner(list.get(i));
				}
				break;
			}
		}
		System.out.println("\n" + "최종 청약 당첨을 축하드립니다.");
		System.out.println("감사합니다.");
	}

	public void hastfamily(List<ApplicationVO> list, int num) {// 신청자]부양가족 리스트
		FamilyDAO fdao = new FamilyDAO();
		ApplicationDAO adao = new ApplicationDAO();
		List<FamilyVO> flist = fdao.getCountfam(num);
		for (int i = 0; i < flist.size(); i++) {
			adao.updateScore(flist.get(i).getMemId(), (flist.get(i).getFamCount()) * 5);
		}
	}

	public void hasPartner(List<ApplicationVO> list, int num) {// 신청자]신혼부부 // ****수민 수정 201227
		PartnerDAO pdao = new PartnerDAO();
		ApplicationDAO adao = new ApplicationDAO();
		List<PartnerVO> plist = pdao.getApppar(num);

		double calDateDays = 0;// 날짜 차이를 담는 변수
		for (int i = 0; i < plist.size(); i++) {
			try {
				String current = "2020-12-27";// 현재날짜
				String last = plist.get(i).getParRegdate();// 해당 혼인신고날짜
				String name = plist.get(i).getMemId();// 해당 아이디
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");// 데이트 형식으로 변환
				Date currentDate = format.parse(current);
				Date lastDate = format.parse(last);
				long calDate = currentDate.getTime() - lastDate.getTime();// 날짜 이계산
				calDateDays = calDate / (24 * 60 * 60 * 1000);// 각 시간값에 따른 차이점
				calDateDays = Math.abs(calDateDays);// 일수
				int days = (int) (calDateDays / 365);// double타입 int로 형변환
				if (days >= 5) {
					adao.updateScore(name, 0);
				} else if (days >= 4) {
					adao.updateScore(name, 4);
				} else if (days >= 3) {
					adao.updateScore(name, 8);
				} else if (days >= 3) {
					adao.updateScore(name, 12);
				} else if (days >= 2) {
					adao.updateScore(name, 16);
				} else {
					adao.updateScore(name, 20);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}

	public void hasSubscrip(List<ApplicationVO> list, int num) { // 신청자]청약 가입 회원
		PartnerDAO pdao = new PartnerDAO();
		SubscriptionDAO sdao = new SubscriptionDAO();
		ApplicationDAO adao = new ApplicationDAO();
		List<SubscriptionVO> slist = sdao.getHasub(num);
		for (int i = 0; i < slist.size(); i++) {
			String name = slist.get(i).getMemId();
			int sum = slist.get(i).getSubCount();
			adao.updateScore(name, (sum % 12) * 5);
		}
	}

	public boolean managerLogin() { // 로그인창
		MemberDAO dao = new MemberDAO();

		System.out.print("▶ 아이디 : ");
		String logid = sc.next();
		System.out.println();
		System.out.print("▶ 비밀번호 : ");
		String logpw = sc.next();

		MemberVO mvo = dao.Login(logid);

		if (logid.equals("lovelyso32") && logpw.equals(mvo.getMemPw())) {
			 System.out.println();
			 System.out.println();
			 System.out.println("****** 관리자님 무료 입장 ******");
			 System.out.println();
			 //수민씨 아이디어 ^___^ 12/27
	         return true;
	      } else {
	         System.out.print("######## 관리자 로그인 실패 ########");
	         return false;
	      }
		}
}
