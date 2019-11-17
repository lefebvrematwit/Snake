import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AboutPane {
	private final int menuSize;
	private final Text text;
	private final Button back;
	private final Scene scene;
	
	public AboutPane(int menuSize) {
		this.menuSize = menuSize;
		this.text = initializeText();
		this.back = initializeButton();
		this.scene = initliazeScene();
	}
	
	private Text initializeText() {
		final Text text = new Text("Placeholder");
		text.setStyle("-fx-font: 24 arial;");
		text.setFill(Color.DARKGREEN);
		
		return text;
	}
	
	private Button initializeButton() {
		final Button button = new Button("Back");
		button.setStyle("-fx-border-color: GREEN;");
		button.setTextFill(Color.DARKGREEN);
		button.setPrefSize(250, 50);
		
		return button;
	}
	
	private Scene initliazeScene() {
		final VBox root = new VBox(text, back);
		root.setStyle("-fx-background-color: BLACK;");
		root.setAlignment(Pos.CENTER);
		root.setSpacing(40);
		root.setPadding(new Insets(0, 20, 10, 20)); 
		return new Scene(root, menuSize, menuSize);
	}
	
	public void defineButtonActions(Stage stage, MenuPane menuPane) { 
		back.setOnAction(event -> stage.setScene(menuPane.getMenuPaneScene()));
	}
	
	public Scene getAboutPaneScene() {
		return this.scene;
	}

}
