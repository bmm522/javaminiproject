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
						System.out.println(arr.get(i).getName()+"��, ȯ���մϴ�.");
						loginMember = arr.get(i);
						return loginMember;
					} else {
						System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
						return loginMember;
					}
				}
			}
		} else {
			System.out.println("�������� ���� ȸ���Դϴ�.");
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
