package academy.lgs;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Card {

	private Integer id;
	private String total;
	private String name;
	private Set<Item> items = new HashSet<>();

	public Card() {
	}

	public Card(String total, String name) {
		this.total = total;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, items, name, total);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return Objects.equals(id, other.id) && Objects.equals(items, other.items) && Objects.equals(name, other.name)
				&& Objects.equals(total, other.total);
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", total=" + total + ", name=" + name + "]";
	}
}
