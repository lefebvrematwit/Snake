import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Gets Highscore
 * 
 * @author chanr1
 * 
 */
public class ScorePane {
	private final int menuSize;
	private final Button back;
	private final Text text;
	private final Scene scene;

	ScorePane(int menuSize) {
		this.menuSize = menuSize;
		this.back = initializeButton();
		this.text = initializeText();
		this.scene = initializeScene();
	}

	private Button initializeButton() {
		final Button button = new Button("Back");
		button.setStyle("-fx-border-color: GREEN;");
		button.setTextFill(Color.DARKGREEN);
		button.setPrefSize(250, 50);
		
		return button;
	}
	
	private Text initializeText() {
		Text text = new Text("Placeholder");
		text.setStyle("-fx-font: 24 arial;");
		text.setFill(Color.DARKGREEN);
		return text;
	}

	private Scene initializeScene() {
		final VBox root = new VBox(text, back);
		root.setStyle("-fx-background-color: BLACK;");
		root.setAlignment(Pos.CENTER);
		root.setSpacing(40);
		root.setPadding(new Insets(40, 40, 40, 40));
		return new Scene(root, menuSize, menuSize);
	}

	public void defineButtonActions(Stage stage, MenuPane menuPane) {
		back.setOnAction(event -> stage.setScene(menuPane.getMenuPaneScene()));
	}
	
	public Scene getHighScoreScene() {
		return this.scene;
	}

}
