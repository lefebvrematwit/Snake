import java.util.LinkedList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
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
	private final Label label;
	private final Text text;
	private final Scene scene;
	
	
	
	ScorePane(int menuSize) {
		this.menuSize = menuSize;
		this.back = initializeButton();
		this.text = initializeText();
		this.label = initializeLabel();
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
		final Text text = new Text("");
		text.setStyle("-fx-font: 24 arial;");
		text.setFill(Color.DARKGREEN);
		return text;
	}
	
	private Label initializeLabel() {		
		final Label label = new Label();
		label.setText("High Scores");
		label.setStyle("-fx-font: 64 arial; -fx-font-weight: bold;");
		label.setTextFill(Color.DARKGREEN);
		label.setTextAlignment(TextAlignment.CENTER);
		
		return label;
	}

	private Scene initializeScene() {
		final VBox root = new VBox(label, text, back);
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
	
	// Sets the Text to display each score seperated by a new line
	public void displayHighScores(LinkedList<Score> scores) {
		// Build a single String which contains all of the scores seperated by a line break, then set the Text
		final StringBuilder builder = new StringBuilder();
		for (int n = 0; n < scores.size(); n++) {
			final Score score = scores.get(n);
			builder.append(String.format("%d: %d%n", n+1, score.getScore()));
		}
		text.setText(builder.toString());
	}

}
