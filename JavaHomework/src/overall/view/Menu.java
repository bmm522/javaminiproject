package overall.view;

import java.util.Scanner;

import overall.member.view.MemberMenu;

public class Menu {
	public static Scanner sc = new Scanner(System.in);
	private MemberMenu mm = new MemberMenu();
	
	public void mainMenu() {
		System.out.println("========== ȯ���մϴ�. ==========");
		while(true) {
			System.out.println("******* ���� �޴� *******");
			System.out.println("1. �α���");
			System.out.println("2. ȸ������");
			System.out.println("9. ����");
			System.out.print("�޴� ��ȣ ���� :");
			int menuNumber = Integer.parseInt(sc.nextLine());
			switch(menuNumber) {
			case 1:
				mm.login();
				break;
			case 2:
				mm.enroll();
				break;
			case 9:
				System.out.println("���α׷� ����.");
				return;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���");
				continue;
			}
		}
	}
}
