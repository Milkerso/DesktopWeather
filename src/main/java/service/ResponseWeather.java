package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Weather representation for current conditions
 *
 * @author well
 */
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

	public Clouds getClouds() {
		return clouds;
	}

	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}

	public Sys getSys() {
		return sys;
	}

	public void setSys(Sys sys) {
		this.sys = sys;
	}

	private long dt;
    private String name;
    private List<Weather> weather;
    private Main main;
    private Wind wind;
    private Clouds clouds;
    private Sys sys;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String lineSeparator = System.getProperty("line.separator");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm Z");
        
        sb.append(this.getClass().getSimpleName());
        sb.append(" {");
        sb.append(lineSeparator);

        sb.append("\tdt: ");
        sb.append(formatter.format(new Date(dt * 1000)));
        sb.append(lineSeparator);

        sb.append("\tid: ");
        sb.append(id);
        sb.append(lineSeparator);

        sb.append("\tname: ");
        sb.append(name);
        sb.append(lineSeparator);

        for (Weather w : weather) {
            sb.append("\tweather.main: ");
            sb.append(w.main);
            sb.append(lineSeparator);
            sb.append("\tweather.description: ");
            sb.append(w.description);
            sb.append(lineSeparator);
            sb.append("\tweather.icon: ");
            sb.append(w.icon);
            sb.append(lineSeparator);
        }

        sb.append("\tmain.temp: ");
        sb.append(main.temp);
        sb.append(lineSeparator);
        
        sb.append("\tmain.temp_min: ");
        sb.append(main.temp_min);
        sb.append(lineSeparator);
        
        sb.append("\tmain.temp_max: ");
        sb.append(main.temp_max);
        sb.append(lineSeparator);
        
        sb.append("\tmain.humidity: ");
        sb.append(main.humidity);
        sb.append(lineSeparator);
        
        sb.append("\tmain.pressure: ");
        sb.append(main.pressure);
        sb.append(lineSeparator);

        sb.append("\twind.speed: ");
        sb.append(wind.speed);
        sb.append(lineSeparator);
        
        sb.append("\twind.deg: ");
        sb.append(wind.deg);
        sb.append(lineSeparator);

        sb.append("\tclouds: ");
        sb.append(clouds.all);
        sb.append(lineSeparator);

        sb.append("\tsunrise: ");
        sb.append(formatter.format(new Date(sys.sunrise * 1000)));
        sb.append(lineSeparator);

        sb.append("\tsunset: ");
        sb.append(formatter.format(new Date(sys.sunset * 1000)));
        sb.append(lineSeparator);

        sb.append('}');

        return sb.toString();
    }

    class Weather {

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

    class Main {

        private float temp;
        private float pressure;
        private float humidity;
        private float temp_min;
        private float temp_max;

        @Override
        public String toString() {
            return "Main{" + "temp=" + temp + ", pressure=" + pressure + ", humidity=" + humidity + ", temp_min=" + temp_min + ", temp_max=" + temp_max + '}';
        }
    }

    class Wind {

        private float speed;
        private float deg;

        @Override
        public String toString() {
            return "Wind{" + "speed=" + speed + ", deg=" + deg + '}';
        }
    }

    class Clouds {

        private float all;
    }

    class Sys {

        private long sunrise;
        private long sunset;
    }

}
