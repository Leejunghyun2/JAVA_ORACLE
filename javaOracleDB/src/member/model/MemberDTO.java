package member.model;

import java.sql.Date;
import java.util.Scanner;

public class MemberDTO {
	private int memberNO;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberJumin;
	private String memberPhone;
	private String memberEmail;
	private String memberAddress;
	private Date regiDate;

	public void inputData(String gubun) {
		Scanner sc = new Scanner(System.in);
		if (gubun.equals("view") || gubun.equals("sujung") || gubun.equals("sakje")) {
			String msg = "상세보기";
			if (gubun.equals("sujung")) {
				msg = "수정";
			} else if (gubun.equals("sakje")) {
				msg = "삭제";
			}
			System.out.print(msg + "할 번호 : ");
			String choice = sc.nextLine();
			this.memberNO = Integer.parseInt(choice);
		}

		if (gubun.equals("chuga") || gubun.equals("sujung")) {
			if (gubun.equals("chuga")) {
				System.out.print("아이디 : ");
				this.memberId = sc.nextLine();
				System.out.print("비번 : ");
				this.memberPw = sc.nextLine();
			}
			System.out.print("이름 : ");
			this.memberName = sc.nextLine();
			if (gubun.equals("chuga")) {
				System.out.print("주민번호 : ");
				this.memberJumin = sc.nextLine();
			}
			System.out.print("전화번호 : ");
			this.memberPhone = sc.nextLine();
			System.out.print("이메일 : ");
			this.memberEmail = sc.nextLine();
			System.out.print("주소 : ");
			this.memberAddress = sc.nextLine();
		}
	}

	public void displayAll() {
		System.out.printf("%s\t%s\t%s\t%s\t%s\t\n", memberNO, memberId, memberName, memberPhone, regiDate);
	}

	public void displayOne() {
		String msg = "";
		msg += memberNO + "\t";
		msg += memberId + "\t";
		msg += memberName + "\t";
		msg += memberEmail + "\t";
		msg += memberPhone + "\t";
		msg += memberAddress + "\t";
		msg += memberJumin + "\t";
		msg += regiDate;
		System.out.println(msg);
	}

	public int getMemberNO() {
		return memberNO;
	}

	public void setMemberNO(int memberNO) {
		this.memberNO = memberNO;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberJumin() {
		return memberJumin;
	}

	public void setMemberJumin(String memberJumin) {
		this.memberJumin = memberJumin;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public Date getRegiDate() {
		return regiDate;
	}

	public void setRegiDate(Date regiDate) {
		this.regiDate = regiDate;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
