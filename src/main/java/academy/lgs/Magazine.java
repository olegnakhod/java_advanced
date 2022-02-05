package academy.lgs;

public class Magazine {
	
	private static int id = 0;
	private String name;
	private int price;
	
	public Magazine(String name, int price) {
		id++;
		this.name = name;
		this.price = price;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Magazine.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int  price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Magazine [name=" + name + ", price=" + price + "]";
	}
}
