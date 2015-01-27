package uk.co.boombastech.repository.ebean;

import com.avaje.ebean.EbeanServer;
import uk.co.boombastech.repository.Repository;
import uk.co.boombastech.repository.search.ebean.SearchCriteriaEbean;

import javax.inject.Inject;

public class EbeanRepository<T> extends EbeanImmutableRepository<T> implements Repository<T> {

	@Inject
	public EbeanRepository(EbeanServer ebeanServer, SearchCriteriaEbean searchCriteriaEbean) {
		super(ebeanServer, searchCriteriaEbean);
	}

	@Override
	public T create(T item) {
		ebeanServer.save(item);
		return item;
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