import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SnakeGame extends Application {
    private static final int MENU_SIZE = 750;
    private final LinkedList<Score> highScores = new LinkedList<>();

    public static void main(String[] args) {
        Application.launch(args);
    }

    // When the program first starts
    @Override
    public void start(Stage stage) {
        // Create the Snake/Apple object which will be shared by multiple different panes
        final Snake snake = new Snake();
        final Apple apple = new Apple();

        // Load the high scores
        this.highScores.addAll(loadHighScores());
        
        // Create Panes
        final MenuPane menuPane = new MenuPane(MENU_SIZE);
        final OptionPane optionPane = new OptionPane(MENU_SIZE);
        final CustomPane customPane = new CustomPane(MENU_SIZE);
        final AboutPane aboutPane = new AboutPane(MENU_SIZE);
        final ScorePane scorePane = new ScorePane(MENU_SIZE);
        final GameOverPane gameOverPane = new GameOverPane(MENU_SIZE);
        final SnakePane snakePane = new SnakePane(stage, gameOverPane, snake, apple, MENU_SIZE);

        // Initialize the event handlers for buttons/other user input
        menuPane.defineButtonActions(stage, optionPane, scorePane, aboutPane, highScores);
        optionPane.defineButtonActions(stage, menuPane, snakePane, customPane);
        customPane.defineButtonActions(stage, snake, snakePane, optionPane);
        aboutPane.defineButtonActions(stage, menuPane);
        scorePane.defineButtonActions(stage, menuPane);
        gameOverPane.defineButtonActions(stage, menuPane, scorePane, snakePane, snake, highScores);
        
        // Set the GUI's size, Make the GUI not resizable, set the GUI's title, and GUI's icon
        stage.setWidth(MENU_SIZE);
        stage.setHeight(MENU_SIZE);
        stage.setResizable(false);
        stage.setTitle("Snake Game");
        stage.getIcons().add(new Image("SnakeIcon.png"));
        
        // Set the initial Scene and show the GUI
        stage.setScene(menuPane.getMenuPaneScene());
        stage.show();

    }
    
    // When the program stops
    @Override
    public void stop() {
    	// Save the high scores
    	saveHighScores();
    }
    
    // Loads the high scores from the HighScore.txt file
    private LinkedList<Score> loadHighScores() {
    	try {
    		// Created LinkedList to store the sorted Scores and a BufferedReader to read each line of the .txt file
    		final LinkedList<Score> scores = new LinkedList<Score>();
    		final BufferedReader reader = new BufferedReader(new FileReader("HighScore.txt"));
    		
    		// Read each line of the text file
    		String line;
    		while ((line = reader.readLine()) != null) {
    			// Attempt to parse an int from the line, if its an error just skip it
    			try {
        			scores.add(new Score(Integer.parseInt(line)));
    			} catch (NumberFormatException e) {
    			}
    		}
    		
    		// Close the BufferedReader and return the List of scores
    		reader.close();
    		return scores;
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }

    // Saves the high scores to the HighScore.txt file
    private void saveHighScores() {
    	try {
    		// Create a FileWriter to write scores and set appending to false, which means the file will overwrite the contents
    		final FileWriter writer = new FileWriter(new File("HighScore.txt"), false);
    		
    		// Create out String which we will write in a single write using the FileWriter
    		final StringBuilder builder = new StringBuilder();
    		highScores.forEach(score -> builder.append(score.getScore()).append(System.lineSeparator()));
    		
    		// Write the scores and close the FileWriter
    		writer.write(builder.toString());
    		writer.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
}