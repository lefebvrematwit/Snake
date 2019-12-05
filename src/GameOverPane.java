import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

public class GameOverPane {
	private final int menuSize;
	private final Button playAgain;
	private final Button highScores;
	private final Button recordScore;
	private final Button back;
	private final Scene scene;
	private final Label scoreLabel;
	
	
	public GameOverPane(int menuSize) {
		this.menuSize = menuSize;
		this.playAgain = initializePlayAgainButton();
		this.recordScore = initializeRecordScore();
		this.back = initializeBackButton();
		this.highScores = initializeHighScoresButton();
		this.scoreLabel = initializeScoreLabel();
		this.scene = initializeScene();
	}
	private Button initializeRecordScore() {
		final Button button = new Button("Record Score");
		button.setStyle("-fx-border-color: GREEN;");
		button.setTextFill(Color.DARKGREEN);
		button.setPrefSize(250, 50);
		
		return button;
	}

	private Button initializePlayAgainButton() {
		final Button button = new Button("Play Again");
		button.setStyle("-fx-border-color: GREEN;");
		button.setTextFill(Color.DARKGREEN);
		button.setPrefSize(250, 50);
		
		return button;
	}
	
	private Button initializeHighScoresButton() {
		final Button button = new Button("High Scores");
		button.setStyle("-fx-border-color: GREEN;");
		button.setTextFill(Color.DARKGREEN);
		button.setPrefSize(250, 50);
		
		return button;
	}
	
	private Button initializeBackButton() {
		final Button button = new Button("Main Menu");
		button.setStyle("-fx-border-color: GREEN;");
		button.setTextFill(Color.DARKGREEN);
		button.setPrefSize(250, 50);
		
		return button;
	}

	private Scene initializeScene() {
		final Text text = new Text("GAME OVER");
		text.setStyle("-fx-font: 64 arial; -fx-font-weight: bold;");
		text.setFill(Color.DARKGREEN);
		
		final VBox root = new VBox(text, scoreLabel, playAgain, recordScore, highScores, back);
		root.setStyle("-fx-background-color: BLACK;");
		root.setAlignment(Pos.CENTER);
		root.setSpacing(40);
		root.setPadding(new Insets(40, 40, 40, 40));
		return new Scene(root, menuSize, menuSize);
	}
	
	private Label initializeScoreLabel() {
		final Label label = new Label();
		label.setText("Score: ");
		label.setStyle("-fx-font: 32 arial; -fx-font-weight: bold;");
		label.setTextFill(Color.DARKGREEN);
		label.setTextAlignment(TextAlignment.CENTER);
		
		return label;
	}
	
	public void defineButtonActions(Stage stage, MenuPane menuPane, ScorePane scorePane, SnakePane snakePane, Snake snake, LinkedList<Score> scoresList) {
		// Switches to the SnakePane's Scene and starts a game with the same settings as the previous game
		playAgain.setOnAction(event -> {
			snakePane.setPreviousBoard();
			stage.setScene(snakePane.getSnakePaneScene());
			snakePane.startGame();
		});
		
		// Opens the high scores menu
		highScores.setOnAction(event -> {
			scorePane.displayHighScores(scoresList);
			stage.setScene(scorePane.getHighScoreScene());
		});
		
		// Returns to the main menu
		back.setOnAction(event -> stage.setScene(menuPane.getMenuPaneScene()));
		
		// Records the users score from the previous game and then returns to the main menu
		recordScore.setOnAction(event -> {
			addScore(scoresList, snake.getPoints());
			stage.setScene(menuPane.getMenuPaneScene());
		});
		
	}
	
	public Scene getGameOverScene() {
		return scene;
	}
	
	public void updateScoreLabel(Snake snake) {
		this.scoreLabel.setText(String.format("Score: %d", snake.getPoints()));
	}
	
	// Adds a new score to the high score list only if it belongs
	private void addScore(LinkedList<Score> scores, int score) {
		// Start at the right most side of the list and compare the score we're attempting to insert to the current scores
		int insert = scores.size();
		while (insert > 0) {
			final Score s = scores.get(insert-1);
			if (s != null && s.getScore() < score) {
				insert--;
				continue;
			}
			break;
		}
		
		// Add the score, and if the addition of this score increases the size to 11 remove the lowest score
		scores.add(insert, new Score(score));
		if (scores.size() == 11) {
			scores.remove(10);
		}
	}
	
}
