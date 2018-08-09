package service;

import java.util.List;

public class ResponseWeather {

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getDt() {
		return dt;
	}

	public void setDt(long dt) {
		this.dt = dt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	



	private long dt;
	private String name;
	private List<Weather> weather;
	private Main main;
	private Wind wind;


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

		@Override
		public String toString() {
			return "Weather{" + "id=" + id + ", main=" + main + ", description=" + description + ", icon=" + icon + '}';
		}

	}

	public class Main {

		private float temp;
		private float pressure;
		private float humidity;
		private float temp_min;
		private float temp_max;

		public float getTemp() {
			return temp;
		}

		public float getPressure() {
			return pressure;
		}

		public float getHumidity() {
			return humidity;
		}

		public float getTemp_min() {
			return temp_min;
		}

		public float getTemp_max() {
			return temp_max;
		}

		@Override
		public String toString() {
			return "Main{" + "temp=" + temp + ", pressure=" + pressure + ", humidity=" + humidity + ", temp_min="
					+ temp_min + ", temp_max=" + temp_max + '}';
		}
	}

	public class Wind {

		private float speed;
		private float deg;

		public float getSpeed() {
			return speed;
		}

		public float getDeg() {
			return deg;
		}

		@Override
		public String toString() {
			return "Wind{" + "speed=" + speed + ", deg=" + deg + '}';
		}
	}


}
