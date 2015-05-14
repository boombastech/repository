package uk.co.boombastech.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class TestModel {

	@Pattern(regexp = "asdf")
	private String name;
	@Min(1)
	private int age;

	public static void main(String[] args) {
		for (Field field : TestModel.class.getDeclaredFields()) {
			for (Annotation annotation : field.getDeclaredAnnotations()) {
				if (annotation instanceof Min) {
					System.out.println(((Min) annotation).value());
				}
				if (annotation instanceof Pattern) {
					System.out.println(((Pattern) annotation).regexp());
				}
			}

		}

	}
}