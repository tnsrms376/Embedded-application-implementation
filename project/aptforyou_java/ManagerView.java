package project.apt.foryou;

import java.util.Scanner;

public class ManagerView {
	private static Scanner sc = new Scanner(System.in);
	static AptController controller = new AptController();

	public static Scanner inputKeyboard() {
		return sc;
	}

	public static void manegrLogin() {/// manegerLogin
		int count = 0;
		for (int i = 0; i < 3; i++) {
			count++;
			if (controller.managerLogin() == false) {
				System.out.println();
				System.out.println("가입하지 않은 아이디이거나, 잘못된 비밀번호입니다." + count + " 회 틀리셨습니다.");
				System.out.println("남은 로그인 기회는 " + (3 - count) + " 회 남았습니다." + "\n");
				if (count == 3) {
					System.out.println("30분뒤 로그인 해주세요");
				}
			} else {
				manegerView();
				break;
			}
		}
	}

	public static void manegerView() {
		boolean boo = true;
		while (boo) {
			System.out.println("------------------  관리자 시스템 목록   ------------------");
			System.out.println("[1. 아파트 등록][2. 아파트 수정][3. 아파트 삭제][4. 아파트 조회][5. 회원 조회][6. 당첨자 선정][7. 종료]");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				controller.createAptInfo();
				// 아파트 등록
				break;
			case 2:
				controller.updateAptInfo();// 아파트 수정
				break;
			case 3:
				controller.deleteAptInfo();
				break; // 아파트 삭제
			case 4:
				controller.showAllApt();// 아파트 조회
				break;
			case 5:
				mgSubRun();// 회원 조회
				break;
			case 6:
				controller.winChoice();// 당첨자 선정
				break;
			case 7:
				boo = false;// 종료
				break;
			default:
				System.out.println("잘못입력하셨습니다. 메인 메뉴로 돌아갑니다");
				break;
			}
		}
	}

	public static void mgSubRun() {
		boolean boo = true;

		while (boo) {
			showMenu();
			boo = getEnd();
		}
	}

	public static void showMenu() {
		System.out.println();
		System.out.println("------------------  회원 조회   ------------------");
		System.out.println("[1. 전체조회][2. 회원ID 조회][3. 지역별 조회][4. 카테고리별 조회][5. 관리자 메뉴]");
		int num = sc.nextInt();
		switch (num) {
		case 1:
			controller.getAllmember(); // 전체조회
			break;
		case 2:
			controller.getMember(); // 회원ID 조회
			break;
		case 3:
			controller.getlocmember();// 지역별 조회
			break;
		case 4:
			submenuView();// 카테고리별 조회
			break;
		case 5:
			manegerView();// 관리자메뉴
			break;
		default:
			System.out.println("잘못입력하셨습니다. 메뉴로 돌아갑니다");
			break;
		}

	}// showMenu end

	public static void submenuView() {
		boolean boo = true;
		while (boo) {
			System.out.println("▶  조회할 카테고리를 지정해주세요");
			System.out.println("[1. 주택보유자 조회][2. 신혼부부 조회][3. 청약가입자 조회][4. 분양신청자 조회]");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				controller.getAllhouse();
				break;
			case 2:
				controller.getAllpar();
				break;
			case 3:
				controller.getAllsub();
				break;
			case 4:
				controller.getAllapp();
				break;
			default:
				System.out.println("잘못입력하셨습니다. 메뉴로 돌아갑니다");
				break;
			}
			boo = getEnd();
		}
	}

	public static boolean getEnd() {// 뒤로가기
		System.out.println();
		System.out.println("[1. 뒤로가기][2. 종료하기]");
		int num = sc.nextInt();
		if (num == 1) {
			return true;
		} else {
			System.out.println("프로그램이 종료되었습니다.");
			return false;
		}
	}// getEnd end
}
