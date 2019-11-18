import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
/**
 * Gets Highscore
 * @author chanr1
 *	
 */
public class HighScore {
	private final int menuSize;
	private Text text;
	private Scene scene;
	
	HighScore(int menuSize,int num)
	{
		this.menuSize = menuSize;
		this.text = initializeText(num);
		this.scene = initializeScene();
	}
	private Text initializeText(int s)
	{
		Text text = new Text() ;
		text.setText(String.format("HighScore: %d",s));
		return text;
	}
	private Scene initializeScene()
	{
		final HBox text1 = new HBox(text);
		text1.setAlignment(Pos.CENTER);
		text1.setSpacing(40);
		text1.setPadding(new Insets(40, 40, 40, 40)); 
		
		final VBox root = new VBox(text1);
		root.setStyle("-fx-background-color: BLACK;");
		root.setAlignment(Pos.CENTER);
		root.setSpacing(40);
		root.setPadding(new Insets(40, 40, 40, 40)); 
		return new Scene(root, menuSize, menuSize);
	}
	
	public Scene getHighScoreScene() {
		// TODO Auto-generated method stub
		return this.scene;
	}

	

}
