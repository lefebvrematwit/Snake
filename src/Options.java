import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Options extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button Default = new Button("Default");
		Button Custom = new Button("Custom game");
		VBox menu2 = new VBox(Default,Custom);
		menu2.setAlignment(Pos.CENTER);
		menu2.setSpacing(40);
		menu2.setPadding(new Insets(0, 20, 10, 20)); 
		Default.setOnAction(e ->{
	
			
		});
		Custom.setOnAction(e ->{
			
		});
		primaryStage.setScene(new Scene(menu2));
		primaryStage.show();
	
		
	}
	static public void main(String args[])
	{
		launch(args);
	}

}
