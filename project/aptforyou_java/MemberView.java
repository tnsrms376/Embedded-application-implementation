package project.apt.foryou;

import java.util.Scanner;

public class MemberView {
	static AptController aptCon = new AptController();
	private static Scanner sc = new Scanner(System.in);
	
	
	
	
	public static void mainRun() {
		boolean boo = true;

		while (boo == true) {
			
			showMenu();
			System.out.println();
			boo = getEnd();
			
		}
	}
	

	public static void showMenu() {
		System.out.println();
		System.out.println("===================== 아파트 4U  =====================");
		System.out.println("[1. 회원가입][2. 회원 로그인][3. 관리자 로그인][4. 당첨자 조회]");
		int num = sc.nextInt();

		switch (num) {
		case 1:
			aptCon.memberInsert();
			break;
		case 2:
			aptCon.Login();
			submenuView();
			break;
		case 3:
			ManagerView.manegrLogin();
			// 관리자 로그인
			break;
		case 4:
			WinnerDAO dao = new WinnerDAO();
			dao.winnerView();
			break;
		default:
			System.out.println("잘못입력하셨습니다. 초기화면으로 돌아갑니다");
			break;
		}
	}// showMenu end


	public static void addInfo() {
		System.out.println("▶  추가로 입력할 정보를 선택해주세요");
		System.out.println("[1. 신혼부부][2. 부양가족][3. 유주택자]");
		int num = sc.nextInt();
		
		switch (num) {
		case 1:
			aptCon.partnerAdd();
			break;
		case 2:
			aptCon.familyAdd();
			break;
		case 3:
			aptCon.houseAdd();
			break;
		default:
			break;
		}
	}
	

	public static boolean getEnd() {	// 뒤로가기
		System.out.println("[1. 뒤로가기][2. 종료하기]");
		int num = sc.nextInt();
		if (num == 1) {
			return true;
		} else {
			System.out.println("프로그램이 종료되었습니다.");
			System.exit(0);
			return false;
		}
	}// getEnd end
	
	

	public static void submenuView() {
		boolean boo = true;
		while (boo) {
			System.out.println();
			System.out.println("------------------  회원 시스템 목록   ------------------");
			System.out.println("[1. 회원수정][2. 아파트 검색][3. 분양신청][4. 로그아웃][5. 회원탈퇴][0. 종료]");
			int key = sc.nextInt();

			switch (key) {
			case 1:
				modify();
				break;
			case 2:
				seeApt();
				break;
			case 3:
				aptCon.apply();
				break;
			case 4:
				aptCon.logout();
				break;
			case 5:
				aptCon.remove();
				break;
			case 0:
				getEnd();
				break;
			default:
				System.out.println("잘못입력하셨습니다. 메인 메뉴로 돌아갑니다");
				continue;
			}
		}
	}

	public static void modify() {
		boolean boo = true;
		while (boo) {
			System.out.println("▶ 수정할 카테고리를 지정해주세요 ");
			System.out.println("[1. 내정보][2. 가족정보][3. 배우자정보][4. 청약정보][5. 추가정보 입력][6. 뒤로가기]");
			int key = sc.nextInt();

			switch (key) {
			case 1:
				aptCon.updateMyinfo();
				break;
			case 2:
				aptCon.updateFamilyInfo();
				break;
			case 3:
				aptCon.updatePartnerInfo();
				break;
			case 4:
				aptCon.updateSubInfo();
				break;
			case 5:
				addInfo();
				break;
			case 6:
				submenuView();
				break;
			default:
				System.out.println("잘못입력하셨습니다. 메뉴로 돌아갑니다");
				continue;
			}
		}
	}

	public static void seeApt() {
		boolean boo= true;
		while (boo) {
			System.out.println("▶  조회할 카테고리를 지정해주세요");
			System.out.println("[1. 전체조회][2. 지역별 조회][3. 입주날짜별 조회][4. 뒤로가기]");
			int key = sc.nextInt();

			switch (key) {
			case 1:
				aptCon.showAllApt();
				break;
			case 2:
				aptCon.searchByArea();
				break;
			case 3:
				aptCon.searchByDate();
				break;
			case 4:
				submenuView();
				break;
			default:
				System.out.println("잘못입력하셨습니다. 메뉴로 돌아갑니다");
				break;
			} 
		}
	}

}
