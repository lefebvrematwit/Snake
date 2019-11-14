import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Custom {
	private ColorPicker color;
	private TextField size;
	private Button play;
	private final int MenuSize;
	
	public Custom(int MenuSize){ //constructor
		this.MenuSize = MenuSize;
		color = colorPick();
		size = Size();
		
	}
	public ColorPicker colorPick(){//Initialize PaneSize TextField
		
		final ColorPicker colorPick = new ColorPicker();
		colorPick.getStyleClass().add("color");
		
		return colorPick;
	}
	public TextField Size(){//Initialize PaneSize Button
		
		final TextField size = new TextField("Pane size");
		return size;
	}

	

	
	public Scene sceneCustom() {//creates scene
		// TODO Auto-generated method stub
	
		VBox menu3 = new VBox(color,size,play);
		menu3.setAlignment(Pos.CENTER);
		menu3.setSpacing(40);
		menu3.setPadding(new Insets(0, 20, 10, 20)); 
		return new Scene(menu3,MenuSize,MenuSize);
	}
	
	public void Actions(Stage stage, SnakePane snakePane,Snake snake) {//creates actions
			 EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
		            public void handle(ActionEvent e) 
		            { 
		                Color color1 = color.getValue();
		                snake.setColor(color1);
		                
		  
		                
		            } 
		        }; 
			EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
				

				@Override
				public void handle(ActionEvent event) {
					int a = Integer.parseInt(size.getText());
					
					snakePane.setBoard(a);
				}
				
			};
			
			play.setOnAction(event3 -> stage.setScene(snakePane.getSnakePaneScene()));
			
		
	}
	public Scene getCustomPaneScene(){
		
		return sceneCustom();
	}
}
	
	
	


