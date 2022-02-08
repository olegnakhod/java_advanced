package academy.lgs.domain;

import java.util.Date;
import java.util.Objects;

public class Bucket {
	private Integer bucketId;
	private Integer userId;
	private Integer articleId;
	private Date purchaseDate;
	
	public Bucket(Integer id, Integer usersId, Integer articlesId, Date purchaseDate) {
		super();
		this.bucketId = id;
		this.userId = usersId;
		this.articleId = articlesId;
		this.purchaseDate = purchaseDate;
	}
	
	public Bucket(Integer userId, Integer articleId, Date purchaseDate) {
		this.userId = userId;
		this.articleId = articleId;
		this.purchaseDate = purchaseDate;
	}

	public Integer getBucketId() {
		return bucketId;
	}

	public void setBucketId(Integer id) {
		this.bucketId = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public Date getDate() {
		return purchaseDate;
	}

	public void setDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(articleId, bucketId, purchaseDate, userId);
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
		return Objects.equals(articleId, other.articleId) && Objects.equals(bucketId, other.bucketId)
				&& Objects.equals(purchaseDate, other.purchaseDate) && Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "Bucket [id=" + bucketId + ", usersId=" + userId + ", articlesId=" + articleId + ", purchaseDate="
				+ purchaseDate + "]";
	}
	
	
	
	
}
