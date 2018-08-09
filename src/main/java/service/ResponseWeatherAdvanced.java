package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import service.ResponseWeather.Weather;


public class ResponseWeatherAdvanced {
	 String cod;
	 
	 
	private List<Lista> list;
	private City city;
	
	public City getCity() {
		return city;
	}
	public List<Lista> getList() {
		return list;
	}

	public String getCod() {
		return cod;
	}
	


public class City
{
	String name;

	public String getName() {
		return name;
	}
	
	
}
	public class Lista
	{
		 private Temperature temp;

	float pressure;
	float humidity;
	float speed;
	 private List<Weather> weather;
		public List<Weather> getWeather() {
		return weather;
	}


		public Temperature getTemp() {
		return temp;
	}


	public float getPressure() {
		return pressure;
	}


	public float getHumidity() {
		return humidity;
	}


	public float getSpeed() {
		return speed;
	}


		

		public class Temperature
			{
			private float day;

			private float night;



			public float getNight() {
				return night;
			}



			public float getDay() {
				return day;
			}
			}
		
		
		  public class Weather {

		        private String id;
		        private String main;
		        private String description;
		        private String icon;

		        public String getId() {
					return id;
				}

				public String getMain() {
					return main;
				}

				public String getDescription() {
					return description;
				}

				public String getIcon() {
					return icon;
				}
	}
	}
}