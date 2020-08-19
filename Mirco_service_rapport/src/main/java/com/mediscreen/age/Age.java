package com.mediscreen.age;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Calendar;

public class Age {

	private static Calendar today = Calendar.getInstance();
	private static Calendar birthDay = Calendar.getInstance();
	private static final String formatDate = "MM/dd/yyyy";

	public static int getAge(LocalDate dateOfBirth) throws ParseException {

		int yearDiff = yearDiff(dateOfBirth);
		int monthDiff = monthDiff(dateOfBirth);
		int dayDiff = dayDiff(dateOfBirth);

		if (monthDiff >= 0 || monthDiff == 0 && dayDiff >= 0) {
			return yearDiff;
		} else {
			return yearDiff - 1;
		}

	}

	private static int yearDiff(LocalDate birthD) throws ParseException {
		int birth = birthD.getYear();
		return today.get(Calendar.YEAR) - birth;
	}

	private static int monthDiff(LocalDate birthD) throws ParseException {
		int birth = birthD.getMonthValue();
		return today.MONTH - birth;
	}

	private static int dayDiff(LocalDate birthD) throws ParseException {
		int birth = birthD.getDayOfMonth();
		return today.DAY_OF_MONTH - birth;
	}

}
