package ua.com.pragmasoft.hibernate.jsonb.model;

public abstract class SubEntity {

	private String name;

	public String getName() {
		return name;
	}

	public SubEntity setName(String name) {
		this.name = name;
		return this;
	}
}
