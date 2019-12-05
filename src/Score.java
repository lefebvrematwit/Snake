public class Score {
	private final int score;
	
	public Score (int score){
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
		
	public String toString() {
		return String.format("%s", score);
	}
	
	

}
