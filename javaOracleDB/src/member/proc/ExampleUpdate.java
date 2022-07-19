package member.proc;

import java.util.Scanner;

import member.model.*;

public class ExampleUpdate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 회원번호 입력하세요 : ");
		String memberNo_ = sc.nextLine();
		System.out.print("수정할 아이디 입력하세요 : ");
		String memberId = sc.nextLine();
		System.out.print("수정할 이름 입력하세요 : ");
		String memberName = sc.nextLine();
		int memberNo = Integer.parseInt(memberNo_);
		MemberDTO dto = new MemberDTO();
		dto.setMemberNO(memberNo);
		dto.setMemberId(memberId);
		dto.setMemberName(memberName);
		
		MemberDAO dao = new MemberDAO();
		int result =  dao.setUpdate(dto);
		
		if(result > 0) {
			System.out.println("== 업데이트 성공 ==");
		} else {
			System.out.println("== 업데이트 실패 ==");
		}
	}
}
