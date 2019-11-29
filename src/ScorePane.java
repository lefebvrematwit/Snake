import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

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
	
	/**
	 * 
	 * back button to return to main menu
	 */

	private Button initializeButton() {
		final Button button = new Button("Back");
		button.setStyle("-fx-border-color: GREEN;");
		button.setTextFill(Color.DARKGREEN);
		button.setPrefSize(250, 50);
		
		return button;
	}
	/**
	 * 
	 * creates text
	 */
	
	private Text initializeText() {
		
		Text text = new Text("");
		text.setStyle("-fx-font: 24 arial;");
		text.setFill(Color.DARKGREEN);
		return text;
	}
	/**
	 * 
	 * stores values
	 */
	
	private LinkedList<Integer> getText()//gets score and puts into array;
	{
		LinkedList<Integer> a = new LinkedList<Integer>();
		FileReader fr = null;
		BufferedReader br = new BufferedReader(fr);
		try {
			fr = new FileReader("HighScore.txt");
			br = new BufferedReader(fr);
			int score = Integer.parseInt(br.readLine());
			a.add(score);
			return a;
		}	
		catch (Exception e) {
			
			return null;
		}
		finally
		{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 
	 * @param b
	 * checks highest score
	 */
	public Integer checkText(LinkedList <Integer> b){
		Integer highscore = 0;
		for(Integer i : b)
		{
			if (i > highscore)
			{
				highscore = i;
			}
		}
		return highscore;
		
	
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
