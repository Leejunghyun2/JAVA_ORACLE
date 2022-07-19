package member.proc;


import java.util.Scanner;

import member.model.MemberDAO;
import member.model.MemberDTO;

public class ExampleView {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("상세보기할 회원번호를 입력하세요 : ");
		int memberNo = Integer.parseInt(sc.nextLine());
		
		MemberDTO dto = new MemberDTO();
		dto.setMemberNO(memberNo);
		
		MemberDAO dao = new MemberDAO();
		dto = dao.getSelectOne(dto);
		if(dto.getMemberId()!=null) {
	    System.out.println(dto.getMemberId());
	    System.out.println(dto.getMemberName());
	    System.out.println(dto.getMemberPhone());
	    System.out.println(dto.getMemberJumin());
	    System.out.println(dto.getMemberEmail());
	    System.out.println(dto.getMemberAddress());
	    System.out.println(dto.getRegiDate());
		} else {
			System.out.println("회원 목록이 존재하지 않습니다.");
		}
		
	}
}
