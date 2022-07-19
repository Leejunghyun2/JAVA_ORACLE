package product.proc;

import java.util.Scanner;

import product.model.ProductDAO;
import product.model.ProductDTO;

public class ExampleDelete {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 상품번호를 입력하세요 : ");
		int productCode = Integer.parseInt(sc.nextLine());
		
		
		ProductDTO dto = new ProductDTO();
		dto.setProductCode(productCode);
		
		ProductDAO dao = new ProductDAO();
		if(dao.setDelete(dto)>0) {
			System.out.println("== DElETE 완료 ==");
		} else {
			System.out.println("== DELETE 실패 ==");
		}
	}
	
	
	
}
