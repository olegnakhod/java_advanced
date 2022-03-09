package academy.lgs;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Item {

	private Integer id;
	private String total;
	private Set<Card> cards = new HashSet<>();

	public Item() {	}

	public Item(String total) {
		this.total = total;
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

	public Set<Card> getCards() {
		return cards;
	}

	public void setCards(Set<Card> cards) {
		this.cards = cards;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cards, id, total);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(cards, other.cards) && Objects.equals(id, other.id) && Objects.equals(total, other.total);
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", total=" + total + "]";
	}

}
