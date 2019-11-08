import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SnakeGame extends Application {
    private static final int MENU_SIZE = 750;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Create the Snake/Apple object which will be shared by multiple different panes
        final Snake snake = new Snake(Color.GREEN);
        final Apple apple = new Apple();

        // Create Panes
        final SnakePane snakePane = new SnakePane(snake, apple, MENU_SIZE);
        snakePane.setDefaultBoard();

        // Make the GUI not resizable, set the title, and icon
        stage.setResizable(false);
        stage.setTitle("Snake Game");
        stage.getIcons().add(new Image("SnakeIcon.png"));
        
        // Set the initial Scene and show the GUI
        stage.setScene(snakePane.getSnakePaneScene());
        stage.show();

        snakePane.startGame();
    }

}