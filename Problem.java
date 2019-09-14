import java.util.Scanner;

public class Problem {

	public State InitialState;
	
	public Player startingplayer;
	public Player secondplayer;
	
	public int size;
	
	public Scanner x = new Scanner(System.in);
	public String currmove;
	
	//Variables used to split the String entered by user to make the new move
	public int startrow;
	public int startcol;
	public int destrow;
	public int destcol;
	
	//Keeping track of current Node
	public Node currnode;
	
	//Keeping track of current state
	public State currstate;
	
	
	//define board
	public static CheckerPiece boardarray[][];  //BoardArray of type CheckerPiece
	
	public Problem(int size, int choice) {
		//SETTING UP THE INTIAL STATE
		if(size==1) {		
			this.size=4;
			if(Game.user.color.equals("b")) {
				
				InitialState = new State(Game.user,boardarray);
				startingplayer = Game.user;
				secondplayer = Game.computer;
			}
			else {
				
				InitialState = new State(Game.computer,boardarray);
				startingplayer = Game.computer;
				secondplayer = Game.user;
			}
			}
		else if(size==2) {
			this.size = 8;
			if(Game.user.color.equals("b")) {
				InitialState = new State(Game.user,boardarray);
			}
			else {
				InitialState = new State(Game.computer,boardarray);
			}
		}	
		
		boardarray = new CheckerPiece[this.size][this.size];
		initializearray(boardarray);
		printboard(boardarray);
		
		//conditions for choices
		switch(choice) {
		case 1: Random(Game.user,Game.computer);  
		}
		
		
	}
	
	//INTIALIZING ARRAY TO "Empty" checkerpieces
	public void initializearray(CheckerPiece array[][]) {
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array.length;j++) {
				array[i][j]=new CheckerPiece(i,j);  //Blank CheckerPiece
			}
		}
		
		//hardcoded setting of board for now
		array[0][1]= new CheckerPiece (false,"A2", startingplayer);
		array[0][3]=new CheckerPiece (false,"A4", startingplayer );
		array[3][0]=new CheckerPiece (false,"D1", secondplayer);
		array[3][2]=new CheckerPiece (false,"D3", secondplayer);
		
	}
	
	
	//INITIAL BOARD REP
	public void printboard(CheckerPiece array[][]) {
		String border = "+-+-+-+-+";
		System.out.print("  ");
		for(int i=0;i<array.length;i++) {
			System.out.print(i + " ");
			}
		char c = 65;
		System.out.println("\n"+" "+border);
		for (int row = 0; row<array.length; row++) {
			System.out.print(String.valueOf(c)+ "|");
			c++;
			for(int col=0;col<array.length;col++) {
				System.out.print(boardarray[row][col].color + "|");
			}
			System.out.println();
			System.out.println(" " +border);	
			}
			}
	
	
	public void Random(Player user, Player computer) {
		currnode = new Node(InitialState, null, 0, null); //setting the parent node
		
		if(startingplayer.equals(user)) {
			UserTurn();
		}
		else {
			
		}
	}
	
	public void UserTurn() {
		System.out.println("Enter move");
		currmove = x.next();
		
		// "A2-B1"
		startrow = Game.LetterToRow.get(currmove.charAt(0));
		startcol = Character.getNumericValue(currmove.charAt(1));
		destrow = Game.LetterToRow.get(currmove.charAt(3));
		destcol = Character.getNumericValue(currmove.charAt(4));
		
		System.out.println("Moving from row " + startrow + ", col " + startcol + " to row " + destrow+  ", col " + destcol );
		
		Action Actionmade = new Action(startrow,startcol,destrow,destcol);
		
		if(Action.checkvalidaction(Actionmade)) {
			Action.makemove(Actionmade);
			
		}
		
		else {
			System.out.println("Invalid Move");
			UserTurn();
		}
		
		printboard(boardarray);
		
		currstate = new State(Game.computer,boardarray);
		ComputerTurn();
	}
	
	public void ComputerTurn() {
		
	}
}
