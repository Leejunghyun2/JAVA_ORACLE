package sungjuk.model;

import java.sql.Date;

public class SungjukDTO {
	private int sungjukNo;
	private String sungjukName;
	private int kor,eng,mat,tot;
	private double avg;
	private String grade;
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
