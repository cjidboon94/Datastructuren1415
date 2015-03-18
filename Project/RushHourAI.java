import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Collections;
import java.util.Arrays;

public class RushHourAI {
	BoardNode puzzle;
	
	public RushHourAI(BoardNode puzzle){
		this.puzzle = puzzle;
	}

	public int play(){
		ArrayList<BoardNode> solution = solver();
		System.out.println("And this is the best path:");
		for(BoardNode state : solution){
			BoardNode.printBoard(state.getBoard());
		}
		System.out.println("And That's all folks!");
		return 0;
	}

	private ArrayList<BoardNode> solver(){
		ArrayList<BoardNode> solution = search();
		System.out.println("Solved in " + solution.size() + " steps.");
		Collections.reverse(solution);
		return  solution;
	}

	private ArrayList<BoardNode> search(){
		System.out.println("Finding the best route");
		ArrayList<BoardNode> solution = new ArrayList<BoardNode>();
		ArrayList<char[][]> visited = new ArrayList<char[][]>();
		PriorityQueue<BoardNode> frontier = new PriorityQueue<BoardNode>(10, new Comparator<BoardNode>(){
			public int compare(BoardNode first, BoardNode second){
				return first.getCost() - second.getCost();
			}
		});
		frontier.offer(puzzle);
		visited.add(puzzle.getBoard());
		int expansion = 0;
		frontier.peek().printBoard(frontier.peek().getBoard());
		while(!won(frontier.peek().getBoard())) {
			System.out.println("We have expanded "+expansion+" times.");
			BoardNode.nextStates(frontier.poll(), frontier, visited);
			expansion++;
		}
		BoardNode end = frontier.poll();
		while(end.getPrevious() != null){
			solution.add(end);
		}
		return solution;
	}
	protected boolean won(char[][] board){ 
		return ( 	board[Math.round((float)board.length/2)-1][board.length-1] == '1'); 
	}
}