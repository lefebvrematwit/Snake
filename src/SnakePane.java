
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * This class handles the snake game
 * @author Matt Lefebvre
 */
public class SnakePane extends GridPane {
    private static final String SCORE_FORMAT = "Score: %d"; // format of the score label
    private static final int DEFAULT_ROWS = 25; // default rows in a snake game
    private static final Color BOARD_COLOR = Color.BLACK; // the color of the game board
    private final Map<String, Rectangle> board; // mapping all the board pieces to a coordinate for quick access
    private final Snake snake; // the snake object
    private final Apple apple; // the apple object
    private final int menuSize; // the menu size, used to calculate sizes of board pieces
    private final Label scoreLabel; // the score label object
    private final Scene gameScene; // the scene containing the score label and the game grid
    private final Timeline timeline; // the timeline which acts as the game loop
    private final Stage stage; // reference to the Application Stage
    private final GameOverPane gameOverPane; // reference to the pane which will be set when the player loses 
    private int rows; // the number of rows on the board
    // USED FOR THE PLAY AGAIN FEATURE
    private Color previousSnakeColor; // The color of the snake from the previous game
    private int previousBoardSize; // The size of the board from the previous game

    public SnakePane(Stage stage, GameOverPane gameOverPane, Snake snake, Apple apple, int menuSize) {
        this.stage = stage;
    	this.gameOverPane = gameOverPane;
    	this.snake = snake;
        this.apple = apple;
        this.menuSize = menuSize;
        this.board = new HashMap<>();
        this.scoreLabel = initializeScoreLabel();
        this.timeline = initializeTimeline();
        this.gameScene = initializeScene();
       
    }
   
    // Formats the score label
    private String formatScore() {
        return String.format(SCORE_FORMAT, this.snake.getPoints());
    }

    // Initializes the score label
    private Label initializeScoreLabel() {
        final Label label = new Label(formatScore());
        label.setStyle("-fx-background-color: WHITE");
        label.setFont(new Font(18));
        label.setMaxHeight(25);
        label.setPrefHeight(25);
        label.setAlignment(Pos.CENTER);
        return label;
    }

    // Initializes the game Scene
    private Scene initializeScene() {
        // Create a VBox that will be the "root" pane (i.e. - it will be the pane we add the score/grid pane to)
        final VBox root = new VBox();
        root.setStyle("-fx-background-color: BLACK;");
        root.setFillWidth(true);

        // Add the score label and the game pane to the root HBox
        final VBox upper = new VBox();
        upper.setStyle("-fx-background-color: WHITE");
        upper.getChildren().add(scoreLabel);
        upper.setAlignment(Pos.CENTER);
        root.getChildren().add(upper);
        root.getChildren().add(this);

        // Create the Scene and define the EventHandler for key press actions
        final Scene scene = new Scene(root, menuSize, menuSize);
        scene.setOnKeyPressed(event -> {
            // If the pressed key corresponds to a Direction, update the snakes direction
            final Direction direction = Direction.fromKeyCode(event.getCode());
            if (direction == null) {
                return;
            }

            // Check if the snakes direction is the opposite direction, and the snake is bigger than 1
            if (snake.getSize() > 1 && Direction.getOpposite(snake.getDirection()) == direction) {
                return;
            }

            snake.setDirection(direction);
        });

        return scene;
    }

    // Initializes the timeline for the snake game, the timeline essentially acts as a game loop would
    private Timeline initializeTimeline() {
        final Timeline timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(0.1), event -> {
            /*
            Get the Coordinate the Snake is attempting to move to on the Grid, there are 2 potentially game ending conditions
            1. The Snake is going to move out of bounds
            2. The Coordinate contains a piece of the snake already (i.e. - the snake would collide with itself)
            */
            final Coordinate nextMove = snake.getNextMove();
            if (!isOnBoard(nextMove) || snakeAt(nextMove)) {
                endGame();
                return;
            }

            // Check if the next move is where the apple is, if so update the apples location and have the two GameNodes interact
            if (appleAt(nextMove)) {
                snake.addCoordinate(apple.getCoordinate());
                apple.setCoordinate(getEmptyCoordinate());
                snake.interact(apple);
                apple.interact(snake);
                updateScore();
            }

            // Move the snake and update its list of locations
            snake.moveTo(nextMove);

            update();
        }));

        return timeline;
    }

    // Sets the game board (rows x rows)
    public void setBoard(int rows) {
        // Set the previous fields for the snakes color/board size (note: this is done before resetting GameNodes and the board)
        this.previousSnakeColor = snake.getColor();
        this.previousBoardSize = rows; 
        
    	// Reset the board
    	reset();
    	
        // Update this objects rows field
        this.rows = rows;

        // Recalculate the height of the board pieces to accommodate the space needed for the score label
        final int height = menuSize - 25;

        // Set the entire board, adding each piece to the board Map<String, Rectangle>
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < rows; c++) {
                final Rectangle rectangle = new Rectangle();
                rectangle.setFill(BOARD_COLOR);
                rectangle.setWidth(menuSize / rows);
                rectangle.setHeight(height / rows);
                addBoardPiece(new Coordinate(r, c), rectangle);
            }
        }

        // Initialize the Snakes and Apples locations
        snake.addCoordinate(new Coordinate(rows / 2, rows / 2));
        apple.setCoordinate(getEmptyCoordinate());

        // Update the board and the score label
        update();
        updateScore();
    }

    // Sets the default game board (25 x 25)
    public void setDefaultBoard() {
        setBoard(DEFAULT_ROWS);
    }

    // Used for the play again feature, sets the snakes color and the board size to the previous values
    public void setPreviousBoard() {
    	setBoard(this.previousBoardSize);
    	snake.setColor(this.previousSnakeColor);
    }
    
    // Finds an empty coordinate on the board
    private Coordinate getEmptyCoordinate() {
        while (true) {
            final Random r = new Random();
            final Coordinate coordinate = new Coordinate(r.nextInt(rows - 1), r.nextInt(rows - 1));
            if (getBoardPiece(coordinate).getFill().equals(BOARD_COLOR)) {
                return coordinate;
            }
        }
    }

    // Returns the game Scene
    public Scene getSnakePaneScene() {
        return this.gameScene;
    }

    // Starts the game
    public void startGame() {
        timeline.play();
    }

    // Ends the game
    private void endGame() {	
    	// End the Timeline (game loop)
        timeline.stop();
        
        // Update the score label in the GameOverPane (displays the score)
        gameOverPane.updateScoreLabel(snake);
        
        // Set the Stage to the GameOverPane's Scene
        stage.setScene(gameOverPane.getGameOverScene());
    }

    // Checks if a Coordinate is on the game board
    private boolean isOnBoard(Coordinate coordinate) {
        return coordinate.getX() >= 0 && coordinate.getX() < this.rows && coordinate.getY() >= 0 && coordinate.getY() < this.rows-1;
    }

    // updates the game board (i.e. - sets all the board pieces colors to the default then sets the sake
    private void update() {
        // Repaint the board with the board color
        this.board.values().forEach(r -> r.setFill(BOARD_COLOR));

        // Repaint the snakes locations
        this.snake.getCoordinates().forEach(c -> getBoardPiece(c).setFill(snake.getColor()));

        // Repaint the apples location
        getBoardPiece(apple.getCoordinate()).setFill(apple.getColor());
    }
    
    private void updateScore() {
        this.scoreLabel.setText(formatScore());
    }

    private Rectangle getBoardPiece(Coordinate coordinate) {
        return this.board.get(coordinate.toString());
    }

    private void addBoardPiece(Coordinate coordinate, Rectangle rectangle) {
        this.board.put(coordinate.toString(), rectangle);
        super.add(rectangle, coordinate.getX(), coordinate.getY());
    }

    private boolean snakeAt(Coordinate coordinate) {
        return getBoardPiece(coordinate).getFill().equals(snake.getColor());
    }

    private boolean appleAt(Coordinate coordinate) {
        return getBoardPiece(coordinate).getFill().equals(apple.getColor());
    }

    private void reset() {
    	snake.reset();
    	apple.reset();
    	this.board.clear();
    	super.getChildren().clear();
    }
    
}
