package uk.co.boombastech.repository.search.ebean;

import com.avaje.ebean.ExpressionList;
import uk.co.boombastech.repository.search.SearchCriteria;
import uk.co.boombastech.repository.search.comparisons.Comparison;
import uk.co.boombastech.repository.search.comparisons.ComparisonType;
import uk.co.boombastech.repository.search.comparisons.InvalidComparisonTypeException;

import java.util.List;

public class SearchCriteriaEbean {

	public <T> ExpressionList<T> convertSearchCriteria(ExpressionList<T> expressionList, SearchCriteria<T> searchCriteria) throws InvalidComparisonTypeException {
		for (String field : searchCriteria.getCriterion().keySet()) {
			List<Comparison> comparisons = searchCriteria.getCriterion().get(field);

			for (Comparison comparison : comparisons) {
				switch (comparison.getComparisonType()) {
					case equalTo:
						expressionList.eq(field, comparison.getValue());
						break;
					case lessThan:
						expressionList.lt(field, comparison.getValue());
						break;
					case greaterThan:
						expressionList.gt(field, comparison.getValue());
						break;
					case in:
						expressionList.in(field, comparison.getValue());
						break;
					case invalidComparison:
						throw new InvalidComparisonTypeException(ComparisonType.invalidComparison);
				}
			}
		}

		return expressionList;
	}
}