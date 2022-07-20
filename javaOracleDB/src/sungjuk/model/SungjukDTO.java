package sungjuk.model;

import java.sql.Date;
import java.util.Scanner;

public class SungjukDTO {
	private int sungjukNo;
	private String sungjukName;
	private int kor, eng, mat, tot;
	private double avg;
	private String grade;

	public void input(String gubun) {

		Scanner sc = new Scanner(System.in);
		if (gubun.equals("view") || gubun.equals("sujung") || gubun.equals("sakje")) {
			String msg = "상세보기";
			if(gubun.equals("sujung")) {
				msg = "수정";
			} else if(gubun.equals("sakje")) {
				msg = "삭제";
			}
			System.out.print(msg +" 할 no: ");
			String no_ = sc.nextLine();
			this.sungjukNo = Integer.parseInt(no_);
		}
		if (gubun.equals("chuga") || gubun.equals("sujung")) {
			if (gubun.equals("chuga")) {
				System.out.print("이름 : ");
				this.sungjukName = sc.nextLine();
			}

			System.out.print("국어 : ");
			String kor = sc.nextLine();
			this.kor = Integer.parseInt(kor);

			System.out.print("영어 : ");
			String eng = sc.nextLine();
			this.eng = Integer.parseInt(eng);

			System.out.print("수학 : ");
			String mat = sc.nextLine();
			this.mat = Integer.parseInt(mat);
		}

	}

	public void sum() {
		tot = kor + eng + mat;
	}

	public void avg() {
		this.avg = Math.round(this.tot / 3.0 * 1000) / 1000.0;

	}

	public void grade() {
		grade = "가";
		if (avg >= 90) {
			grade = "수";
		} else if (avg >= 80) {
			grade = "우";
		} else if (avg >= 70) {
			grade = "미";
		} else if (avg >= 60) {
			grade = "양";
		}
	}

	public void display() {
		String msg = "";
		msg += sungjukNo + "\t";
		msg += sungjukName + "\t";
		msg += kor + "\t";
		msg += eng + "\t";
		msg += mat + "\t";
		msg += tot + "\t";
		msg += avg + "\t";
		msg += grade + "\t";
		msg += regiDate;
		System.out.println(msg);
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	private Date regiDate;

	public int getSungjukNo() {
		return sungjukNo;
	}

	public void setSungjukNo(int sungjukNo) {
		this.sungjukNo = sungjukNo;
	}

	public String getSungjukName() {
		return sungjukName;
	}

	public void setSungjukName(String sungjukName) {
		this.sungjukName = sungjukName;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public Date getRegiDate() {
		return regiDate;
	}

	public void setRegiDate(Date regiDate) {
		this.regiDate = regiDate;
	}

}
