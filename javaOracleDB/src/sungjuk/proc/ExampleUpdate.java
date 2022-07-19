package sungjuk.proc;

import java.util.Scanner;

import sungjuk.model.SungjukDAO;
import sungjuk.model.SungjukDTO;

public class ExampleUpdate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("성적변경할 번호를 입력하세요 :");
		String no_ = sc.nextLine();
		System.out.print("변경할 국어점수를 입력하세요 :");
		String kor_ = sc.nextLine();
		System.out.print("변경할 영어점수를 입력하세요 :");
		String eng_ = sc.nextLine();
		System.out.print("변경할 수학점수를 입력하세요 :");
		String mat_ = sc.nextLine();
		
		int no = Integer.parseInt(no_);
		int kor = Integer.parseInt(kor_);
		int eng = Integer.parseInt(eng_);
		int mat = Integer.parseInt(mat_);
		int tot = kor + eng + mat;
		double avg = tot/3;
		String grade = "가";
		if (avg >= 90) {
			grade = "수";
		} else if (avg >= 80) {
			grade = "우";
		} else if (avg >= 70) {
			grade = "미";
		} else if (avg >= 60) {
			grade = "양";
		}
		
		
		SungjukDTO dto = new SungjukDTO();
		dto.setSungjukNo(no);
		dto.setKor(kor);
		dto.setEng(eng);
		dto.setMat(mat);
		dto.setTot(tot);
		dto.setAvg(avg);
		dto.setGrade(grade);
		
		SungjukDAO dao = new SungjukDAO();
		if(dao.setUpdate(dto) > 0 ) {
			System.out.println("== UPDATE 성공 ==");
		} else {
			System.out.println("== UPDATE 실패 ==");
		}
	}
}
