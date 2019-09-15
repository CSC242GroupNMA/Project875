
public class Node {

	
	public State state;
	public Node Parent;
	public Action prevmove;
	public int PathCost;	//Cost of path from root to currentstate
	public int stepcost;
	public CheckerPiece newboard[][];
	public Node child;
	
	public Node(State state, Node Parent, int pathcost, Action prevmove) {
		this.Parent = Parent;
		this.state = state;
		this.PathCost = pathcost;
		this.prevmove=prevmove;
	}
	
	//LOOK IN BOOK
/*/	public Node ChildNode(Node parent, Action action) {
		
		State x = new State (problem.RESULT(parent.STATE, action);
		this.PARENT = parent;
		this.A = action;
		PATH-COST = parent.PATH-COST + problem.STEP-COST(parent.STATE, action);
	    return child;
*/	
	
	//public ChildNode();
	
	
	
}
