import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameOverPane {
	private final int menuSize;
	private final Button playAgain;
	private final Button highScores;
	private final Button getScore;
	private final Button back;
	private final Scene scene;
	
	
	public GameOverPane(int menuSize) {
		this.menuSize = menuSize;
		this.playAgain = initializePlayAgainButton();
		this.getScore = initializeGetScore();
		this.back = initializeBackButton();
		this.highScores = initializeHighScoresButton();
		this.scene = initializeScene();
	}
	private Button initializeGetScore() {
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
		
		final VBox root = new VBox(text, playAgain,getScore, highScores, back);
		root.setStyle("-fx-background-color: BLACK;");
		root.setAlignment(Pos.CENTER);
		root.setSpacing(40);
		root.setPadding(new Insets(40, 40, 40, 40));
		return new Scene(root, menuSize, menuSize);
	}
	
	public void defineButtonActions(Stage stage, MenuPane menuPane, ScorePane scorePane, SnakePane snakePane, Snake snake) {
		playAgain.setOnAction(event -> {
			snakePane.setPreviousBoard();
			stage.setScene(snakePane.getSnakePaneScene());
			snakePane.startGame();
		});
		
		highScores.setOnAction(event -> stage.setScene(scorePane.getHighScoreScene()));
		
		back.setOnAction(event -> stage.setScene(menuPane.getMenuPaneScene()));
		
		getScore.setOnAction(event -> {
			 try {
					PrintWriter fr = new PrintWriter("HighScore.txt");//added here
					fr.println(snake.getPoints());
					fr.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		});
		
	}
	
	public Scene getGameOverScene() {
		return scene;
	}
	
}
