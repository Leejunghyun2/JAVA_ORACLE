package member.proc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import member.model.MemberDAO;
import member.model.MemberDTO;

public class ExampleDelete {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("삭제할 회원번호를 입력하세요 :");
		int memberNo = Integer.parseInt(sc.nextLine());
		
		int result = 0;
		
		MemberDTO dto = new MemberDTO();
		dto.setMemberNO(memberNo);
		
		MemberDAO dao = new MemberDAO();
		result =  dao.setDelete(dto);
		

		if(result > 0) {
			System.out.println("== delete 성공 ==");
		} else {
			System.out.println("== delete 실패 ==");
		}
	}
}
