package weather;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Application.MainApp;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import service.DataFile;
import service.Request;
import service.ResponseWeather;
import service.ResponseWeatherAdvanced;

public class WeatherAdvanced extends Application{
	private Stage primaryStage;
	private MainApp mainApp;
	private ResponseWeatherAdvanced now;
	private String weatherJson;
	private Label cityLabel;
	private Label windLabel;
	

	private Label tempLabel;
	private Label pressureLabel;
	private Label humidityLabel;
	
	private Label cityDescription;
	private Label windDescription;
	private Label tempDescription;
	private Label pressureDescription;
	private Label humidityDescription;
	
	private Label tempNightLabel;
	
	private Label tempNightDescription;
	

	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		primaryStage.setTitle("Javafx Configuration Form");
		primaryStage.setResizable(false);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		this.initStage();
	}
	public void openService() {
		DataFile dataFile=new DataFile();
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
		if(netIsAvailable())
	    {
	    	weatherJson = Request.getRawWeather(WEATHER_URL);
		    now = gson.fromJson(weatherJson, ResponseWeatherAdvanced.class);
		    dataFile.saveToFile("dataWeatherAdvanced.csv", weatherJson);
	    }
	    else {
	    	
	    	weatherJson=dataFile.readToFile("dataWeatherAdvanced.csv");
	    	now = gson.fromJson(weatherJson, ResponseWeatherAdvanced.class);
	    
	    }

	}
	
	private  boolean netIsAvailable() {
	    try {
	        final URL url = new URL("http://www.google.com");
	        final URLConnection conn = url.openConnection();
	        conn.connect();
	        conn.getInputStream().close();
	        return true;
	    } catch (MalformedURLException e) {
	        throw new RuntimeException(e);
	    } catch (IOException e) {
	        return false;
	    }
	}
	private void initStage() {
		
		
		openService();
		 
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\Icons\\";
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(5));
		grid.setHgap(30);
		grid.setVgap(25);
		grid.setPadding(new Insets(40, 40, 40, 40));
		final ImageView imageView = new ImageView();
		final Image logoImage = new Image(new File(path + "svg\\"+now.getList().get(Menu.choiceDay).getWeather().get(0).getIcon() +".png").toURI().toString());
		
		imageView.setFitHeight(300);
		imageView.setFitWidth(300);
		imageView.setImage(logoImage);

		final HBox pictureRegion = new HBox();
		pictureRegion.setAlignment(Pos.TOP_CENTER);
		pictureRegion.getChildren().add(imageView);

		grid.add(pictureRegion, 0, 0, 2, 1);
		

		cityLabel = new Label("");
		grid.add(cityLabel, 1, 1);
		cityLabel.getStyleClass().add("userLogin");
	
		tempLabel = new Label("");
		grid.add(tempLabel, 1, 2);
		tempLabel.getStyleClass().add("userLogin");

		tempNightLabel = new Label("");
		grid.add(tempNightLabel, 1, 3);
		tempNightLabel.getStyleClass().add("userLogin");

		pressureLabel = new Label("");
		grid.add(pressureLabel, 1, 4);
		pressureLabel.getStyleClass().add("userLogin");
		
		humidityLabel = new Label("");
		grid.add(humidityLabel, 1, 5);
		humidityLabel.getStyleClass().add("userLogin");
		
		windLabel = new Label("Wind: ");
		grid.add(windLabel, 1, 6);
		windLabel.getStyleClass().add("userLogin");
		
		cityDescription = new Label("City name: ");
		grid.add(cityDescription, 0, 1);
		cityDescription.getStyleClass().add("userLogin");
	
		tempDescription = new Label("Day Temperature :");
		grid.add(tempDescription, 0, 2);
		tempDescription.getStyleClass().add("userLogin");
		
		tempNightDescription = new Label("Night Temperature :");
		grid.add(tempNightDescription, 0, 3);
		tempNightDescription.getStyleClass().add("userLogin");
		
		pressureDescription = new Label("Pressure: ");
		grid.add(pressureDescription, 0, 4);
		pressureDescription.getStyleClass().add("userLogin");
		
		humidityDescription = new Label("Humidity: ");
		grid.add(humidityDescription, 0, 5);
		humidityDescription.getStyleClass().add("userLogin");
		
		windDescription = new Label("Wind Strength:");
		grid.add(windDescription, 0, 6);
		windDescription.getStyleClass().add("userLogin");

		completeLabel();
		
		
		Button backButton = new Button("Backs");
		backButton.getStyleClass().add("button-click");
		backButton.setOnAction(event -> back());
		backButton.setMinWidth(160);
		backButton.setMinHeight(35);
		GridPane.setHalignment(backButton, HPos.RIGHT);
		grid.add(backButton, 1, 7);
		

		
		
		
		
		Image image = new Image(getClass().getResourceAsStream("/Icons/closeButton.png"));
		
		final Button buttonClose = new Button();  //close button init
		buttonClose.getStyleClass().add("close-button");
		buttonClose.setGraphic(new ImageView(image));
		buttonClose.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Stage stage = (Stage) buttonClose.getScene().getWindow();
				stage.close();
			}
		});

		AnchorPane anchorPane = new AnchorPane();
		AnchorPane.setBottomAnchor(grid, 0.0);
		AnchorPane.setLeftAnchor(grid, 0.0);
		AnchorPane.setRightAnchor(grid, 0.0);
		AnchorPane.setTopAnchor(grid, 80.0);
		
		AnchorPane.setRightAnchor(buttonClose, 0.0);
		AnchorPane.setTopAnchor(buttonClose, 0.0);
		anchorPane.getChildren().addAll(buttonClose, grid);
		
		
		Scene scene = new Scene(anchorPane, 700, 800);
	
		scene.getStylesheets().add(getClass().getResource("/StyleCss/application.css").toExternalForm());
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void completeLabel()
	{

		cityLabel.setText(now.getCity().getName());
		tempNightLabel.setText(String.valueOf(round(now.getList().get(Menu.choiceDay).getTemp().getNight(),2)) +"\u00b0C" );
		tempLabel.setText(String.valueOf(round(now.getList().get(Menu.choiceDay).getTemp().getDay(),2)) +"\u00b0C" );
		pressureLabel.setText(String.valueOf(now.getList().get(Menu.choiceDay).getPressure()) +" hPa" );
		humidityLabel.setText(String.valueOf(now.getList().get(Menu.choiceDay).getHumidity()) +"%" );
		windLabel.setText(String.valueOf(now.getList().get(Menu.choiceDay).getSpeed()) +" m/s" );
		
		
	}
	
	   public float round(double f, int places)
	   {  
		   float temp = (float)(f*(Math.pow(10, places)));
		   temp = (Math.round(temp));
		   temp = temp/(int)(Math.pow(10, places));
		   return temp;
	   }
	   
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	public void hide() {
		if (this.primaryStage != null) {
			this.primaryStage.hide();
		}
	}
	private void back() {
		this.mainApp.showMenuForm();
	}
}
