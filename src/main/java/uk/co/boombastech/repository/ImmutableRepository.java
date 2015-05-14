package uk.co.boombastech.repository;

import uk.co.boombastech.repository.search.SearchCriteria;
import uk.co.boombastech.repository.search.SearchResult;
import uk.co.boombastech.repository.search.comparisons.InvalidComparisonTypeException;

public interface ImmutableRepository<T> {
	SearchResult<T> retrieve(SearchCriteria<T> searchCriteria) throws InvalidComparisonTypeException;
}