package com.bharath.spring.springcoreniki.properties;

import java.util.Properties;

public class CountriesAndLanguages {

	private Properties countryAngLangs;

	@Override
	public String toString() {
		return "CountriesAndLanguages [countryAngLangs=" + countryAngLangs + "]";
	}

	public Properties getCountryAngLangs() {
		return countryAngLangs;
	}

	public void setCountryAngLangs(Properties countryAngLangs) {
		this.countryAngLangs = countryAngLangs;
	}
}
