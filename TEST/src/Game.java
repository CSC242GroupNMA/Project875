import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
		
	static HashMap<Character,Integer> LetterToRow = new HashMap<Character,Integer>(); //Hashmap to store Letters corresponding to row numbers
	
	public static Player computer; 
	public static Player user;
	
	public static void main(String[] args) {
		
		LetterToRow.put('A',0);
		LetterToRow.put('B',1);
		LetterToRow.put('C',2);
		LetterToRow.put('D',3);
		
		String size; //Size of board
		Scanner input = new Scanner(System.in);
		System.out.println("Checkers by Mustafa");
		System.out.println("Choose your checkers:\n1. Small 4x4 Checkers.\n2. Standard 8x8 Checkers");
		size = input.next();
		System.out.println("Your choice: " + size);		
		
		System.out.println("Choose your opponent:\n1. An agent that plays randomly.\n2. An agent that uses MINIMAX.\n"
				+ "3. An agent that uses MINIMAX with alpha-beta pruning\n"
				+ "4. An agent that uses H-MINIMAX with a fixed depth cutoff and alpha-beta pruning");
		
		String choice = input.next(); 
		System.out.println("Your choice: " + choice);
		System.out.println("Do you want to play BLACK (B) or WHITE (W)?");
		String color = input.next();
		
		user = new Player(color, 2);
		if (color.equals("w")) {
			computer = new Player("b",2);
		}
		else {
			computer = new Player("w",2);
		}
		
		System.out.println("Next to play: Black");
		
		Problem prob= new Problem(Integer.parseInt(size), Integer.parseInt(choice)); //Problems with parameters size of board, and choice of game
		
	}

}
