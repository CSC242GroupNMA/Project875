import java.util.HashSet;
import java.util.Set;

public class State {
	
	public String UserPosition;
	public String ComputerPosition;
	public Player currentplayer;
	
	public State(Player currentplayer, CheckerPiece board[][]) {
		this.currentplayer=currentplayer;
	}
	
	public State(Player currentplayer, String userposition, String computerposition) {
		this.currentplayer=currentplayer;
		this.UserPosition=userposition;
		this.ComputerPosition = computerposition;
	}
	
	
}
