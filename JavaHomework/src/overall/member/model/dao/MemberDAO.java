package overall.member.model.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import overall.member.model.vo.Member;

public class MemberDAO {
	File file = new File("c:\\jsp2\\workspace\\JavaHomework\\member.txt");
	ArrayList<Member> arr = new ArrayList<Member>();
	public ArrayList<Member> selectAll(){
		BufferedReader br;
		String str;
		Member m = new Member();
		try {
			br = new BufferedReader(new FileReader(file));
			
			try {
				while((str = br.readLine())!=null) {
					String[] sArr = str.split(" ");
					m.setId(sArr[0]);
					m.setPwd(sArr[1]);
					m.setName(sArr[2]);
					m.setManager(Boolean.parseBoolean(sArr[3]));
					arr.add(m);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		return arr;
	}
	

	public void enroll(Member m) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
			bw.write(m.toString());;	
			bw.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean checkId(String id) {
		ArrayList<Member> mArr = selectAll();
		for(int i = 0 ; i< mArr.size() ; i++) {
			if(mArr.get(i).getId().equals(id)) {
				return false;
			}
		}
		return true;
	}
}
