package overall.member.controller;

import overall.member.model.dao.MemberDAO;
import overall.member.model.vo.Member;

public class MemberController {
	
	MemberDAO md = new MemberDAO();
	public Member loginMember;
	
//	public Member login(String id, String pwd) {
//		
//	}
//	
	public void enroll(Member m) {
		md.enroll(m);
	}

	public boolean checkId(String id) {
		return md.checkId(id);
	}
}
