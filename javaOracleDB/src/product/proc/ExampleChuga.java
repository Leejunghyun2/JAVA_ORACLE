package product.proc;

import java.util.Scanner;

import product.model.ProductDAO;
import product.model.ProductDTO;

public class ExampleChuga {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("상품이름 : ");
		String productName = sc.nextLine();
		System.out.print("상품가격 : ");
		String productPrice_ = sc.nextLine();
		System.out.print("상품설명 : ");
		String productContent = sc.nextLine();
		System.out.print("제조사 : ");
		String vender = sc.nextLine();
		
		int productPrice = Integer.parseInt(productPrice_);
		
		ProductDTO dto = new ProductDTO();
		dto.setProductName(productName);
		dto.setProductPrice(productPrice);
		dto.setProductContent(productContent);
		dto.setVender(vender);
		
		ProductDAO dao = new ProductDAO();
		if(dao.setInsert(dto)>0) {
			System.out.println("== INSERT 완료 ==");
		} else {
			System.out.println("== INSERT 실패 ==");
		}
	}

}
