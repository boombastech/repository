package uk.co.boombastech.repository.ebean;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.ExpressionList;
import uk.co.boombastech.repository.ImmutableRepository;
import uk.co.boombastech.repository.search.SearchCriteria;
import uk.co.boombastech.repository.search.SearchResult;
import uk.co.boombastech.repository.search.comparisons.InvalidComparisonTypeException;
import uk.co.boombastech.repository.search.ebean.SearchCriteriaEbean;

import javax.inject.Inject;
import java.util.List;

public class EbeanImmutableRepository<T> implements ImmutableRepository<T> {

	protected final EbeanServer ebeanServer;
	private final SearchCriteriaEbean searchCriteriaEbean;

	@Inject
	public EbeanImmutableRepository(EbeanServer ebeanServer, SearchCriteriaEbean searchCriteriaEbean) {
		this.ebeanServer = ebeanServer;
		this.searchCriteriaEbean = searchCriteriaEbean;
	}

	@Override
	public SearchResult<T> retrieve(SearchCriteria<T> searchCriteria) throws InvalidComparisonTypeException {
		ExpressionList<T> expressionList = ebeanServer.find(searchCriteria.getItemClass()).where();
		ExpressionList<T> populatedExpressionList = searchCriteriaEbean.convertSearchCriteria(expressionList, searchCriteria);
		List<T> list = populatedExpressionList.findList();
		return new SearchResult<T>(list);
	}
}