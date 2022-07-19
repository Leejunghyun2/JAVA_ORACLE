package sungjuk.proc;

import java.util.Scanner;

import sungjuk.model.SungjukDAO;
import sungjuk.model.SungjukDTO;

public class ExampleView {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("상세보기할 번호를 입력하세요 :");
		String no_ = sc.nextLine();
		int no = Integer.parseInt(no_);
		
		SungjukDTO dto = new SungjukDTO();
		dto.setSungjukNo(no);
		
		SungjukDAO dao = new SungjukDAO();
		dto = dao.getSelectOne(dto);
		
		System.out.println("NO " +dto.getSungjukNo());
		System.out.println("이름 : " +dto.getSungjukName());
		System.out.println("국어 : " +dto.getKor());
		System.out.println("영어 : " +dto.getEng());
		System.out.println("수학 : " +dto.getMat());
		System.out.println("총점 : " +dto.getTot());
		System.out.println("평균 : " +dto.getAvg());
		System.out.println("등급 : " +dto.getGrade());
		System.out.println("날짜 : " +dto.getRegiDate());
	}
}
