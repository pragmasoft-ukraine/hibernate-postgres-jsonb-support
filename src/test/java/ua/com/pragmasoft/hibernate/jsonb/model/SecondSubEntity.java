package ua.com.pragmasoft.hibernate.jsonb.model;

public class SecondSubEntity extends SubEntity {

	private Double dValue;

	public Double getdValue() {
		return dValue;
	}

	public SecondSubEntity setdValue(Double dValue) {
		this.dValue = dValue;
		return this;
	}
}
