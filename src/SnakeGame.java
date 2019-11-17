import javafx.application.Application;
import javafx.scene.control.Button;
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
        final MenuPane menuPane = new MenuPane(MENU_SIZE);
        final OptionPane optionPane = new OptionPane(MENU_SIZE);
        final CustomPane customPane = new CustomPane(MENU_SIZE);
        final AboutPane aboutPane = new AboutPane(MENU_SIZE);

        // Initialize the event handlers for buttons/other user input
        menuPane.defineButtonActions(stage, optionPane, aboutPane);
        optionPane.defineButtonActions(stage, menuPane, snakePane, customPane);
        customPane.defineButtonActions(stage, snake, snakePane, optionPane);
        aboutPane.defineButtonActions(stage, menuPane);
        
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

}