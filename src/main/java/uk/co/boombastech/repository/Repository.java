package uk.co.boombastech.repository;

import uk.co.boombastech.repository.search.SearchCriteria;
import uk.co.boombastech.repository.search.comparisons.InvalidComparisonTypeException;

import java.util.List;

public interface Repository<T> extends ImmutableRepository<T> {
	T create(T item);
	T update(T item);
	void delete(T item);
}