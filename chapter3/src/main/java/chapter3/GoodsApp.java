package chapter3;

public class GoodsApp {

	public static void main(String[] args) {
		Goods goods = new Goods();

		goods.setName("nikon");
		goods.setPrice(-1);
		goods.setCountSold(50);
		goods.setCountStock(30);
		
		goods.showInfo();
		
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		System.out.println("Goods Count:" + Goods.countOfGoods );
		
		goods2.showInfo();
		goods3.showInfo();
		
		// discount price 구하기
		goods.setPrice(2000);
		int discountPrice = goods.calcDiscountPrice(0.5);
		System.out.println("Goods Discount Price:" + discountPrice);
	}
}
