package program;

import java.util.Scanner;

public class Program {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("프로그램선택 : 1:회원관리, 2:상품관리, 3:성적관리 기타:프로그램종료");
			String choice = sc.nextLine();
			switch (choice) {
			case "1":
				member.proc.Example.main(args);
				break;
			case "2":
				product.proc.Example.main(args);
				break;
			case "3":
				sungjuk.proc.Example.main(args);
				break;
			default:
				return;
			}
		}

	}

}
