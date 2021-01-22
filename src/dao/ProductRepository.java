package dao;

import java.util.ArrayList;

import dto.Product;

public class ProductRepository {

	private ArrayList<Product> listOfProduct = new ArrayList<Product>();
	
	public ProductRepository() {
		Product phone = new Product("p1234", "iPhone 6s", 800000);
		phone.setDescription("4.7-inch, 1334x750 Renina HD display, 8-megapixes iSight Camera");
		phone.setCategory("smart Phone");;
		phone.setManufacturer("Apple");
		phone.setUnitsInStock(1000);
		phone.setCondition("New");
		
		Product notebook = new Product("p1235", "LG PC 그램", 1500000);
		notebook.setDescription("13.3-inch, IPS LEF display, 5rd Generation Intel core processors");
		notebook.setCategory("NoteBook");
		notebook.setManufacturer("LG");
		notebook.setUnitsInStock(1000);
		notebook.setCondition("Refubished");
		
		Product tablet = new Product("p1236", "Galaxy Tab S", 900000);
		tablet.setDescription("212.8 * 125.6 * 6.6mm, Super AMOLED display, Octa-Core processor");
		tablet.setCategory("Tablet");
		tablet.setManufacturer("Samsung");
		tablet.setUnitsInStock(1000);
		tablet.setCondition("Old");
		
		listOfProduct.add(phone);
		listOfProduct.add(notebook);
		listOfProduct.add(tablet);
	}
	
	public ArrayList<Product> getAllProducts() {
		return listOfProduct;
	}
//	DB에 저장된 데이터 중 productId가 같은 데이터를 가져오기
//	반환 타입을 Product 클래스 타입으로 설정
	public Product getProductById(String productId) {
//		Product 클래스 타입의 변수를 미리 선언, 빈 변수
		Product productById = null;
		
//		DB에 크기 만큼 for문을 사용하여 DB 전체의 데이터 중 상품ID와 동일한 정보를 찾음
		for (int i = 0; i < listOfProduct.size(); i++) {
//			listOfProduct에 저장된 상품정보를 하나씩 꺼내어 Product 클래스 타입의
//			변수 product에 대입함
			Product product = listOfProduct.get(i);
//			비교 3번
//			product 객체가 null이 아니고,
//			product 객체가 가지고 있는 상품ID가 null이 아니며,
//			product 객체가 가지고 있는 상품ID와 매개변수로 받아온 상품 ID가 모두 동일한지 비교
			if (product != null && product.getProductId() != null && product.getProductId().equals(productId)) {
//				product 객체를 for문 외부에 있는 Product 클래스 타입의 변수 productById
//				객체에 대입함
				productById = product;
				break; // for문 정지
			}
		}
		
		return productById;
	}
}
