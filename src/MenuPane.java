import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class MenuPane {
	private final int menuSize;
	private final Label title;
	private final Button play;
	private final Button score;
	private final Button about; 
	private final Scene scene;

	public MenuPane(int menuSize) {
		this.menuSize = menuSize;
		this.title = initializeTitle();
		this.play = initializePlayButton();
		this.score = initializeScoreButton();
		this.about = initializeAboutButton();
		this.scene = initializeScene();
	}

	private Scene initializeScene() {
		final VBox menu = new VBox(title, play, score, about);
		menu.setStyle("-fx-background-color: BLACK;");
		menu.setAlignment(Pos.CENTER);
		
		menu.setSpacing(40);
		menu.setPadding(new Insets(0, 20, 10, 20)); 

		return new Scene(menu, menuSize, menuSize);
	}
	
	private Label initializeTitle() {
		final Label label = new Label();
		label.setText("SNAKE");
		label.setStyle("-fx-font: 64 arial; -fx-font-weight: bold;");
		label.setTextFill(Color.DARKGREEN);
		label.setTextAlignment(TextAlignment.CENTER);
		
		return label;
	}
	
	private Button initializePlayButton() {
		final Button button = new Button("Play");
		button.setStyle("-fx-border-color: GREEN;");
		button.setTextFill(Color.DARKGREEN);
		button.setPrefSize(250, 50);
		
		return button;
	}
	
	private Button initializeScoreButton() {
		final Button button = new Button("High Scores");
		button.setStyle("-fx-border-color: GREEN;");
		button.setTextFill(Color.DARKGREEN);
		button.setPrefSize(250, 50);
		
		return button;
	}
	
	private Button initializeAboutButton() {
		final Button button = new Button("About");
		button.setStyle("-fx-border-color: GREEN;");
		button.setTextFill(Color.DARKGREEN);
		button.setPrefSize(250, 50);
		
		return button;
	}
	
	public void defineButtonActions(Stage stage, OptionPane optionPane, ScorePane scorePane, AboutPane aboutPane) {
		play.setOnAction(event -> stage.setScene(optionPane.getOptionPaneScene()));
		
		score.setOnAction(event -> stage.setScene(scorePane.getHighScoreScene()));
		
		about.setOnAction(event -> stage.setScene(aboutPane.getAboutPaneScene()));
	}
	
	public Scene getMenuPaneScene() {
		return this.scene;
	}
	
	
	
}
