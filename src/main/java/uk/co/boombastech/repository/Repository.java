package uk.co.boombastech.repository;

import uk.co.boombastech.repository.search.SearchCriteria;

import java.util.List;

public interface Repository<T> {
	T create(T item);
	List<T> retrieve(SearchCriteria searchCriteria);
	T update(T item);
	void delete(T item);
}