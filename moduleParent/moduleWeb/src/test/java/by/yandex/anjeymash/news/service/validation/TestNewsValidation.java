package by.yandex.anjeymash.news.service.validation;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestNewsValidation {
	@Test
	public void testValidNews(){
		boolean result = ValidationData.validNews("", null, null, "");
		assertFalse(result);
	}
}
