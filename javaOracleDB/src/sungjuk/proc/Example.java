package sungjuk.proc;

import java.util.ArrayList;
import java.util.Scanner;

import sungjuk.model.SungjukDAO;
import sungjuk.model.SungjukDTO;

public class Example {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("성적관리메뉴선택(1:목록, 2:상세, 3:추가, 4:수정, 5:삭제, 기타:종료)\n==> ");
			String menu = sc.nextLine();

			if (menu.equals("1")) {
				SungjukDAO dao = new SungjukDAO();
				ArrayList<SungjukDTO> list = dao.getSelectAll();
				
				for(int i = 0; i < list.size(); i++) {
					SungjukDTO dto = list.get(i);
					dto.display();
				}
				
				
			} else if (menu.equals("2")) {
				SungjukDTO dto = new SungjukDTO();
				dto.input("view");
				
				SungjukDAO dao = new SungjukDAO();
				dto = dao.getSelectOne(dto);
				dto.display();

			} else if (menu.equals("3")) {
				SungjukDTO dto = new SungjukDTO();
				dto.input("chuga");
				dto.sum();
				dto.avg();
				dto.grade();

				SungjukDAO dao = new SungjukDAO();
				int result = dao.setInsert(dto);

			} else if (menu.equals("4")) {
				SungjukDTO dto = new SungjukDTO();
				dto.input("sujung");
				dto.sum();
				dto.avg();
				dto.grade();
				SungjukDAO dao = new SungjukDAO();
				int result = dao.setUpdate(dto);

			} else if (menu.equals("5")) {
				SungjukDTO dto = new SungjukDTO();
				dto.input("sakje");
				SungjukDAO dao = new SungjukDAO();
				dao.setDelete(dto);

			} else {
				break;
			}
		}
		System.out.println("== 프로그램 종료 ==");

	}
}
