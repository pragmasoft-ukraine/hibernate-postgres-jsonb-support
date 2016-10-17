package ua.com.pragmasoft.hibernate.jsonb.model;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
public class MainEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	private String name;

	@Type(type = "json")
	@Column(columnDefinition = "json")
	private SubEntity subEntity;
	@Type(type = "jsonb")
	@Column(columnDefinition = "jsonb")
	private List<SubEntity> subEntityList;

	public Integer getId() {
		return id;
	}

	public MainEntity setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public MainEntity setName(String name) {
		this.name = name;
		return this;
	}

	public SubEntity getSubEntity() {
		return subEntity;
	}

	public MainEntity setSubEntity(SubEntity subEntity) {
		this.subEntity = subEntity;
		return this;
	}

	public List<SubEntity> getSubEntityList() {
		return subEntityList;
	}

	public MainEntity setSubEntityList(List<SubEntity> subEntityList) {
		this.subEntityList = subEntityList;
		return this;
	}

	@Override
	public String toString() {
		return "MainEntity{" +
			"id=" + id +
			", name='" + name + '\'' +
			", subEntity=" + subEntity +
			", subEntityList=" + subEntityList +
			'}';
	}
}
