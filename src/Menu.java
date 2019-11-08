
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Menu extends Application {
	
	
	
	
	public static void main(String args[])
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		
		Button Play = new Button("Play");
		Button HighScore = new Button("High Scores");
		Button About = new Button("About");
		
		Text text = new Text("Snake");
		

		VBox menu = new VBox(Play,HighScore,About,text);
		menu.setAlignment(Pos.CENTER);
		text.setStyle("-fx-font: 24 arial;");
		text.setTextAlignment(TextAlignment.CENTER);
		
		menu.setSpacing(40);
		menu.setPadding(new Insets(0, 20, 10, 20)); 
		
		
		
		
		
		Play.setOnAction(e ->{
	
			
		});
		HighScore.setOnAction(e ->{
			
			
		});
		About.setOnAction(e ->{
			
			
		});
		primaryStage.setScene(new Scene(menu));
		primaryStage.show();
	
	}

	
}
