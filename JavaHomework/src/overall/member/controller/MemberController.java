package overall.member.controller;

import java.util.ArrayList;

import overall.member.model.dao.MemberDAO;
import overall.member.model.vo.Member;

public class MemberController {
	
	MemberDAO md = new MemberDAO();
	public Member loginMember;
	
	public Member login(String id, String pwd) {
		ArrayList<Member> arr = new ArrayList<Member>();
		arr = md.selectAll();
		if(!md.checkId(id)) {
			for(int i = 0 ; i < arr.size() ; i ++) {
				if(arr.get(i).getId().equals(id)) {
					if(arr.get(i).getPwd().equals(pwd)) {
						System.out.println(arr.get(i).getName()+"님, 환영합니다.");
						loginMember = arr.get(i);
						return loginMember;
					} else {
						System.out.println("비밀번호가 일치하지 않습니다.");
						return loginMember;
					}
				}
			}
		} else {
			System.out.println("존재하지 않은 회원입니다.");
		}
		return loginMember;
	}
	
	public void enroll(Member m) {
		md.enroll(m);
	}

	public boolean checkId(String id) {
		return md.checkId(id);
	}

	public void updateMember(Member updateMember) {
		md.updateMember(updateMember);
	}
}
