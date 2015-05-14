package uk.co.boombastech.repository.search;

import java.util.Iterator;
import java.util.List;

public class  SearchResult<T> implements Iterable<T> {
	private List<T> results;

	public SearchResult(List<T> results) {
		this.results = results;
	}

	public int resultCount() {
		return results.size();
	}

	public boolean isUniqueResult() {
		return resultCount() == 1;
	}

	@Override
	public Iterator<T> iterator() {
		return results.iterator();
	}

	public T getFirst () {
		return results.get(0);
	}
}