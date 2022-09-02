package overall.view;

import java.util.Scanner;

import overall.member.view.MemberMenu;

public class Menu {
	public static Scanner sc = new Scanner(System.in);
	private MemberMenu mm = new MemberMenu();
	
	public void mainMenu() {
		System.out.println("========== 환영합니다. ==========");
		while(true) {
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 :");
			int menuNumber = Integer.parseInt(sc.nextLine());
			switch(menuNumber) {
			case 1:
				mm.login();
				break;
			case 2:
				mm.enroll();
				break;
			case 9:
				System.out.println("프로그램 종료.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
				continue;
			}
		}
	}
}
