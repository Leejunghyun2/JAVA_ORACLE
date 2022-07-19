package example.exam11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Student> list = new ArrayList<Student>();

		 for(int i=0; i<3; i++) {
			 Student stu = new Student();
			 stu.inputData();
			list.add(stu);
		 }
			
			for(int i=0;i<list.size();i++) {
				System.out.println(list.get(i));
			
			}
			System.out.println(list.size());
			
			
			
			
			
			
		
	}
}
