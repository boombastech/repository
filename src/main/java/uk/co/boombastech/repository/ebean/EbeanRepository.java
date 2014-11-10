package uk.co.boombastech.repository.ebean;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.ExpressionList;
import uk.co.boombastech.repository.Repository;
import uk.co.boombastech.repository.search.SearchCriteria;
import uk.co.boombastech.repository.search.ebean.SearchCriteriaEbean;

import java.util.List;

public class EbeanRepository<T> implements Repository<T> {

	private final EbeanServer ebeanServer;

	public EbeanRepository(EbeanServer ebeanServer) {
		this.ebeanServer = ebeanServer;
	}

	@Override
	public T create(T item) {
		ebeanServer.save(item);
		return item;
	}

	@Override
	public List<T> retrieve(SearchCriteria searchCriteria) {
		SearchCriteriaEbean searchCriteriaEbean = new SearchCriteriaEbean();
		ExpressionList<T> expressionList = ebeanServer.find(searchCriteria.getItemClass()).where();
		ExpressionList<T> populatedExpressionList = searchCriteriaEbean.convertSearchCriteria(expressionList, searchCriteria);
		return populatedExpressionList.findList();
	}

	@Override
	public T update(T item) {
		ebeanServer.save(item);
		return item;
	}

	@Override
	public void delete(T item) {
		ebeanServer.delete(item);
	}
}