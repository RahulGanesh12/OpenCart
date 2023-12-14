package com.qa.opencart.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringUtilsClass {
	public static String randomAlphabeticString() {
		String val = RandomStringUtils.randomAlphabetic(10);
		return val;
	}

	public static String randomAlphaNumericString() {
		String val = RandomStringUtils.randomAlphanumeric(10);
		return val;
	}

	public static String randomEmailGenerator() {
		String val1 = randomAlphabeticString().substring(0, 4);
		String val2 = randomAlphaNumericString().substring(0, 4);
		String val3 = val1 + val2 + "@gmail.com";
		return val3;
	}

	public static String randomPasswordGenerator() {
		String val1 = randomAlphabeticString().substring(0, 2).toUpperCase();
		String val2 = randomAlphaNumericString().substring(0, 3);
		return val1 + val2 + "@$%";
	}
}
