import java.util.*;

public class Player {
	String color;
	public int NumberOfPieces;
	public LinkedList<CheckerPiece> pieces = new LinkedList<CheckerPiece>();
	
	public Player(String color, int num) {
		this.color = color;
		this.NumberOfPieces=num;
	}

	
	public Player getPlayer(String color) {
		if(color==this.color) {
			return this;
		}
		else {
			System.out.print("returning null");
			return null;
		}
		}
	
	public boolean checkinvalid() {
		
		return false;
	}
}
