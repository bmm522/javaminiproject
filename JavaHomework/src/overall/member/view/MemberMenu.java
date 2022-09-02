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
	
	public Member login() {
		System.out.print("���̵� : ");
		String id = sc.nextLine();
		System.out.print("��й�ȣ : ");
		String pwd = sc.nextLine();
		loginMember = mc.login(id, pwd);
		if(loginMember != null) {
			if(loginMember.isManager() == false) {
				customerMenu();
			} else {
				adminMenu();
			}
		}
		return loginMember;
		
	}
	
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
					System.out.println("ȸ�������� �����Ͽ����ϴ�.");
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
					System.out.println("ȸ�������� �����Ͽ����ϴ�.");
					return;
				} else {
					System.out.println("������ �ڵ尡 �ƴմϴ�.");
					continue;
				}
			case "N":
				System.out.println("�Ϲ� ȸ������ ȸ�������� ����˴ϴ�.");
				System.out.println("ȸ�������� �����Ͽ����ϴ�.");
				mc.enroll(m);
				return;
			case "n":
				System.out.println("�Ϲ� ȸ������ ȸ�������� ����˴ϴ�.");
				System.out.println("ȸ�������� �����Ͽ����ϴ�.");
				mc.enroll(m);
				return;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				break;
			}
			
			
		}
		
	}
	
	public void customerMenu() {
		
		while(true) {
			System.out.println("=====***** �Ϲ� ȸ�� �޴� *****=====");
			System.out.println("1. �� ���� ����");
			System.out.println("2. �� ���� ����");
			System.out.println("3. Ż���ϱ�");
			System.out.println("4. ��깰 �޴��� ����");
			System.out.println("5. �α׾ƿ�");
			System.out.print("�޴� ��ȣ �Է� : ");
			int menuNumber = Integer.parseInt(sc.nextLine());
			
			switch(menuNumber) {
			case 1:
				checkMyinfo();
				break;
			case 2:
				updateMyInfo();
				break;
//			case 3:
//				deleteMyInfo();
//				break;
//			case 4:
//				goVegitable();
//				break;
//			case 5:
//				logout();
//				return;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				continue;
			
			}
			
			
		}
		
	}

	

	private void checkMyinfo() {
		System.out.printf("ID : " +loginMember.getId() 
		+ "\nPWD : " 
		+loginMember.getPwd().substring(0,2)
		+loginMember.getPwd().substring(2,loginMember.getPwd().length()).replaceAll(".", "*")
		+"\nNAME : " + loginMember.getName()+"\n");
		
	}
	
	private void updateMyInfo() {
		while(true) {
			checkMyinfo();
			System.out.println("������ �����Ͻðڽ��ϱ� ?");
			System.out.println("1. ��й�ȣ ");
			System.out.println("2. �̸� ");
			System.out.print("�޴� ��ȣ �Է� : ");
			int menuNumber = Integer.parseInt(sc.nextLine());
			
			switch(menuNumber) {
			case 1:
				System.out.print("���� ���� : ");
				String newPwd = sc.nextLine();
				loginMember.setPwd(newPwd);
				mc.updateMember(loginMember);
				break;
			case 2:
				System.out.print("���� ���� : ");
				String newName = sc.nextLine();
				loginMember.setName(newName);
				mc.updateMember(loginMember);
				break;
			}
			System.out.print("�� �ٲٽðڽ��ϱ�?(Y/N) : ");
			String checkStr = sc.nextLine();
			
			if(checkStr.equals("Y") || checkStr.equals("y")) {
				continue;
			} else if (checkStr.equals("N") || checkStr.equals("n")){
				return;
			}
		}
	}

	public void adminMenu() {
		
		while(true) {
			System.out.println("=====***** ���� �޴� *****=====");
			System.out.println("1. �� ��깰 �߰�");
			System.out.println("2. ��깰 ����");
			System.out.println("3. ��깰 ����");
			System.out.println("4. ��깰 ���");
			System.out.println("5. ���� ����");
			System.out.println("6. �α׾ƿ�");
			System.out.print("�޴� ��ȣ �Է� : ");
			int menuNumber = Integer.parseInt(sc.nextLine());
			
//			switch(menuNumber) {
//			case 1:
//				fm.addNewKind();
//				break;
//			case 2:
//				fm.updateKind();
//				break;
//			case 3:
//				fm.removeKind();
//				break;
//			case 4:
//				fm.printFarm();
//				break;
//			case 5:
//				fm.printSales();
//				break;
//			case 6:
//				logout();
//				return;
//			default:
//				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
//				continue;
//						
//			}
			
			
		}
	}
	
	

}
