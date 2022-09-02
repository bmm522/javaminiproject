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
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
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
			System.out.print("아이디 : ");
			id = sc.nextLine();
			if(mc.checkId(id)) {
				System.out.println("사용가능한 아이디입니다.");
				break;
			} else {
				System.out.println("중복된 아이디 입니다. 다시 입력해주세요.");
				continue;
			}
		}
		
		System.out.print("비밀번호 : ");
		String pwd = sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		Member m = new Member(id, pwd, name, false);
		
		while(true) {
			System.out.print("당신은 관리자입니까?(Y/N) : ");
			String checkAdmin = sc.nextLine();
			switch(checkAdmin) {
			case "Y":
				System.out.print("관리자 코드를 입력하세요 : ");
				String adminCode1 = sc.nextLine();
				if(adminCode1.equals("rosemary4110ZZang")) {
					System.out.println("관리자로 회원가입이 진행됩니다.");
					m.setManager(true);
					mc.enroll(m);
					System.out.println("회원가입이 성공하였습니다.");
					return;
				} else {
					System.out.println("관리자 코드가 아닙니다.");
					continue;
				}
			case "y":
				System.out.print("관리자 코드를 입력하세요 : ");
				String adminCode2 = sc.nextLine();
				if(adminCode2.equals("rosemary4110ZZang")) {
					System.out.println("관리자로 회원가입이 진행됩니다.");
					m.setManager(true);
					mc.enroll(m);
					System.out.println("회원가입이 성공하였습니다.");
					return;
				} else {
					System.out.println("관리자 코드가 아닙니다.");
					continue;
				}
			case "N":
				System.out.println("일반 회원으로 회원가입이 진행됩니다.");
				System.out.println("회원가입이 성공하였습니다.");
				mc.enroll(m);
				return;
			case "n":
				System.out.println("일반 회원으로 회원가입이 진행됩니다.");
				System.out.println("회원가입이 성공하였습니다.");
				mc.enroll(m);
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
			
			
		}
		
	}
	
	public void customerMenu() {
		
		while(true) {
			System.out.println("=====***** 일반 회원 메뉴 *****=====");
			System.out.println("1. 내 정보 보기");
			System.out.println("2. 내 정보 수정");
			System.out.println("3. 탈퇴하기");
			System.out.println("4. 농산물 메뉴로 가기");
			System.out.println("5. 로그아웃");
			System.out.print("메뉴 번호 입력 : ");
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
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
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
			System.out.println("무엇을 변경하시겠습니까 ?");
			System.out.println("1. 비밀번호 ");
			System.out.println("2. 이름 ");
			System.out.print("메뉴 번호 입력 : ");
			int menuNumber = Integer.parseInt(sc.nextLine());
			
			switch(menuNumber) {
			case 1:
				System.out.print("변경 내용 : ");
				String newPwd = sc.nextLine();
				loginMember.setPwd(newPwd);
				mc.updateMember(loginMember);
				break;
			case 2:
				System.out.print("변경 내용 : ");
				String newName = sc.nextLine();
				loginMember.setName(newName);
				mc.updateMember(loginMember);
				break;
			}
			System.out.print("더 바꾸시겠습니까?(Y/N) : ");
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
			System.out.println("=====***** 직원 메뉴 *****=====");
			System.out.println("1. 새 농산물 추가");
			System.out.println("2. 농산물 수정");
			System.out.println("3. 농산물 삭제");
			System.out.println("4. 농산물 목록");
			System.out.println("5. 매출 보기");
			System.out.println("6. 로그아웃");
			System.out.print("메뉴 번호 입력 : ");
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
//				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
//				continue;
//						
//			}
			
			
		}
	}
	
	

}
