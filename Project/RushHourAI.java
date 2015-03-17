import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class RushHourAI extends RushHour{
	

	private PriorityQueue<Node> frontier;

	private class Node {
		char[][] state;
		int cost;
		char lastmoved;

		Node(char[][] state, int cost, char lastmoved){
			this.state = state;
			this.cost = cost;
			this.lastmoved = lastmoved;
		}
	}


	public RushHourAI(Board puzzle){
		super(puzzle);
		visited = new ArrayList<Node>();
		frontier = new PriorityQueue<Node>(10, new Comparator<Node>(){
			public int compare(Node first, Node second){
				return first.cost - second.cost;
			}
		});
		frontier.offer(new Node(puzzle.board, 0, 0));
	}

	public int play(){
		ArrayList<char[][]> solution = solver();
		for(char[][] state : solution){
			for(int i = 0; i < puzzle.getSize(); i++){
				for(int j = 0; j < puzzle.getSize(); j ++){
					if(puzzle.board[i][j] == 0){
						System.out.printf("0");
					} else {
						System.out.printf(""+puzzle.board[i][j]);
					}
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println("And That's all folks!");
		return 0;
	}

	private ArrayList<char[][]> solver(){
		ArrayList<char[][]> solution = null;
		solution = getNextStates(solution);
		frontier.clear();
		visited.clear();
		System.out.pritnln("Solved in " + solution.size() + " steps.");
		return solution; 
	}

	private  getNextStates(ArrayList<char[][]> path) {
		/* Get the next best move */
		Node next = frontier.peek();
		/* If the solution is found, return */;
		if(won(next.state)){
			return path;
		} else {
			if(path == null) {
				path = new ArrayList<char[][]>();
			} 
			path.add(next.state);
			Board nextboard = next.state;
			Board next1 = new Board(nextboard);
			Board next2 = new Board(nextboard);
			for(Vehicle vehic : next.getVehicles()){
				if(mainMove(-1, next1, vehic.getName())){
					addState(next1, next, vehic.getName());
				}
				if(mainMove(1, next2, vehic.getName())){
					addState(next2, next, vehic.getName());
				}
				next1 = new Board(nextboard);
				next2 = new Board(nextboard);
			}

			visisted.add(frontier.poll());
			return getNextStates(path);
		}
	}

	private void addState(Board state, Node previous, char vehic){
		
		if(next.lastmoved == vehic.getName()){
			frontier.offer(new Node(state, previous.cost, previous.lastmoved));
		} else{
			frontier.offer(new Node(state, previous.cost+1, vehic.getName()));
		}
	}
}