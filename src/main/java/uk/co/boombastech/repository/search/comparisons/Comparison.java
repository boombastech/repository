package uk.co.boombastech.repository.search.comparisons;

public class Comparison<T> {

	private final ComparisonType comparisonType;
	private final String fieldName;
	private final T value;

	public Comparison(ComparisonType comparisonType, String fieldName, T value) {
		this.comparisonType = comparisonType;
		this.fieldName = fieldName;
		this.value = value;
	}

	public ComparisonType getComparisonType() {
		return comparisonType;
	}

	public String getFieldName() {
		return fieldName;
	}

	public T getValue() {
		return value;
	}
}