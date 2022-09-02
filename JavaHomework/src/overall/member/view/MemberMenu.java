package overall.member.view;

import java.util.Scanner;

import overall.member.controller.MemberController;
import overall.member.model.vo.Member;
import overall.view.FarmMenu;
import overall.view.Menu;

public class MemberMenu {
	
	Scanner sc = Menu.sc;
	MemberController mc = new MemberController();
	FarmMenu fm = new FarmMenu();
	public Member loginMember;
	
//	public Member login() {
//		System.out.print("���̵� : ");
//		String id = sc.nextLine();
//		System.out.print("��й�ȣ : ");
//		String pwd = sc.nextLine();
//		
//		
//	}
//	
	public void enroll() {
		String id;
		while(true) {
			System.out.print("���̵� : ");
			id = sc.nextLine();
			if(mc.checkId(id)) {
				System.out.println("��밡���� ���̵��Դϴ�.");
				break;
			} else {
				System.out.println("�ߺ��� ���̵� �Դϴ�. �ٽ� �Է����ּ���.");
				continue;
			}
		}
		
		System.out.print("��й�ȣ : ");
		String pwd = sc.nextLine();
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		Member m = new Member(id, pwd, name, false);
		
		while(true) {
			System.out.print("����� �������Դϱ�?(Y/N) : ");
			String checkAdmin = sc.nextLine();
			switch(checkAdmin) {
			case "Y":
				System.out.print("������ �ڵ带 �Է��ϼ��� : ");
				String adminCode1 = sc.nextLine();
				if(adminCode1.equals("rosemary4110ZZang")) {
					System.out.println("�����ڷ� ȸ�������� ����˴ϴ�.");
					m.setManager(true);
					mc.enroll(m);
					return;
				} else {
					System.out.println("������ �ڵ尡 �ƴմϴ�.");
					continue;
				}
			case "y":
				System.out.print("������ �ڵ带 �Է��ϼ��� : ");
				String adminCode2 = sc.nextLine();
				if(adminCode2.equals("rosemary4110ZZang")) {
					System.out.println("�����ڷ� ȸ�������� ����˴ϴ�.");
					m.setManager(true);
					mc.enroll(m);
					return;
				} else {
					System.out.println("������ �ڵ尡 �ƴմϴ�.");
					continue;
				}
			case "N":
				System.out.println("�Ϲ� ȸ������ ȸ�������� ����˴ϴ�.");
				mc.enroll(m);
				return;
			case "n":
				System.out.println("�Ϲ� ȸ������ ȸ�������� ����˴ϴ�.");
				mc.enroll(m);
				return;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				break;
			}
			
			System.out.println("ȸ�������� �����Ͽ����ϴ�.");
		}
		
	}

}
