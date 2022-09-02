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
//		System.out.print("아이디 : ");
//		String id = sc.nextLine();
//		System.out.print("비밀번호 : ");
//		String pwd = sc.nextLine();
//		
//		
//	}
//	
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
					return;
				} else {
					System.out.println("관리자 코드가 아닙니다.");
					continue;
				}
			case "N":
				System.out.println("일반 회원으로 회원가입이 진행됩니다.");
				mc.enroll(m);
				return;
			case "n":
				System.out.println("일반 회원으로 회원가입이 진행됩니다.");
				mc.enroll(m);
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
			
			System.out.println("회원가입이 성공하였습니다.");
		}
		
	}

}
