package weather;

import java.io.File;

import Application.MainApp;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class WeatherAdvanced extends Application{
	private Stage primaryStage;
	private MainApp mainApp;
	
	
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
		
		
		Button backButton = new Button("Backw");
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
