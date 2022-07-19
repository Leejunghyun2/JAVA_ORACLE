package member.proc;


import java.util.Scanner;

import member.model.*;

public class ExampleChuga {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디를 입력하세요. \n==>");
		String memberId = sc.nextLine();
		System.out.print("비밀번호를 입력하세요. \n==>");
		String memberPw = sc.nextLine();
		System.out.print("이름을 입력하세요. \n==>");
		String memberName = sc.nextLine();
		System.out.print("주민등록번호를 입력하세요. \n==>");
		String memberJumin = sc.nextLine();
		System.out.print("전화번호를 입력하세요.\n==>");
		String memberPhone = sc.nextLine();
		System.out.print("이메일을 입력하세요.\n==>");
		String memberEmail = sc.nextLine();
		System.out.print("주소를 입력하세요.\n==>");
		String memberAddress = sc.nextLine();
		sc.close();
		
		MemberDTO dto = new MemberDTO();
		dto.setMemberId(memberId);
		dto.setMemberPw(memberPw);
		dto.setMemberName(memberName);
		dto.setMemberJumin(memberJumin);
		dto.setMemberPhone(memberPhone);
		dto.setMemberEmail(memberEmail);
		dto.setMemberAddress(memberAddress);
		
		MemberDAO dao = new MemberDAO();
		int result = dao.setInsert(dto);
		
		if(result > 0) {
			System.out.println("== success insert ==");
		} else {
			System.out.println("== fail insert ==");
		}
	}

}
