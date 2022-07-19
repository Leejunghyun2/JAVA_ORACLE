package sungjuk.proc;

import java.util.ArrayList;

import sungjuk.model.SungjukDAO;
import sungjuk.model.SungjukDTO;

public class ExampleList {
	public static void main(String[] args) {
		SungjukDAO dao = new SungjukDAO();
		
		ArrayList<SungjukDTO> list = dao.getSelectAll();
		
		for(int i=0; i<list.size(); i++) {
			SungjukDTO tmp = list.get(i);
			
			System.out.println("No :" + tmp.getSungjukNo());
			System.out.println("Name :" + tmp.getSungjukName());
			System.out.println("Avg :" + tmp.getAvg());
			System.out.println("Grade :" + tmp.getGrade());
			System.out.println("regiDate :" + tmp.getRegiDate());
			System.out.println("-------------------------------------");
		}
		
	}
}
