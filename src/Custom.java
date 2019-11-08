import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Custom extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Button color = new Button("Change Color");
		Button size = new Button("Change Map Size");
		Button play = new Button("Play");
		VBox menu3 = new VBox(color,size,play);
		menu3.setAlignment(Pos.CENTER);
		menu3.setSpacing(40);
		menu3.setPadding(new Insets(0, 20, 10, 20)); 
		color.setOnAction(e ->{
	
			
		});
		size.setOnAction(e ->{
			
		});
		play.setOnAction(e ->{
	
			
		});
		primaryStage.setScene(new Scene(menu3));
		primaryStage.show();
		
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}

}
