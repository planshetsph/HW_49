package core;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Main {

	private static final String URL = "https://www.amazon.com/dp/B01LTHXAOA/ref=dp_cerb_2";
	private static final String[] IPs = new String[] { IP.FRANCE, IP.CHINA, IP.UNITED_KINGDOM, IP.UKRAINE, IP.RUSSIA };
	private static String productTitle;
	private static String originalPrice;

	public static void main(String[] args) {
		Logger.getLogger("").setLevel(Level.OFF);

		WebDriver driver = Browser.getChrome();
		driver.get(URL);

		productTitle = driver.findElement(By.id("productTitle")).getText();
		originalPrice = driver.findElement(By.id("priceblock_ourprice")).getText().replace("$", "").replace(",", "");
		driver.quit();

		Geoplugin geoplugin;
		double countryPriceDouble, countryPriceFormated;

		for (String ip : IPs) {
			geoplugin = JsonParsing.getGeoplugin(ip);
			countryPriceDouble = Double.valueOf(originalPrice) * JsonParsing.getRate(geoplugin.geopluginCurrencyCode);
			String countryPrice = String.valueOf(countryPriceDouble);
			countryPriceFormated = new BigDecimal(countryPrice).setScale(2, RoundingMode.HALF_UP).doubleValue();
			countryPrice = String.valueOf(countryPriceFormated);
			print(geoplugin.geopluginCurrencySymbol, geoplugin.geopluginCountryName, countryPrice);
		}

	}

	private static void print(String currencySymbol, String countryName, String countryPrice) {
		System.out.println("Item: " + productTitle + "; US Price: $" + originalPrice + "; for country: " + countryName
				+ "; Local Price: " + currencySymbol + " " + countryPrice);
	}

}
