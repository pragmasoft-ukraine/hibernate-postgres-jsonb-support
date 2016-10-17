package ua.com.pragmasoft.hibernate.jsonb.model;

public class FirstSubEntity extends SubEntity {

	private Integer value;

	public Integer getValue() {
		return value;
	}

	public FirstSubEntity setValue(Integer value) {
		this.value = value;
		return this;
	}
}
