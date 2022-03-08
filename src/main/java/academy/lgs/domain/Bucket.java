package academy.lgs.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table (name = "bucket")
public class Bucket {
	@Id
	@Column
	private String id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "article_id", referencedColumnName = "id")
	private Article article;
	
	@Column(name = "purchase_date")
	private Date purchaseDate;
	
	public Bucket() {}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Date getDate() {
		return purchaseDate;
	}

	public void setDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(article, id, purchaseDate, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bucket other = (Bucket) obj;
		return Objects.equals(article, other.article) && Objects.equals(id, other.id)
				&& Objects.equals(purchaseDate, other.purchaseDate) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Bucket [id=" + id + ", user=" + user + ", article=" + article + ", purchaseDate=" + purchaseDate + "]";
	}

	
	
	
	
}
