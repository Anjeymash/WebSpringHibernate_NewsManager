package by.yandex.anjeymash.news.service.validation;

import java.util.Date;
import by.yandex.anjeymash.news.service.validation.ValidDates;

public final class ValidationData {
	private ValidationData() {
	}

	public static boolean validNews(String title, String brief, Date date, String content) {
		if (validString(title) && validString(brief) && validString(content) && validDate(date)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean validString(String str) {
		if (str == null || str.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean validDate(Date date) {

		if (date.getTime() > ValidDates.MAX_DATE.getTime()) //|| (date.getTime() < ValidDates.MIN_DATE.getTime())) {
			return false;
		 else {
			return true;
		}
	}
}
