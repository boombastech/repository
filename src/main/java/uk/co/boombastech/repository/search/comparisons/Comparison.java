package uk.co.boombastech.repository.search.comparisons;

public abstract class Comparison<T> {

	private final String field;
	private final T value;

	public Comparison(String field, T value) {
		this.field = field;
		this.value = value;
	}

	public String getField() {
		return field;
	}

	public T getValue() {
		return value;
	}
}