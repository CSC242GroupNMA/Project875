
public class CheckerPiece {

	public boolean Crowned;
	public String position;
	public String color;
	public Player Pl;
	public boolean empty;
	public int myrow;
	public int mycol;
	
	//Constructor to keep track of individual checkerpieces
	public CheckerPiece(boolean crowned, String position, Player P) {
		this.Crowned=crowned;
		this.position=position;
		this.color=P.color;
		this.Pl=P;
		this.empty=false;
		
		this.myrow =Game.LetterToRow.get(this.position.charAt(0));
		this.mycol = Character.getNumericValue(this.position.charAt(1));
			
		
	}
	
	//Constructor used for blank pieces
	public CheckerPiece(int row,int col) {
		this.color=" "; //Represents empty space
		this.empty=true;
		this.Crowned=false;
		this.Pl=null;
		this.myrow=row;
		this.mycol=col;
	}
	
	public static void MakeEmpty(CheckerPiece x) {
		x.color=" "; //Represents empty space
		x.empty=true;
		x.Crowned=false;
		x.Pl=null;
	}
	
	public void setColor(String color) {
		this.color=color;
	}
	
	public Player getPlayer() {
		return this.Pl;
	}
	
	public static void updatelocation(CheckerPiece x) {
		x.myrow = Game.LetterToRow.get(x.position.charAt(0));
		x.mycol = x.position.charAt(1);
		Problem.boardarray[x.myrow][x.mycol]=x;
	}
	
}
