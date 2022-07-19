package member.proc;

import java.util.ArrayList;

import member.model.MemberDAO;
import member.model.MemberDTO;

public class ExampleList {
	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		
		ArrayList<MemberDTO> list = dao.getSelectAll();
		
		for(int i=0; i<list.size(); i++) {
			MemberDTO tmp = list.get(i);
			
			System.out.println("memberNO : " + tmp.getMemberNO());
			System.out.println("memberId : " + tmp.getMemberId());
			System.out.println("memberName : " + tmp.getMemberName());
			System.out.println("memberPhone : " + tmp.getMemberPhone());
			System.out.println("regiDate : " + tmp.getRegiDate());
			System.out.println("------------------------------------------------");
		}
	}
}
