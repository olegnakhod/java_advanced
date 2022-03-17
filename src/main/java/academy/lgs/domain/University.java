package academy.lgs.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class University {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
	@Column(name = "level_acreditation")
	private Integer levelAcreditation;
	
	@Column(name = "quantity_instituts")
	private Integer quantityInstituts;
	
	@Column(name = "quantity_students")
	private Integer quantityStudents;
	
	@Column
	private String adress;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getLevelAcreditation() {
		return levelAcreditation;
	}
	public void setLevelAcreditation(Integer levelAcreditation) {
		this.levelAcreditation = levelAcreditation;
	}
	public Integer getQuantityInstituts() {
		return quantityInstituts;
	}
	public void setQuantityInstituts(Integer quantityInstituts) {
		this.quantityInstituts = quantityInstituts;
	}
	public Integer getQuantityStudents() {
		return quantityStudents;
	}
	public void setQuantityStudents(Integer quantityStudents) {
		this.quantityStudents = quantityStudents;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	@Override
	public int hashCode() {
		return Objects.hash(adress, id, levelAcreditation, name, quantityInstituts, quantityStudents);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		University other = (University) obj;
		return Objects.equals(adress, other.adress) && Objects.equals(id, other.id)
				&& Objects.equals(levelAcreditation, other.levelAcreditation) && Objects.equals(name, other.name)
				&& Objects.equals(quantityInstituts, other.quantityInstituts)
				&& Objects.equals(quantityStudents, other.quantityStudents);
	}
	@Override
	public String toString() {
		return "University [name=" + name + ", levelAcreditation=" + levelAcreditation + ", quantityInstituts="
				+ quantityInstituts + ", quantityStudents=" + quantityStudents + ", adress=" + adress + "]";
	}
	
	
	
}
