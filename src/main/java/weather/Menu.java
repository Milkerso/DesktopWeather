package weather;

import java.io.File;
import java.time.DayOfWeek;
import java.time.LocalDate;

import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import Application.MainApp;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import service.Request;

public class Menu extends Application {

	private Stage primaryStage;
	private MainApp mainApp;
	public static int choiceDay;

	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		primaryStage.setTitle("Javafx Menu Form");
		primaryStage.setResizable(false);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		this.initStage();
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void initStage() {
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\Icons\\";

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(5));
		grid.setHgap(30);
		grid.setVgap(25);
		grid.setPadding(new Insets(40, 40, 40, 40));
		final ImageView imageView = new ImageView();
		final Image logoImage = new Image(new File(path + "cloudIcon.png").toURI().toString());
		imageView.setImage(logoImage);

		final HBox pictureRegion = new HBox();
		pictureRegion.setAlignment(Pos.TOP_CENTER);
		pictureRegion.getChildren().add(imageView);

		grid.add(pictureRegion, 0, 0, 2, 1);

		Button configurationButton = new Button("Configuration");
		configurationButton.getStyleClass().add("button-click");
		configurationButton.setOnAction(event -> openConfiguration());
		configurationButton.setMinWidth(250);
		configurationButton.setMinHeight(60);
		GridPane.setHalignment(configurationButton, HPos.CENTER);
		grid.add(configurationButton, 1, 2);

		Button weatherButton = new Button("Weather");
		weatherButton.getStyleClass().add("button-click");
		weatherButton.setOnAction(event -> openWeather());
		weatherButton.setMinWidth(250);
		weatherButton.setMinHeight(60);
		GridPane.setHalignment(weatherButton, HPos.CENTER);
		grid.add(weatherButton, 1, 3);

		Button weatherAdvancedButton = new Button("WeatherAdvanced");
		weatherAdvancedButton.getStyleClass().add("button-click");
		weatherAdvancedButton.setOnAction(event -> openWeatherAdvanced());
		weatherAdvancedButton.setMinWidth(250);
		weatherAdvancedButton.setMinHeight(60);
		GridPane.setHalignment(weatherAdvancedButton, HPos.CENTER);
		grid.add(weatherAdvancedButton, 1, 4);


		Image image = new Image(getClass().getResourceAsStream("/Icons/closeButton.png"));

		final Button buttonClose = new Button(); // close button init
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

	private void openConfiguration() {
		this.mainApp.showConfigurationForm();
	}



	private void openWeather() {
		Request.CITY = "Warsaw";
		this.mainApp.showWeatherForm();
	}

	private void openWeatherAdvanced() {
		LocalDate date = LocalDate.now();
		DayOfWeek dow = date.getDayOfWeek().plus(1);
		String dayName = dow.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		
		
		
		List<String> choices = new ArrayList<>();
		choices.add("1."+ dayName);
		dow = date.getDayOfWeek().plus(2);
		dayName = dow.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		choices.add("2."+ dayName);
		dow = date.getDayOfWeek().plus(3);
		dayName = dow.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		choices.add("3."+ dayName);
		dow = date.getDayOfWeek().plus(4);
		dayName = dow.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		choices.add("4."+ dayName);
		dow = date.getDayOfWeek().plus(5);
		dayName = dow.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		choices.add("5."+ dayName);
		
		ChoiceDialog<String> dialog = new ChoiceDialog<>("Today", choices);
		dialog.setTitle("Choice day");
		dialog.setHeaderText("If you do not choose, the present day will be displayed");;
		dialog.setContentText("Choose day:");
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\Icons\\";
		Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();

		stage.getIcons().add(new Image(new File(path + "cloudIcon.png").toURI().toString()));
	
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()) {
			Menu.choiceDay = Character.getNumericValue(result.get().charAt(0));
			if (Menu.choiceDay > 5 || Menu.choiceDay < 0) {
				Menu.choiceDay = 0;
			}
			this.mainApp.showWeatherAdvancedForm();

		}

	
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	public void hide() {
		if (this.primaryStage != null) {
			this.primaryStage.hide();
		}
	}

}
