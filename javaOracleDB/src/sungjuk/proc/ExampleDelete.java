package sungjuk.proc;

import java.util.Scanner;

import sungjuk.model.SungjukDAO;
import sungjuk.model.SungjukDTO;

public class ExampleDelete {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 번호를 입력하세요 :");
		String no_ = sc.nextLine();
		int no = Integer.parseInt(no_);
		
		SungjukDTO dto = new SungjukDTO();
		dto.setSungjukNo(no);
		
		SungjukDAO dao = new SungjukDAO();
		if(dao.setDelete(dto)>0) {
			System.out.println("== DELETE 성공 == ");
		} else {
			System.out.println("== DELETE 실패 == ");
		}

	}
}
