package core;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

public class JsonParsing {

	private static final String GEOPLUGIN_BASE_URL = "http://www.geoplugin.net/json.gp?ip=";
	private static final String CURRENCYCONVERTER_BASE_URL = "http://free.currencyconverterapi.com/api/v6/convert?q=";

	public static Geoplugin getGeoplugin(String ip) {

		Geoplugin geoplugin = null;
		try {
			Reader reader = new InputStreamReader(new URL(GEOPLUGIN_BASE_URL + ip).openStream());
			Gson gson = new Gson();
			geoplugin = gson.fromJson(reader, Geoplugin.class);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return geoplugin;
	}

	public static Double getRate(String currency) {
		Double rate = null;
		String pairCodeKey = "USD_" + currency;
		String url = CURRENCYCONVERTER_BASE_URL + pairCodeKey + "&compact=y";
		JSONParser parser = new JSONParser();

		try {
			Reader reader = new InputStreamReader(new URL(url).openStream());
			JSONObject currencyconverterJson = (JSONObject) parser.parse(reader);
			JSONObject root = (JSONObject) currencyconverterJson.get(pairCodeKey);
			rate = ((Double) root.get("val"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return rate;
	}
}
