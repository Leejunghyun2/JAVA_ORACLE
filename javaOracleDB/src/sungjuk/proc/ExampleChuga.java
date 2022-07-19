package sungjuk.proc;

import java.util.Scanner;

import sungjuk.model.SungjukDAO;
import sungjuk.model.SungjukDTO;

public class ExampleChuga {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요 :");
		String name = sc.nextLine();
		System.out.print("국어점수를 입력하세요 :");
		String kor_ = sc.nextLine();
		System.out.print("영어점수를 입력하세요 :");
		String eng_ = sc.nextLine();
		System.out.print("수학점수를 입력하세요 :");
		String mat_ = sc.nextLine();

		int kor = Integer.parseInt(kor_);
		int eng = Integer.parseInt(eng_);
		int mat = Integer.parseInt(mat_);
		int tot = kor + eng + mat;
		double avg = tot / 3;
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
		sc.close();
		SungjukDTO dto = new SungjukDTO();
		dto.setSungjukName(name);
		dto.setKor(kor);
		dto.setEng(eng);
		dto.setMat(mat);
		dto.setTot(tot);
		dto.setAvg(avg);
		dto.setGrade(grade);

		SungjukDAO dao = new SungjukDAO();
		if(dao.setInsert(dto) > 0) {
			System.out.println("== insert 성공 ==");
		} else {
			System.out.println("== insert 실패 ==");
		}
	}
}
