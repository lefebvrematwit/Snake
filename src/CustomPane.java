import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * Customize snake game before playing
 * @author chanr1
 *
 */
public class CustomPane {
	private final int menuSize;
	private final ColorPicker colorPicker;
	private final TextField sizePicker;
	private final Button back;
	private final Button play;
	private final Scene scene;
	
	//constructor
	public CustomPane(int menuSize){ 
		this.menuSize = menuSize;
		this.colorPicker = initializeColorPicker();
		this.sizePicker = initializeSizePicker();
		this.play = initializePlayButton();
		this.back = initializeBackButton();
		this.scene = initializeScene();
		
	}
	
	//Initialize Snake ColorPicker
	private ColorPicker initializeColorPicker(){
		final ColorPicker colorPicker = new ColorPicker();
		colorPicker.getStyleClass().add("color");
		
		return colorPicker;
	}
	
	//Initialize BoardSize TextField
	private TextField initializeSizePicker(){
		final TextField size = new TextField();
		
		return size;
	}

	// Initialize Play Button
	private Button initializePlayButton() {
		final Button button = new Button("Play");
		button.setStyle("-fx-border-color: GREEN;");
		button.setTextFill(Color.DARKGREEN);
		button.setPrefSize(250, 50);
		
		return button;
	}
	
	// Initialize Back Button
	private Button initializeBackButton() {
		final Button button = new Button("back");
		button.setStyle("-fx-border-color: GREEN;");
		button.setTextFill(Color.DARKGREEN);
		button.setPrefSize(250, 50);
		
		return button;
	}
	
	// Initialize the Scene for this menu
	private Scene initializeScene() {
		final Text colorText = new Text("Snake Color");
		colorText.setStyle("-fx-font: 24 arial;");
		colorText.setFill(Color.DARKGREEN);
		
		final Text sizeText = new Text("Board Size");
		sizeText.setStyle("-fx-font: 24 arial;");
		sizeText.setFill(Color.DARKGREEN);
		
		final HBox color = new HBox(colorText, colorPicker);
		color.setAlignment(Pos.CENTER);
		color.setSpacing(40);
		color.setPadding(new Insets(40, 40, 40, 40)); 
		final HBox rows = new HBox(sizeText, sizePicker);
		rows.setAlignment(Pos.CENTER);
		rows.setSpacing(40);
		rows.setPadding(new Insets(40, 40, 40, 40)); 
		

		final VBox root = new VBox(color, rows, play, back);
		root.setStyle("-fx-background-color: BLACK;");
		root.setAlignment(Pos.CENTER);
		root.setSpacing(40);
		root.setPadding(new Insets(40, 40, 40, 40)); 
		return new Scene(root, menuSize, menuSize);
	}

	// creates scene
	public Scene getCustomGameScene() {
		return this.scene;
	}
	
	// creates actions
	public void defineButtonActions(Stage stage, Snake snake, SnakePane snakePane, OptionPane optionPane) {
		back.setOnAction(event -> stage.setScene(optionPane.getOptionPaneScene()));
		play.setOnAction(event -> {
			Integer rows;
			try {
				rows = Integer.parseInt(this.sizePicker.getText());
			} catch (NumberFormatException e) {
				return;
			}
			
			snakePane.setBoard(rows);
			snake.setColor(this.colorPicker.getValue());
			stage.setScene(snakePane.getSnakePaneScene());
			snakePane.startGame();
		});
	}

}
	
	
	


