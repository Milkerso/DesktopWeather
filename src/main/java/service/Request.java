package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Request {
	public static String CITY;
	
	private static String getRawJson(final String whereUrl) {
		StringBuilder result = null;
		String line;
		URL url;
		URLConnection conn;
		BufferedReader in = null;

		try {
			url = new URL(whereUrl);
			conn = url.openConnection();
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			result = new StringBuilder();
			while ((line = in.readLine()) != null) {
				result.append(line);
			}

		} catch (MalformedURLException ex) {
			System.err.println(ex);
		} catch (IOException ex) {
			System.err.println(ex);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException ex) {
					System.err.println(ex);
				}
			}
		}

		return result != null ? result.toString() : null;
	}

	public static String getRawWeather(String WeatherUrl) {
		return getRawJson(WeatherUrl);
	}

}
