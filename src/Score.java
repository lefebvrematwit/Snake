import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Score {
	
	private int score;
	
	public Score (int score)
	{
		this.score = score;
	}
	public int getScore()
	{
		return score;
	}
	public void setScore(int point)
	{
		score = point;
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("Scores.txt"));
			pw.write(score);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String toString()
	{
		return String.format("%s", score);
	}
	
	

}
