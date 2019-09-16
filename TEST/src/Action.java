import java.util.Iterator;
import java.util.LinkedList;

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
	public String color;
	public boolean valid;
	
	public Action(int startrow, int startcol, int destrow, int destcol, String color) {
		this.startrow = startrow;
		this.startcol = startcol;
		this.destrow = destrow;
		this.destcol=destcol;
		this.color = color;
	}
	
	
	public Action ValidMoves(int i, int j) {
		
		if(Problem.boardarray[i][j].color.equals("b") && !Problem.boardarray[i][j].Crowned) {
			
		}
		return null;
	}
	
	//Checks if move made is valid
	public static boolean checkvalidaction(Action x) {
		validmoveGen();
		return false;
	}
	
	public static LinkedList<LinkedList<Integer[][]>> validmoveGen(){
		LinkedList<LinkedList<Integer[][]>> moves = new LinkedList<LinkedList<Integer[][]>>();
		for (Iterator i = Game.user.pieces.iterator(); i.hasNext();) {
			   CheckerPiece temp = (CheckerPiece) i.next();
			   LinkedList<Integer[][]> temp1 = new LinkedList<Integer[][]>();
			   temp1 = findmoves(temp);
			   Integer[][] store = new Integer[2][2];
			   for (Iterator j = temp1.iterator(); j.hasNext();) {
				   store = (Integer[][]) j.next();
				   System.out.println(store[0][0] + "," + store[0][1] + " to " + store[1][0] + "," + store[1][1]);
			   }
		}
		return moves;
	}
	
	public static void jumptoarr(LinkedList<LinkedList<Integer[]>> jumpmoves, LinkedList<Integer[][]> piecemoves){
		Integer[] jumpstore = new Integer[2];
		for (Iterator i = jumpmoves.iterator(); i.hasNext();) {
			LinkedList<Integer[]> temp2 = (LinkedList<Integer[]>) i.next();
			Integer[][] store1 = new Integer[temp2.size()][2];
			int k =0;
			for (Iterator j = temp2.iterator(); j.hasNext();) {
				jumpstore = (Integer[]) j.next();
				store1[k][0] = jumpstore[0];
				store1[k][1] = jumpstore[1];
				k++;
			}
			piecemoves.add(store1);
		}
	}
	
	public static LinkedList<Integer[][]> findmoves(CheckerPiece temp) {
		LinkedList<Integer[][]> piecemoves = new LinkedList<Integer[][]>();
		Integer[] jumpstore = new Integer[2];
		Integer[][] store = new Integer[2][2];
		Integer col = temp.mycol-1;
		Integer row = temp.myrow;
		Integer arrsize = Problem.outofbounds;
		//System.out.println(temp.myrow);
		if(temp.color.equals("b")) {
			//first check two squares in front
			//first check two squares in front
			if(row+1<arrsize && col+1<arrsize) {
				if(Problem.boardarray[row+1][col+1].empty) {
					piecemoves.add(returnpoint(row,col,row+1,col+1));
				}
				else {
					if(Problem.boardarray[row+1][col+1].color.equals("w")) {
						LinkedList<LinkedList<Integer[]>> jumpmoves = new LinkedList<LinkedList<Integer[]>>();
						LinkedList<Integer[]> jumps = new LinkedList<Integer[]>();
						if(row+2 < arrsize && col+2>arrsize) {
							if(Problem.boardarray[row+2][col+2].empty) {
								jumps.add(returnpoint1D(row,col));
								recursivecheckerblack(jumps, jumpmoves, row+2, col+2);
							}
						}
					jumptoarr(jumpmoves, piecemoves);
					}
				}
			}
			if(row+1 < arrsize && col-1>-1) {
				if(Problem.boardarray[row+1][col-1].empty) {
					piecemoves.add(returnpoint(row,col,row+1,col-1));
				}
				else {
					if(Problem.boardarray[row+1][col-1].color.equals("w")) {
						LinkedList<LinkedList<Integer[]>> jumpmoves = new LinkedList<LinkedList<Integer[]>>();
						LinkedList<Integer[]> jumps = new LinkedList<Integer[]>();
						if(row+2 < arrsize && col-2>-1) {
							if(Problem.boardarray[row+2][col-2].empty) {
								jumps.add(returnpoint1D(row,col));
								recursivecheckerwhite(jumps, jumpmoves, row+2, col-2);
							}
						}
					jumptoarr(jumpmoves, piecemoves);
					}
				}
			}
			
		}
		else {
			//first check two squares in front
			if(row-1> -1 && col+1<arrsize) {
				if(Problem.boardarray[row-1][col+1].empty) {
					piecemoves.add(returnpoint(row,col,row-1,col+1));
				}
				else {
					if(Problem.boardarray[row-1][col+1].color.equals("b")) {
						LinkedList<LinkedList<Integer[]>> jumpmoves = new LinkedList<LinkedList<Integer[]>>();
						LinkedList<Integer[]> jumps = new LinkedList<Integer[]>();
						if(row-2 > -1 && col+2<arrsize) {
							if(Problem.boardarray[row-2][col+2].empty) {
								jumps.add(returnpoint1D(row,col));
								recursivecheckerwhite(jumps, jumpmoves, row-2, col+2);
							}
						}
					jumptoarr(jumpmoves, piecemoves);
					}
				}	
			}
			if(row-1 > -1 && col-1>-1) {
				if(Problem.boardarray[row-1][col-1].empty) {
					piecemoves.add(returnpoint(row,col,row-1,col-1));
				}
				else {
					if(Problem.boardarray[row-1][col-1].color.equals("b")) {
						LinkedList<LinkedList<Integer[]>> jumpmoves = new LinkedList<LinkedList<Integer[]>>();
						LinkedList<Integer[]> jumps = new LinkedList<Integer[]>();
						if(row-2 > -1 && col-2>-1) {
							if(Problem.boardarray[row-2][col-2].empty) {
								jumps.add(returnpoint1D(row,col));
								recursivecheckerwhite(jumps, jumpmoves, row-2, col-2);
							}
						}
						jumptoarr(jumpmoves, piecemoves);
					}
				}
			}
		}
		
		return piecemoves;
	}
	
	public static void recursivecheckerwhite(LinkedList<Integer[]> jumps,LinkedList<LinkedList<Integer[]>> jumpmoves,int row, int col) {
		Integer arrsize = Problem.outofbounds;
		jumps.add(returnpoint1D(row,col));
		boolean diversion = false;
		boolean leftexplored = false;
		boolean rightexplored = false;
		if(row-1 > -1 && col-1>-1) {
			if(Problem.boardarray[row-1][col-1].color.equals("b")) {
				if(row-2 > -1 && col-2>-1) {
					if(Problem.boardarray[row-2][col-2].empty) {
						diversion = true;
						recursivecheckerwhite(jumps,jumpmoves, row-2, col-2);
					}
					else {
						leftexplored = true;
					}
				}
				else {
					leftexplored = true;
				}
			}	
			else {
				leftexplored = true;
			}
		}
		else {
			leftexplored = true;
		}
		if(row-1 > -1 && col+1>arrsize) {
			if(Problem.boardarray[row-1][col+1].color.equals("b")) {
				if(row-2 > -1 && col+2>arrsize) {
					if(Problem.boardarray[row-2][col+2].empty) {
						if(diversion) {
							LinkedList<Integer[]> newjump = (LinkedList) jumps.clone(); 
							recursivecheckerwhite(newjump,jumpmoves, row-2, col+2);
						}
						else {
							recursivecheckerwhite(jumps,jumpmoves, row-2, col+2);
						}
					}
					else {
						rightexplored = true;
					}
				}
				else {
					rightexplored = true;
				}
			}
			else {
				rightexplored = true;
			}
		}
		else {
			rightexplored = true;
		}
		if(leftexplored && rightexplored) {
			jumpmoves.add(jumps);
		}
	}
	
	public static void recursivecheckerblack(LinkedList<Integer[]> jumps,LinkedList<LinkedList<Integer[]>> jumpmoves,int row, int col) {
		Integer arrsize = Problem.outofbounds;
		jumps.add(returnpoint1D(row,col));
		boolean diversion = false;
		boolean leftexplored = false;
		boolean rightexplored = false;
		if(row-1 > -1 && col-1>-1) {
			if(Problem.boardarray[row-1][col-1].color.equals("b")) {
				if(row-2 > -1 && col-2>-1) {
					if(Problem.boardarray[row-2][col-2].empty) {
						diversion = true;
						recursivecheckerwhite(jumps,jumpmoves, row-2, col-2);
					}
					else {
						leftexplored = true;
					}
				}
				else {
					leftexplored = true;
				}
			}	
			else {
				leftexplored = true;
			}
		}
		else {
			leftexplored = true;
		}
		if(row-1 > -1 && col+1>arrsize) {
			if(Problem.boardarray[row-1][col+1].color.equals("b")) {
				if(row-2 > -1 && col+2>arrsize) {
					if(Problem.boardarray[row-2][col+2].empty) {
						if(diversion) {
							LinkedList<Integer[]> newjump = (LinkedList) jumps.clone(); 
							recursivecheckerwhite(newjump,jumpmoves, row-2, col+2);
						}
						else {
							recursivecheckerwhite(jumps,jumpmoves, row-2, col+2);
						}
					}
					else {
						rightexplored = true;
					}
				}
				else {
					rightexplored = true;
				}
			}
			else {
				rightexplored = true;
			}
		}
		else {
			rightexplored = true;
		}
		if(leftexplored && rightexplored) {
			jumpmoves.add(jumps);
		}
	}
	
	public static Integer[][] returnpoint(int row, int col, int rownew, int colnew) {
		Integer[][] store = new Integer[2][2];
		store[0][0] = row;
		store[0][1] = col;
		store[1][0] = rownew;
		store[1][1] = colnew;
		return store;
	}
	
	public static Integer[] returnpoint1D(int row, int col) {
		Integer[] store = new Integer[2];
		store[0] = row;
		store[1] = col;
		return store;
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
	
	//actionmade
	//public static void 
	
	//Returns the sequence of actions taken to reach solution
	public void Solution() {
		
	}
	
}
