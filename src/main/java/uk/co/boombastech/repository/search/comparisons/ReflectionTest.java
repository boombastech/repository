package uk.co.boombastech.repository.search.comparisons;

import java.lang.reflect.Field;

public class ReflectionTest {

	public static void main(String... args) {
		Field[] declaredFields = String.class.getDeclaredFields();
		for (Field declaredField : declaredFields) {
			Class<?> type = declaredField.getType();
		}


	}
}