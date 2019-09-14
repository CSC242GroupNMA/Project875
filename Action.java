
public class Action {

	
	public Action moveupleft;
	public Action moveupright;
	public Action movedownright;
	public Action movedownleft;
	
	public Action possiblemoves[];
	
	public int startrow;
	public int startcol;
	public int destrow;
	public int destcol;
	public boolean valid;
	
	public Action(int startrow, int startcol, int destrow, int destcol) {
		this.startrow = startrow;
		this.startcol = startcol;
		this.destrow = destrow;
		this.destcol=destcol;
	}
	
	
	public Action ValidMoves(int i, int j) {
		
		if(Problem.boardarray[i][j].color.equals("b") && !Problem.boardarray[i][j].Crowned) {
			
		}
		return null;
	}
	
	//Checks if move made is valid
	public static boolean checkvalidaction(Action x) {
		
		//checks for if the destination is empty and if it isnt moving horizontally or vertically
		if((Problem.boardarray[x.destrow][x.destcol].empty) && (x.destrow!=x.startrow) && (x.destcol!=x.startcol)) { 
			return true;
		}
		return false;
	}
	
	
	public static void makemove(Action x) {
		//Move the piece 
		//FInd an effecient way to update the position of piece
		//THIS BASICALLY UPDATES THE CHECKERPIECE'S ROW,COL,AND COLOR SO THAT IT CAN APPEAR ON THE BOARD AND ERASES THE PREVIOUS ONE.
		Problem.boardarray[x.destrow][x.destcol].myrow = x.destrow;
		Problem.boardarray[x.destrow][x.destcol].mycol = x.destcol;
		Problem.boardarray[x.destrow][x.destcol].color= Problem.boardarray[x.startrow][x.startcol].color;
		CheckerPiece.MakeEmpty(Problem.boardarray[x.startrow][x.startcol]);
		
	}
	
	//Returns the sequence of actions taken to reach solution
	public void Solution() {
		
	}
	
}
