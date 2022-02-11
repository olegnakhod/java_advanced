package academy.lgs.domain;

import java.util.Objects;

public class Article {
	private Integer articleId;
	private String name;
	private Double price;
	private String description;
	
	public Article(Integer id, String name, Double price, String description) {
		this.articleId = id;
		this.name = name;
		this.price = price;
		this.description = description;
	}
	
	public Article(String name, Double price, String description) {
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer id) {
		this.articleId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, articleId, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		return Objects.equals(description, other.description) && Objects.equals(articleId, other.articleId)
				&& Objects.equals(name, other.name) && Objects.equals(price, other.price);
	}

	@Override
	public String toString() {
		return "Articles [id=" + articleId + ", name=" + name + ", price=" + price + ", description=" + description + "]";
	}
	
}
