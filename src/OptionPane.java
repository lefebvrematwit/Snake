import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OptionPane {
	private final int menuSize;
	private final Button defaultB;
	private final Button customB;
	private final Button backB;
	private final Scene scene;
	
	public OptionPane(int menuSize) {
		this.menuSize = menuSize;
		this.defaultB = initializeDefaultB();
		this.customB = initializeCustomB();
		this.backB = initializeBackB();
		this.scene = initializeScene();
	}

	private Button initializeDefaultB() {
		final Button button = new Button("Default");
		
		return button;
	}
	
	private Button initializeCustomB() {
		final Button button = new Button("Custom game");
		
		return button;
	}
	
	private Button initializeBackB() {
		final Button button = new Button("Back");
		
		return button;
	}
	
	private Scene initializeScene() {
		final VBox root = new VBox(defaultB, customB, backB);
		root.setAlignment(Pos.CENTER);
		root.setSpacing(40);
		root.setPadding(new Insets(0, 20, 10, 20)); 

		return new Scene(root, menuSize, menuSize);
	}
	
	public void defineButtonActions(Stage stage, MenuPane menuPane, SnakePane snakePane) {
		defaultB.setOnAction(event -> {
			snakePane.setDefaultBoard();
			stage.setScene(snakePane.getSnakePaneScene());
			snakePane.startGame();
		});
		
		customB.setOnAction(event -> {
			
		});
		
		backB.setOnAction(event -> stage.setScene(menuPane.getMenuPaneScene()));
	}

	public Scene getOptionPaneScene() {
		return this.scene;
	}

}
