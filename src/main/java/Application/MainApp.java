package Application;

import javafx.application.Application;
import javafx.stage.Stage;
import weather.Configuration;
import weather.Menu;
import weather.Weather;
import weather.WeatherAdvanced;

public class MainApp extends Application {
	private Menu menu;
	private Configuration configuration;
	private Weather weather;
	private WeatherAdvanced weatherAdvanced;
	private String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public static void main(String args[]) {
		launch(args);
	}

	public void showMenuForm() {
		if (this.menu == null) {
			this.createMenuForm();
		}

		this.hideAll();
		this.menu.start(new Stage());
	}

	public void showConfigurationForm() {
		if (this.configuration == null) {
			this.createConfigurationForm();
		}

		this.hideAll();
		this.configuration.start(new Stage());
	}

	public void showWeatherAdvancedForm() {
		if (this.weatherAdvanced == null) {
			this.createWeatherAdvancedForm();
		}

		this.hideAll();
		this.weatherAdvanced.start(new Stage());
	}



	public void showWeatherForm() {
		if (this.weather == null) {
			this.createWeatherForm();
		}

		this.hideAll();
		this.weather.start(new Stage());
	}




	private void createMenuForm() {
		this.menu = new Menu();
		this.menu.setMainApp(this);
	}


	private void createWeatherAdvancedForm() {
		this.weatherAdvanced = new WeatherAdvanced();
		this.weatherAdvanced.setMainApp(this);
	}

	private void createConfigurationForm() {
		this.configuration = new Configuration();
		this.configuration.setMainApp(this);
	}

	private void createWeatherForm() {
		this.weather = new Weather();
		this.weather.setMainApp(this);
	}

	private void hideAll() {

		if (this.menu != null) {
			this.menu.hide();
		}
		if (this.configuration != null) {
			this.configuration.hide();
		}
		if (this.weather != null) {
			this.weather.hide();
		}

		if (this.weatherAdvanced != null) {
			this.weatherAdvanced.hide();
		}


	}

	@Override
	public void start(Stage arg0) throws Exception {
		this.showMenuForm();

	}

}
