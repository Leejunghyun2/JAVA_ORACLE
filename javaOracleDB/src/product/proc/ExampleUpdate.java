package product.proc;

import java.util.Scanner;

import product.model.ProductDAO;
import product.model.ProductDTO;

public class ExampleUpdate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 상품번호를 입력하세요 : ");
		int productCode = Integer.parseInt(sc.nextLine());
		System.out.print("수정할 가격을 입력 해주세요 : ");
		int productPrice = Integer.parseInt(sc.nextLine());
		System.out.print("수정할 상세설명을 입력하세요 : ");
		String content = sc.nextLine();
		System.out.print("수정할 브랜드명을 입력하세요 :");
		String vender = sc.nextLine();
		
		ProductDTO dto = new ProductDTO();
		dto.setProductCode(productCode);
		dto.setProductPrice(productPrice);
		dto.setProductContent(content);
		dto.setVender(vender);
		
		ProductDAO dao = new ProductDAO();
		if(dao.setUpdate(dto)>0) {
			System.out.println("== UPDATE 완료 ==");
		} else {
			System.out.println("== UPDATE 실패 ==");
		}
		
		
	}
}
