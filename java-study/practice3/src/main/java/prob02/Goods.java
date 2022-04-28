package prob02;

public class Goods {
<<<<<<< HEAD
		public String getDrink() {
		return drink;
	}
	public void setDrink(String drink) {
		this.drink = drink;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
		private String drink;
		private int price;
		private int stock;

	
	

=======
	private String name;
	private int price;
	private int count;
	
	public Goods(String name, int price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}
	
	public void display() {
		System.out.println(
				name + "(가격:" + price + "원)이 " + count + "개 입고 되었습니다."
				);
	}
>>>>>>> branch 'main' of https://github.com/seoin1102/java-study.git
}
