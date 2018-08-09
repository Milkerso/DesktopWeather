package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import weather.Configuration;

public class check {
	
	private ResponseWeatherAdvanced now;
	private String weatherJson;

	public static void main(String[] args) {
		check chck=new check();
		chck.openService();

	}
	
public void openService() {
		
		if(Configuration.city.length()>0)
		{
		}
		else {
			Configuration.city="Warsaw";
		}
		String CITY=Configuration.city;
		final String APP_ID = "cef62a4aa44dbbdb924305751c12817d";

		final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/forecast/daily?q="+ CITY +"&units=metric&APPID=" + APP_ID+ "&cnt=5";
		final Gson gson = new GsonBuilder().create();
		weatherJson = Request.getRawWeather(WEATHER_URL);
	    now = gson.fromJson(weatherJson, ResponseWeatherAdvanced.class);
		
	    System.out.println(now.getList().get(0).getTemp().getNight());
	}
	

}
