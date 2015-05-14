package uk.co.boombastech.repository.search.comparisons;

public class InvalidComparisonTypeException extends RuntimeException {
	private final ComparisonType comparisonType;

	public InvalidComparisonTypeException(ComparisonType comparisonType) {
		this.comparisonType = comparisonType;
	}

	public ComparisonType getComparisonType() {
		return comparisonType;
	}

	@Override
	public synchronized Throwable fillInStackTrace() {
		return this;
	}
}