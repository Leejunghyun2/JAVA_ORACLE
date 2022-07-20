package member.proc;

import java.util.ArrayList;
import java.util.Scanner;

import member.model.MemberDAO;
import member.model.MemberDTO;

public class Example {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("회원관리메뉴선택(1:목록, 2:상세보기, 3:추가, 4:수정, 5:삭제 기타:종료\n==> ");
			String choice = sc.nextLine();

			MemberDAO dao = new MemberDAO();
			MemberDTO dto = new MemberDTO();
			switch (choice) {
			case "1":
				ArrayList<MemberDTO> list = dao.getSelectAll();
				for(int i=0; i<list.size();i++) {
					dto = list.get(i);
					dto.displayAll();
				}
				break;
			case "2":
				dto.inputData("view");
				dto = dao.getSelectOne(dto);
				if(dto.getMemberNO()!=0) {
				dto.displayOne();
				}else {
					System.out.println("조회할 데이터가 없습니다.");
				}
				break;
			case "3":
				dto.inputData("insert");
				if(dao.setInsert(dto)>0) {
					System.out.println("== success INSERT ==");
				} else {
					System.out.println("== fail INSERT ==");
				}
				break;
			case "4":
				dto.inputData("sujung");
				if(dao.setUpdate(dto)>0) {
					System.out.println("== success UPDATE ==");
				}else {
					System.out.println("== fail UPDATE ==");
				}
				break;
			case "5":
				dto.inputData("sakje");
				if(dao.setDelete(dto)>0) {
					System.out.println("== success DELETE ==");
				}else {
					System.out.println("== fail DELETE ==");
				}
				break;
			default:
				return;
			}

		}
	}
}
