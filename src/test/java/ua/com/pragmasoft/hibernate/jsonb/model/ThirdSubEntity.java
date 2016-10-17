package ua.com.pragmasoft.hibernate.jsonb.model;

public class ThirdSubEntity extends SubEntity {

	private Integer value;

	public Integer getValue() {
		return value;
	}

	public ThirdSubEntity setValue(Integer value) {
		this.value = value;
		return this;
	}
}
